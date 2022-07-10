package c99.ams.userservice.service;

import c99.ams.userservice.dto.UserDTO;
import c99.ams.userservice.entity.User;
import c99.ams.userservice.service.template.IUserService;
import c99.ams.userservice.utils.enums.Gender;
import c99.ams.userservice.utils.exceptionhandler.bind.ExistsEntityException;
import c99.ams.userservice.utils.exceptionhandler.bind.NotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/24/2021 11:18 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    IUserService userService;

    static UserDTO signUpUser;

    static UserDTO updateUser;

    @BeforeAll
    static void init() {
        signUpUser = new UserDTO();
        signUpUser.setAddress("Vũng Tàu");
        signUpUser.setGender("MALE");
        signUpUser.setBirthday(new GregorianCalendar(1999, Calendar.AUGUST, 20).getTime());
        signUpUser.setEmail("trantheduyk13@gmail.com");
        signUpUser.setFullName("Trần Thế Duy");
        signUpUser.setPhoneNumber("0798455595");

        updateUser = new UserDTO();
    }

    @Test
    @DisplayName("Sign Up User: Exists email")
    void signUp1() {
        assertThrows(ExistsEntityException.class, () -> userService.signUp(signUpUser));
    }

    @Test
    @DisplayName("Sign Up User: Exists phone")
    void signUp2() {
        assertThrows(ExistsEntityException.class, () -> {
            signUpUser.setEmail("");
            userService.signUp(signUpUser);
        });
    }

    @Test
    @DisplayName("Sign Up User: Success")
    void signUp3() {
        signUpUser.setEmail("1@gmail.com");
        signUpUser.setPhoneNumber("1");
        String expectedResult = "Sign up successful";
        String actualResult = userService.signUp(signUpUser);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Update Information User: Exists email")
    void updateInformation1() {
        assertThrows(ExistsEntityException.class, () -> {
            updateUser.setEmail("trantheduyk13@gmail.com");
            userService.updateInformation(4L, updateUser);
        });
    }

    @Test
    @DisplayName("Update Information User: Exists phone number")
    void updateInformation2() {
        assertThrows(ExistsEntityException.class, () -> {
            updateUser.setPhoneNumber("0798455595");
            userService.updateInformation(4L, updateUser);
        });
    }

    @Test
    @DisplayName("Update Information User: Success")
    void updateInformation3() {
        assertThrows(ExistsEntityException.class, () -> {
            updateUser.setEmail("trantheduy@gmail.com");
            updateUser.setPhoneNumber("0798455596");
            userService.signUp(signUpUser);
        });
    }

    @Test
    @DisplayName("Delete User By Id: User Not Found")
    void delete1() {
        assertThrows(NotFoundException.class, () -> userService.delete(3L));
    }

    @Test
    @DisplayName("Delete User By Id: Success")
    void delete2() {
        String expectedResult = "Delete successful";
        String actualResult = userService.delete(5L);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Find User By Id: User not found")
    @WithMockUser(username = "trantheduyk13@gmail.com")
    void findById1() {
        assertThrows(NotFoundException.class, () -> userService.findById(3L));
    }

    @Test
    @DisplayName("Find User By Id: Access Denied")
    @WithMockUser(username = "trantheduyk14@gmail.com")
    void findById2() {
        assertThrows(AccessDeniedException.class, () -> userService.findById(1L));
    }

    @Test
    @DisplayName("Find User By Id: Success")
    @WithMockUser(username = "trantheduyk13@gmail.com")
    void findById3() {
        User expectedUser = new User(1L, signUpUser.getFullName(), signUpUser.getEmail(), signUpUser.getPhoneNumber()
                , Enum.valueOf(Gender.class, signUpUser.getGender()), signUpUser.getBirthday(),
                signUpUser.getAddress());
        User actualUser = userService.findById(1L);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    @DisplayName("Find User By Email: User not found")
    @WithMockUser(username = "trantheduyk13@gmail.com")
    void findByEmail1() {
        assertThrows(NotFoundException.class, () -> userService.findByEmail("dasdasdas"));
    }

    @Test
    @DisplayName("Find User By Email: Access Denied")
    @WithMockUser(username = "trantheduyk14@gmail.com")
    void findByEmail2() {
        assertThrows(AccessDeniedException.class, () -> userService.findByEmail("trantheduyk13@gmail.com"));
    }

    @Test
    @DisplayName("Find User By Email: Success")
    @WithMockUser(username = "trantheduyk13@gmail.com")
    void findByEmail3() {
        User expectedUser = new User(1L, signUpUser.getFullName(), signUpUser.getEmail(), signUpUser.getPhoneNumber()
                , Enum.valueOf(Gender.class, signUpUser.getGender()), signUpUser.getBirthday(),
                signUpUser.getAddress());
        User actualUser = userService.findByEmail("trantheduyk13@gmail.com");
        assertEquals(expectedUser, actualUser);
    }
}