package com.github.leifh.springangular.jwt;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String loginUrl = "/auth/login";

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    @Value("${jwt.expiration.time}")
    private long jwtExpirationTime;

    public AbstractAuthenticationProcessingFilter authenticationFilter() throws Exception {

        JWTAuthenticationFilter jwtAuthenticationProcessingFilter = new JWTAuthenticationFilter(
                new AntPathRequestMatcher(loginUrl),
                jwtSecretKey,
                jwtExpirationTime
        );
        jwtAuthenticationProcessingFilter.setAuthenticationManager(this.authenticationManager());
        return jwtAuthenticationProcessingFilter;

    }

    public JWTAuthorizationFilter authorizationFilter() throws Exception {
        JWTAuthorizationFilter jwtAuthorizationFilter = new JWTAuthorizationFilter(this.authenticationManager(), jwtSecretKey);
        return jwtAuthorizationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .csrf().disable()
            .authorizeRequests()
                .antMatchers(loginUrl).permitAll()
                // todo disable for prod
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()

            .and()
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            // need to make H2 console working
            // todo disable for prod
            .headers().frameOptions().disable();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
