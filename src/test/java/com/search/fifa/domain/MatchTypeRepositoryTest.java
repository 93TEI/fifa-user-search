package com.search.fifa.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MatchTypeRepositoryTest {

    @Autowired
    MatchTypeRepository matchTypeRepository;

    @After
    public void cleanup()
    {
        matchTypeRepository.deleteAll();
    }

    @Test
    public void 저장_불러오기(){
        //given
        int matchtype = 30;
        String desc = "리그 친선";

        matchTypeRepository.save(MatchType.builder()
                .matchType(matchtype)
                .desc(desc).build()
        );

        //when
        List<MatchType> FindAllTemp = matchTypeRepository.findAll();

        //then
        MatchType temp = FindAllTemp.get(0);
        assertThat(temp.getMatchType()).isEqualTo(matchtype);
        assertThat(temp.getDesc()).isEqualTo(desc);

        System.out.println(temp.getMatchType());
        System.out.println(temp.getDesc());

    }
}
