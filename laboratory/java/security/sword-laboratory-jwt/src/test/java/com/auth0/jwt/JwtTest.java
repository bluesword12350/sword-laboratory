package com.auth0.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Base64;

class JwtTest {

    @Test
    void decode(){
        DecodedJWT decode = JWT.decode(createToken());
        String payload = decode.getPayload();
        String info = new String(Base64.getDecoder().decode(payload));
        System.out.println(info);
    }

    @Test
    void create(){
        System.out.println(createToken());
    }

    private String createToken() {
        return JWT.create().withIssuer("123").sign(Algorithm.none());
    }
}