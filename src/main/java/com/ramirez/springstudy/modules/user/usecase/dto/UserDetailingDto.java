package com.ramirez.springstudy.modules.user.usecase.dto;

import com.ramirez.springstudy.modules.user.domain.entities.User;

public record UserDetailingDto(Long id, String login) {

    public UserDetailingDto(User user) {
        this(user.getId(), user.getLogin());
    }
}
