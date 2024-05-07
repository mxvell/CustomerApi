package ua.prachyk.usersAPI.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.prachyk.usersAPI.model.User;
import ua.prachyk.usersAPI.repository.UserRepository;
import ua.prachyk.usersAPI.service.UserService;
import ua.prachyk.usersAPI.validator.UserValidator;

import java.time.LocalDate;
import java.util.Optional;

public class ValidateTest {

    @Test
    public void testValidUserEmailOK() {
        boolean isValid = UserValidator.isValidUserEmail("qwerty@gmail.com");
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testInvalidUserEmailBecauseEmailContainsForbiddenCharacterAll() {
        for (char forbiddenChar : UserValidator.FORBIDDEN_CHARS) {
            boolean invalid = UserValidator.isValidUserEmail("qwe@gm" + forbiddenChar + "ail.com");
            Assertions.assertFalse(invalid);
        }
    }

    @Test
    public void testUpdateFieldsOfUserUsingServiceOK() {
        UserRepository repo = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(repo);

        User user = new User(1L, "Glad", "Valakas", "gladik-vladik@gmail.com",
                LocalDate.of(2000, 3, 24), "abc street", "123123123");

        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(repo.save(user)).thenReturn(user);

        Assertions.assertDoesNotThrow(() -> userService.updateFields(user));
    }

    @Test
    public void testUpdateSomeFieldsOfUserUsingServiceInvalidAge() {
        UserRepository repo = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(repo);

        User user = new User(1L, "Glad", "Valakas", "glad%ik-vladik@gmail.com",
                LocalDate.of(LocalDate.now().getYear(), 3, 24), "abc street", "123123123");

        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(user));
//        Mockito.when(repo.save(user)).thenReturn(user); -- causes error

        Assertions.assertThrows(RuntimeException.class, () -> userService.updateFields(user));
    }


}
