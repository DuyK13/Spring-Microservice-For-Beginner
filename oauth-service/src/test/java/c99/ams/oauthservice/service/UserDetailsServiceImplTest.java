package c99.ams.oauthservice.service;

import c99.ams.oauthservice.model.AuthUserDetails;
import c99.ams.oauthservice.model.Role;
import c99.ams.oauthservice.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 7/1/2021 9:02 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserDetailsServiceImplTest {

    @Autowired
    UserDetailsService userDetailsService;

    @Test
    @DisplayName("Load user by email: not found")
    void loadUserByUsername1() {
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("trantheduyk14" +
                "@gmail" +
                ".com"));
    }

    @Test
    @DisplayName("Load user by email: success")
    void loadUserByUsername2() {
        AuthUserDetails expectedUser = new AuthUserDetails(new User(1L, "{bcrypt}$2a$10$nG0D5YvqgUtGQVKvhOea" +
                ".Oh5H2uxiIPli5ftmQSonfFzaO4Djco7C", "trantheduyk13@gmail.com",
                new HashSet<>(Arrays.asList(new Role(1L, "ROLE_CUSTOMER")))));
        AuthUserDetails actualUser = (AuthUserDetails) userDetailsService.loadUserByUsername("trantheduyk13@gmail.com");
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertEquals(expectedUser.getPassword(), actualUser.getPassword());
        assertArrayEquals(expectedUser.getAuthorities().toArray(), actualUser.getAuthorities().toArray());
    }
}