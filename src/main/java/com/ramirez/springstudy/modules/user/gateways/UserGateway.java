package com.ramirez.springstudy.modules.user.gateways;

import com.ramirez.springstudy.modules.user.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserGateway {

    User save(User user);
    Page<User> findAll(Pageable pageable);
}
