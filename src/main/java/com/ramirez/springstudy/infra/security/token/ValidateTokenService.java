package com.ramirez.springstudy.infra.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValidateTokenService {

    @Value("${api.security.password}")
    private String jwtPassword;

    public String validate(String jwtToken) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(jwtPassword);
        return JWT.require(algorithm)
                .withIssuer("Doctor API")
                .build()
                .verify(jwtToken)
                .getSubject();
    }
}
