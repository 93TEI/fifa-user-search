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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup()
    {
        userRepository.deleteAll();
    }

    @Test
    public void 저장_불러오기(){
        //given
        String accessId = "test123";
        String nickname = "크로스할까요";
        int level = 1000;

        userRepository.save(User.builder()
                .accessId(accessId)
                .nickname(nickname)
                .level(level).build()
        );

        //when
        List<User> TestUser = userRepository.findAll();

        //then
        User user = TestUser.get(0);
        assertThat(user.getAccessId()).isEqualTo(accessId);
        assertThat(user.getNickname()).isEqualTo(nickname);
        assertThat(user.getLevel()).isEqualTo(level);

        System.out.println(user.getAccessId());
        System.out.println(user.getNickname());

    }
}
