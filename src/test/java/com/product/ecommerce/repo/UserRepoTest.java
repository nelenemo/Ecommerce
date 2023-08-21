package com.product.ecommerce.repo;

import com.product.ecommerce.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Component
class UserRepoTest {
    @Autowired
    private UserRepo userRepoTest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void itShouldCheckIfItFindByuserName() {
String username="Nili"   ;
//given
        User user =new User(
                1L,
                username,
                "`Nili",
                "nilima@gmail.com",
                "ROLE_USER"
        );
        userRepoTest.save(user);


        //when

        Optional<User> byUserName = userRepoTest.findByuserName(username);

        assertTrue(byUserName.isPresent());
        assertEquals(username,byUserName.get().getUserName());


    }
}
