package c99.ams.oauthservice.service;

import c99.ams.oauthservice.interceptor.EntityException;
import c99.ams.oauthservice.model.Role;
import c99.ams.oauthservice.model.User;
import c99.ams.oauthservice.service.template.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 7/1/2021 9:19 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("Sign up: exists email")
    void signUp1() {
        assertThrows(EntityException.class, ()->{
            User user = new User();
            user.setEmail("trantheduyk13@gmail.com");
            user.setPassword("123456");
            user.setRoles(new HashSet<>(Arrays.asList(new Role(1L, "ROLE_CUSTOMER"))));
            userService.signUp(user);
        });
    }

    @Test
    @DisplayName("Sign up: success")
    void signUp2() {
        User user = new User();
        user.setEmail("trantheduyk14@gmail.com");
        user.setPassword("123456");
        user.setRoles(new HashSet<>(Arrays.asList(new Role(1L, "ROLE_CUSTOMER"))));
        String expectedResult = "Sign up success";
        String actualResult = userService.signUp(user);
        assertEquals(expectedResult, actualResult);
    }
}