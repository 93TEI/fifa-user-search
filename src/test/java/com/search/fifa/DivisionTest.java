package com.search.fifa;


import com.search.fifa.config.ApiKey;
import com.search.fifa.web.dto.MatchTypeDto;
import com.search.fifa.web.dto.UserDivisionDto;
import com.search.fifa.web.dto.UserResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DivisionTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private UserDivisionDto[] userDB;

    private final String UserInfoUrl = "https://api.nexon.co.kr/fifaonline4/v1.0/users/";

    @Test
    public void division()
    {
        String accessId = "11cfecd459e4de5dbbd60cf1";

        final HttpHeaders httpHeaders = new HttpHeaders();  //HttpHeaders는 서버에 데이터를 보내주는 방법
        httpHeaders.set("Authorization", ApiKey.API_KEY);
        final HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        userDB = restTemplate.exchange(UserInfoUrl +accessId+"/maxdivision", HttpMethod.GET, entity, UserDivisionDto[].class, accessId).getBody();
        for(int i =0; i<2;i++)
        {
            System.out.println(userDB[i].getMatchType());
            System.out.println(userDB[i].getDivision());
            System.out.println(userDB[i].getAchievementDate());
        }
    }
}