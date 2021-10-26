package com.search.fifa.web;

import com.search.fifa.service.UserService;
import com.search.fifa.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/v1/user/{nickname}")
    public String requestUserInfo(@PathVariable String nickname) {  // @PathVariable : URI의 일부를 변수로 보냄
        UserResponseDto userResponseDto = userService.searchUserInfo(nickname);
        return userService.userInfoSave(userResponseDto);
    }
}