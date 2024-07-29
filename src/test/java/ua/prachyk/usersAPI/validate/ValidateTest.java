package ua.prachyk.usersAPI.validate;

public class ValidateTest {

//    @Test
//    public void testValidUserEmailOK() {
//        boolean isValid = UserValidator.isValidUserEmail("qwerty@gmail.com");
//        Assertions.assertTrue(isValid);
//    }
//
//    @Test
//    public void testInvalidUserEmailBecauseEmailContainsForbiddenCharacterAll() {
//        for (char forbiddenChar : UserValidator.FORBIDDEN_CHARS_EMAIL) {
//            boolean invalid = UserValidator.isValidUserEmail("qwe@gm" + forbiddenChar + "ail.com");
//            Assertions.assertFalse(invalid);
//        }
//    }
//
//    @Test
//    public void testUpdateFieldsOfUserUsingServiceOK() {
//        UserRepository repo = Mockito.mock(UserRepository.class);
//        UserService userService = new UserService(repo);
//
//        Customer customer = new Customer(1L, "Glad", "Valakas", "gladik-vladik@gmail.com",
//                LocalDate.of(2000, 3, 24), "abc street", "123123123");
//
//        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(customer));
//        Mockito.when(repo.save(customer)).thenReturn(customer);
//
//        Assertions.assertDoesNotThrow(() -> userService.updateFields(customer));
//    }
//
//    @Test
//    public void testUpdateSomeFieldsOfUserUsingServiceInvalidAge() {
//        UserRepository repo = Mockito.mock(UserRepository.class);
//        UserService userService = new UserService(repo);
//
//        Customer customer = new Customer(1L, "Glad", "Valakas", "glad%ik-vladik@gmail.com",
//                LocalDate.of(LocalDate.now().getYear(), 3, 24), "abc street", "123123123");
//
//        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(customer));
////        Mockito.when(repo.save(user)).thenReturn(user); -- causes error
//
//        Assertions.assertThrows(RuntimeException.class, () -> userService.updateFields(customer));
//    }
//

}
