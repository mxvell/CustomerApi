package ua.prachyk.usersAPI.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.prachyk.usersAPI.exception.InvalidEmailException;
import ua.prachyk.usersAPI.exception.UserNotFoundException;
import ua.prachyk.usersAPI.exception.UsersByDateOfBirthBetweenException;
import ua.prachyk.usersAPI.model.User;


import java.time.LocalDate;

@SpringBootTest
class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void registerUserOK() {
        Assertions.assertDoesNotThrow(
                () -> {
                    userService.registerUser("Glad", "Valakas",
                            "gladik-vladik@gmail.com", LocalDate.of(2000, 3, 24),
                            "abc street", "+123123123");
                }
        );
    }

    @Test
    public void registerUserExceptionThrownBecauseBadEmail() {
        Class<? extends Exception> myException = InvalidEmailException.class;
        Assertions.assertThrows(myException, () -> {
            userService.registerUser("Glad", "Valakas",
                    "gladik-vlad'ik@gmail.com", LocalDate.of(2000, 3, 24),
                    "abc street", "+123123123");
        });
    }

    @Test
    public void searchUserByIdOk() {
        User user = new User(1L, "Glad", "Valakas",
                "gladik-vladik@gmail.com", LocalDate.of(2000, 3, 24),
                "abc street", "+123123123");
        Assertions.assertDoesNotThrow(
                () -> userService.findById(user.getId())
        );
    }

    @Test
    public void searchUserShouldThrowException() {
        Class<? extends Exception> myException = UserNotFoundException.class;
        Assertions.assertThrows(myException, () -> {
            userService.findById(99L);
        });
    }

    @Test
    public void updateUserOk() {
        User user = userService.findById(1L);
        user.setFirstName("Poma");
        user.setLastName("Glushko");
        user.setEmail("poma@gmail.com");
        user.setDateOfBirth(LocalDate.of(2001, 1, 19));
        user.setAddress("bca st. 11");
        user.setPhone("+380633443370");
        Assertions.assertDoesNotThrow(
                () -> userService.updateUser(user)
        );
    }

    @Test
    public void updateEmailOk() {
        User user = userService.findById(1L);
        user.setEmail("asdf@gmail.com");
        Assertions.assertDoesNotThrow(
                () -> userService.updateEmail(user)
        );
    }

    @Test
    public void doesNotUpdateEmailBecauseHisInvalid() {
        User user = userService.findById(1L);
        user.setEmail("!?rewrw@gmai;.com");
        Class<? extends Exception> myException = InvalidEmailException.class;
        Assertions.assertThrows(myException, () -> {
            userService.updateEmail(user);
        });

    }

    @Test
    public void updateUserFieldsOk() {
        User user = userService.findById(1L);
        user.setEmail("nina@gmail.com");
        user.setAddress("bba st. 11");
        user.setPhone("+3904544332");
        Assertions.assertDoesNotThrow(
                () -> userService.updateFields(user)
        );
    }

    @Test
    public void findUsersByDateOfBirthBetweenShouldReturnUsersWhenDatesAreValid() {
        LocalDate from = LocalDate.of(2000, 5, 15);
        LocalDate to = LocalDate.of(2005, 5, 15);
        Assertions.assertDoesNotThrow(
                () -> userService.findUsersByDateOfBirthBetween(from, to)
        );
    }

    @Test
    public void findUsersByDateOfBirthBetweenShouldThrowException() {
        LocalDate from = LocalDate.of(2010, 5, 15);
        LocalDate to = LocalDate.of(2005, 5, 15);
        Class<? extends Exception> myException = UsersByDateOfBirthBetweenException.class;
        Assertions.assertThrows(myException, () -> {
            userService.findUsersByDateOfBirthBetween(from, to);
        });
    }

    @Test
    public void deleteUserByIdSuccessful() {
        User user = userService.findById(5L);
        Assertions.assertDoesNotThrow(() ->
                userService.deleteById(user.getId())
        );
    }
}


















