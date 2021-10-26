package com.search.fifa.service;

import com.search.fifa.api.UserApiClient;
import com.search.fifa.domain.User;
import com.search.fifa.domain.UserRepository;
import com.search.fifa.web.dto.UserInfoResponseDto;
import com.search.fifa.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserApiClient userApiClient;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDto searchUserInfo(String nickname) {
        return userApiClient.requestUserInfo(nickname);
    }

    @Transactional
    public String userInfoSave(UserResponseDto userResponseDto)
    {
        System.out.println("유저 서비스에서 세이브 : " + userRepository.save(userResponseDto.toEntity()).getNickname());
        return userRepository.save(userResponseDto.toEntity()).getNickname();
    }

    public UserInfoResponseDto userInfoFindById(String nickname) {
        User entity = userRepository.findById(nickname).orElseThrow(() -> new IllegalArgumentException("구단주가 존재하지 않습니다!"));

        return new UserInfoResponseDto(entity);
    }
}