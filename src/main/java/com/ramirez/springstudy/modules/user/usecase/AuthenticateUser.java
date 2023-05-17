package com.ramirez.springstudy.modules.user.usecase;

import com.ramirez.springstudy.infra.security.token.GenerateTokenService;
import com.ramirez.springstudy.modules.user.domain.entities.User;
import com.ramirez.springstudy.modules.user.usecase.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateUser {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GenerateTokenService generateTokenService;

    public ResponseEntity authenticate(UserDto authenticationData) throws Exception {
        User user = new User(authenticationData);

        var token = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        Authentication auth = authenticationManager.authenticate(token);

        return ResponseEntity.ok(generateTokenService.generate((User) auth.getPrincipal()));
    }
}
