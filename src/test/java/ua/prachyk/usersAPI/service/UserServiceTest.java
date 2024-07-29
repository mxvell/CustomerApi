package ua.prachyk.usersAPI.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

//    @Autowired
//    public UserService userService;
//
//    @Test
//    public void registerUserOK() {
//        Assertions.assertDoesNotThrow(
//                () -> {
//                    userService.registerUser("Glad", "Valakas",
//                            "gladik-vladik@gmail.com", LocalDate.of(2000, 3, 24),
//                            "abc street", "+123123123");
//                }
//        );
//    }
//
//    @Test
//    public void registerUserExceptionThrownBecauseBadEmail() {
//        Class<? extends Exception> myException = InvalidEmailException.class;
//        Assertions.assertThrows(myException, () -> {
//            userService.registerUser("Glad", "Valakas",
//                    "gladik-vlad'ik@gmail.com", LocalDate.of(2000, 3, 24),
//                    "abc street", "+123123123");
//        });
//    }
//
//    @Test
//    public void searchUserByIdOk() {
//        Customer customer = new Customer(1L, "Glad", "Valakas",
//                "gladik-vladik@gmail.com", LocalDate.of(2000, 3, 24),
//                "abc street", "+123123123");
//        Assertions.assertDoesNotThrow(
//                () -> userService.findById(customer.getId())
//        );
//    }
//
//    @Test
//    public void searchUserShouldThrowException() {
//        Class<? extends Exception> myException = UserNotFoundException.class;
//        Assertions.assertThrows(myException, () -> {
//            userService.findById(99L);
//        });
//    }
//
//    @Test
//    public void updateUserOk() {
//        Customer customer = userService.findById(1L);
//        customer.setFirstName("Poma");
//        customer.setLastName("Glushko");
//        customer.setEmail("poma@gmail.com");
//        customer.setDateOfBirth(LocalDate.of(2001, 1, 19));
//        customer.setAddress("bca st. 11");
//        customer.setPhone("+380633443370");
//        Assertions.assertDoesNotThrow(
//                () -> userService.updateUser(customer)
//        );
//    }
//
//    @Test
//    public void updateEmailOk() {
//        Customer customer = userService.findById(1L);
//        customer.setEmail("asdf@gmail.com");
//        Assertions.assertDoesNotThrow(
//                () -> userService.updateEmail(customer)
//        );
//    }
//
//    @Test
//    public void doesNotUpdateEmailBecauseHisInvalid() {
//        Customer customer = userService.findById(1L);
//        customer.setEmail("!?rewrw@gmai;.com");
//        Class<? extends Exception> myException = InvalidEmailException.class;
//        Assertions.assertThrows(myException, () -> {
//            userService.updateEmail(customer);
//        });
//
//    }
//
//    @Test
//    public void updateUserFieldsOk() {
//        Customer customer = userService.findById(1L);
//        customer.setEmail("nina@gmail.com");
//        customer.setAddress("bba st. 11");
//        customer.setPhone("+3904544332");
//        Assertions.assertDoesNotThrow(
//                () -> userService.updateFields(customer)
//        );
//    }
//
//    @Test
//    public void findUsersByDateOfBirthBetweenShouldReturnUsersWhenDatesAreValid() {
//        LocalDate from = LocalDate.of(2000, 5, 15);
//        LocalDate to = LocalDate.of(2005, 5, 15);
//        Assertions.assertDoesNotThrow(
//                () -> userService.findUsersByDateOfBirthBetween(from, to)
//        );
//    }
//
//    @Test
//    public void findUsersByDateOfBirthBetweenShouldThrowException() {
//        LocalDate from = LocalDate.of(2010, 5, 15);
//        LocalDate to = LocalDate.of(2005, 5, 15);
//        Class<? extends Exception> myException = UsersByDateOfBirthBetweenException.class;
//        Assertions.assertThrows(myException, () -> {
//            userService.findUsersByDateOfBirthBetween(from, to);
//        });
//    }
//
//    @Test
//    public void deleteUserByIdSuccessful() {
//        Customer customer = userService.findById(5L);
//        Assertions.assertDoesNotThrow(() ->
//                userService.deleteById(customer.getId())
//        );
//    }
}


















