package com.github.leifh.springangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.stereotype.Component;

@Component
@EnableGlobalAuthentication
public class SecurityTest {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        //auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }
}
