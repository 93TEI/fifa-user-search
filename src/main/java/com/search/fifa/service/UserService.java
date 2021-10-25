package com.search.fifa.service;

import com.search.fifa.api.UserApiClient;
import com.search.fifa.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserApiClient userApiClient;

    @Transactional(readOnly = true)
    public UserResponseDto searchUserInfo(String nickname) {
        return userApiClient.requestUserInfo(nickname);
    }
}