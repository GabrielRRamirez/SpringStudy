package com.ramirez.springstudy.infra.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ramirez.springstudy.modules.user.domain.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class GenerateTokenService {

    @Value("${api.security.password}")
    private String password;

    public String generate(User user) throws Exception {

        var algorithm = Algorithm.HMAC256(password);

        return JWT.create()
                .withIssuer("Doctor API")
                .withExpiresAt(genereateExpirationDate())
                .withSubject(user.getLogin())
                .withClaim("user-id", user.getId())
                .sign(algorithm);
    }

    private Instant genereateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
