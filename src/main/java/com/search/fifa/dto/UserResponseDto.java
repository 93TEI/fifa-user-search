package com.search.fifa.dto;

import com.search.fifa.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String accessId;
    private String nickname;
    private int level;

    public User toEntity()
    {
        return User.builder()
                .accessId(accessId)
                .nickname(nickname)
                .level(level)
                .build();
    }

    public UserResponseDto(User entity)
    {
        this.accessId = entity.getAccessId();
        this.nickname = entity.getNickname();
        this.level = entity.getLevel();
    }
}