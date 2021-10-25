package com.search.fifa.web;

import com.search.fifa.dto.UserResponseDto;
import com.search.fifa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/v1/user/fifa/{nickname}")
    public String get(@PathVariable String nickname) {
        UserResponseDto userResponseDto = userService.searchUserInfo(nickname);
        return userService.userInfoSave(userResponseDto);
    }
}