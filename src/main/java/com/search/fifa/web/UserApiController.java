package com.search.fifa.web;

import com.search.fifa.service.UserService;
import com.search.fifa.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/v1/user/{nickname}")
    public String get(@PathVariable String nickname) {
        UserResponseDto userResponseDto = userService.searchUserInfo(nickname);
        System.out.println("APIController : " + userResponseDto.getAccessId()+","+userResponseDto.getNickname()+","+userResponseDto.getLevel());
        return userService.userInfoSave(userResponseDto);
    }
}