package com.ramirez.springstudy.modules.user.repository;

import com.ramirez.springstudy.modules.user.domain.entities.User;
import com.ramirez.springstudy.modules.user.gateways.UserGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserGateway {

    UserDetails findByLogin(String login);
    Page<User> findAll(Pageable pageable);
}
