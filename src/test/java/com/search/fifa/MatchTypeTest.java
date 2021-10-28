package com.search.fifa;

import com.search.fifa.web.dto.MatchTypeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatchTypeTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private MatchTypeDto[] matchTypeDto = null;

    @Test
    public void MatchType()
    {
        matchTypeDto = restTemplate.getForEntity("https://static.api.nexon.co.kr/fifaonline4/latest/matchtype.json",
                MatchTypeDto[].class).getBody();
        for(int i=0; i<9; i++)
        {
            System.out.println(matchTypeDto[i].getMatchtype());
            System.out.println(matchTypeDto[i].getDesc());
        }
    }
}