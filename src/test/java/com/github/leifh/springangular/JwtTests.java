package com.github.leifh.springangular;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;

import java.security.Key;
import java.util.Date;

public class JwtTests {

    @Test
    public void testJwtApi() {
        String key = "aPassword";

        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();

        System.out.println(compactJws);


        Jws<Claims> test =  Jwts.parser().setSigningKey(key.getBytes()).parseClaimsJws(compactJws);

        System.out.println(test);

    }
}
