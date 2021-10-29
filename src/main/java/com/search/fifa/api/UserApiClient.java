package com.search.fifa.api;

import com.search.fifa.config.ApiKey;
import com.search.fifa.web.dto.MatchTypeDto;
import com.search.fifa.web.dto.UserDivisionDto;
import com.search.fifa.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class UserApiClient {

    private final RestTemplate restTemplate = new RestTemplate(); // new RestTemplate()를 붙여주니까 오류가 해결됨
    private final String API_KEY = ApiKey.API_KEY;

    public UserResponseDto requestUserInfo(String nickname) {
        String UserInfoUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname={nickname}";
        final HttpHeaders httpHeaders = new HttpHeaders();  //HttpHeaders는 서버에 데이터를 보내주는 방법
        httpHeaders.set("Authorization", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(UserInfoUrl, HttpMethod.GET, entity, UserResponseDto.class, nickname).getBody();
    }

    public MatchTypeDto[] requestMatchTypeMetaDate() {
        MatchTypeDto[] matchTypeDtoArray = null;

        try {
            matchTypeDtoArray =
                    restTemplate.getForEntity("https://static.api.nexon.co.kr/fifaonline4/latest/matchtype.json",
                            MatchTypeDto[].class).getBody();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return matchTypeDtoArray;
    }

    public UserDivisionDto[] requestDivision(String accessId)
    {

        String DivisionUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/users/{accessId}/maxdivision";
        final HttpHeaders httpHeaders = new HttpHeaders();  //HttpHeaders는 서버에 데이터를 보내주는 방법
        httpHeaders.set("Authorization", API_KEY);

        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        UserDivisionDto[] DivisionArray = restTemplate.exchange(DivisionUrl, HttpMethod.GET, entity, UserDivisionDto[].class, accessId).getBody();
        return DivisionArray;
    }
}