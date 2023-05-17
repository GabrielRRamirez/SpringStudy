package com.ramirez.springstudy.modules.user.usecase;

import com.ramirez.springstudy.modules.user.gateways.UserGateway;
import com.ramirez.springstudy.modules.user.usecase.dto.UserDetailingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class FindUser {

    private final UserGateway userGateway;

    public FindUser(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public ResponseEntity<Page<UserDetailingDto>> execute(Pageable pageable) {
        return ResponseEntity.ok(userGateway.findAll(pageable).map(UserDetailingDto::new));
    }
}
