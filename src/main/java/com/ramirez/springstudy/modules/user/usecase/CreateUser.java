package com.ramirez.springstudy.modules.user.usecase;

import com.ramirez.springstudy.modules.doctor.usecase.dto.DoctorDetailingDto;
import com.ramirez.springstudy.modules.user.domain.entities.User;
import com.ramirez.springstudy.modules.user.gateways.UserGateway;
import com.ramirez.springstudy.modules.user.usecase.dto.UserDetailingDto;
import com.ramirez.springstudy.modules.user.usecase.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.util.UriComponentsBuilder;

public class CreateUser {

    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    public CreateUser(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<UserDetailingDto> execute(UserDto userDto, UriComponentsBuilder uriBuilder) {
        User user = new User(userDto.login(), passwordEncoder.encode(userDto.password()));
        userGateway.save(user);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailingDto(user));
    }
}
