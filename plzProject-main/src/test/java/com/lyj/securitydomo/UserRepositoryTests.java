package com.lyj.securitydomo;

import com.lyj.securitydomo.domain.User;
import com.lyj.securitydomo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = User.builder()
                    .userId((long) i)
                    .name("name" + i)
                    .username("username" + i)
                    .password("password" + i)
                    .email("email" + i)
                    .birthDate(LocalDate.parse("2020-10-10T00:00:00"))
                    .regDate(LocalDateTime.now())
                    .gender( "gender" + i)
                    .role("role" + i)
                    .address("부산" + i)
                    .build();

            User result = userRepository.save(user);
            log.info("BNO{}", result.getUserId());
        });
    }
}
