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
public class DivisionRepositoryTest {

    @Autowired
    DivisionRepository divisionRepository;

    @After
    public void cleanup()
    {
        divisionRepository.deleteAll();
    }

    @Test
    public void 저장_불러오기(){
        //given
        int matchtype = 52;
        String division = "1200";
        String ac = "2019-10-20";

        divisionRepository.save(Division.builder()
                .matchType(matchtype)
                .division(division)
                .achievementDate(ac).build()
        );

        //when
        List<Division> FindAllTemp = divisionRepository.findAll();

        //then
        Division temp = FindAllTemp.get(0);
        assertThat(temp.getMatchType()).isEqualTo(matchtype);
        assertThat(temp.getDivision()).isEqualTo(division);
        assertThat(temp.getAchievementDate()).isEqualTo(ac);

        System.out.println(temp.getMatchType());
        System.out.println(temp.getDivision());

    }
}
