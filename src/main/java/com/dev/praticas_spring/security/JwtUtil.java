package com.dev.praticas_spring.security;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;


public class JwtUtil {

    private static final SecretKey key = Jwts.SIG.HS256.key().build();

    private static final long EXPIRATION_TIME = 86400000;

    public static String generateToken(String username){

        return Jwts.builder()
            .subject(username)
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key, Jwts.SIG.HS256)
            .compact();

    }

    public static String extractUsername(String token){
        Claims claims = Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();

        return claims.getSubject();
    }

    public static boolean validateToken(String token){
        try {
            // Analisar token com a chave
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
