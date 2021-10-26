package com.search.fifa.web.dto;

import com.search.fifa.domain.User;
import lombok.Getter;

@Getter
public class UserInfoResponseDto {
    private String accessId;
    private String nickname;
    private int level;

    public UserInfoResponseDto(User entity) {
        this.accessId = entity.getAccessId();
        this.nickname = entity.getNickname();
        this.level = entity.getLevel();
    }
}