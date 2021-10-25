package com.search.fifa.service;

import com.search.fifa.api.UserApiClient;
import com.search.fifa.domain.User;
import com.search.fifa.domain.UserRepository;
import com.search.fifa.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService
{
    @Autowired
    private final UserApiClient userApiClient;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDto searchUserInfo(String nickname)
    {
        return userApiClient.requestUserInfo(nickname);
    }

    @Transactional
    public String userInfoSave(UserResponseDto userResponseDto)
    {
        return userRepository.save(userResponseDto.toEntity()).getNickname();
    }

    @Transactional
    public UserResponseDto findById(String nickname)
    {
        User entity = userRepository.findById(nickname).orElseThrow(()->new IllegalArgumentException("구단주가 존재하지 않습니다."));
        return new UserResponseDto(entity);
    }
}