package com.github.leifh.springangular;

import com.github.leifh.springangular.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles({ "test" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
public class JwtAuthTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @WithMockUser
    public void greetingShouldReturnDefaultMessage() throws Exception {

        HashMap<String, String> var = new HashMap<>();
        var.put("username", "user");
        var.put("password", "password1");


        String jwt = this.restTemplate.postForObject("http://localhost:" + port + "/auth/login?username={username}&password={password}", null,
                String.class, var);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwt);
        HttpEntity entity = new HttpEntity(headers);

        HashMap<String, String> var2 = new HashMap<>();
        var2.put("name", "world");

        ResponseEntity<String> response = this.restTemplate.exchange(
                "http://localhost:" + port + "/helloworld?name={name}",
                HttpMethod.GET,
                entity,
                String.class,
                var2);

        assertThat(response.getBody()).isEqualTo("hello world!");
    }
}
