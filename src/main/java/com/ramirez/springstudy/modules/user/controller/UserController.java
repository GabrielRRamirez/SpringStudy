package com.ramirez.springstudy.modules.user.controller;

import com.ramirez.springstudy.modules.user.repository.UserRepository;
import com.ramirez.springstudy.modules.user.usecase.AuthenticateUser;
import com.ramirez.springstudy.modules.user.usecase.CreateUser;
import com.ramirez.springstudy.modules.user.usecase.FindUser;
import com.ramirez.springstudy.modules.user.usecase.dto.UserDetailingDto;
import com.ramirez.springstudy.modules.user.usecase.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticateUser authenticateUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity authenticate(@RequestBody @Valid UserDto authenticateUserDto) throws Exception {
        return authenticateUser.authenticate(authenticateUserDto);
    }

    @PostMapping
    public ResponseEntity<UserDetailingDto> create(@RequestBody @Valid UserDto userData, UriComponentsBuilder uriBuilder) {
        return new CreateUser(userRepository, passwordEncoder).execute(userData, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<UserDetailingDto>> find(@PageableDefault(size = 10, sort = {"login"}) Pageable pageable) {
        return new FindUser(userRepository).execute(pageable);
    }
}
