package com.search.fifa.web;

import com.search.fifa.service.UserService;
import com.search.fifa.web.dto.UserInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/info/{nickname}")
    public String userInfo(@PathVariable String nickname, Model model) {
        UserInfoResponseDto userResponseDto = userService.userInfoFindById(nickname);
        System.out.println("IndexController : " + userResponseDto.getAccessId()+","+userResponseDto.getNickname()+","+userResponseDto.getLevel());
        model.addAttribute("user", userResponseDto);
        return "user-info";
    }

}
