package ua.prachyk.usersAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.prachyk.usersAPI.exception.DeleteUserWithIdException;
import ua.prachyk.usersAPI.exception.UnderAgeUserException;
import ua.prachyk.usersAPI.exception.UserNotFoundException;
import ua.prachyk.usersAPI.exception.UsersByDateOfBirthBetweenException;
import ua.prachyk.usersAPI.model.User;
import ua.prachyk.usersAPI.repository.UserRepository;
import ua.prachyk.usersAPI.valid.UserValidator;

import java.time.LocalDate;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserValidator userValidator;
    @Value("${app.min.age}")
    private int minAge;


    public User findById(Long id) {
        return  userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User with ID " + id + " not found."));
    }

    public void updateUser(User userUpdated) {
        User user = findById(userUpdated.getId());
        user.setFirstName(userUpdated.getFirstName());
        user.setLastName(user.getLastName());
        userValidator.isValidUserEmail(userUpdated.getEmail());
        user.setEmail(userUpdated.getEmail());
        user.setDateOfBirth(userUpdated.getDateOfBirth());
        user.setAddress(user.getAddress());
        user.setPhone(user.getPhone());
        userRepository.save(user);
    }

    public void updateEmail(User userUpdated) {
        User user = findById(userUpdated.getId());
        userValidator.isValidUserEmail(userUpdated.getEmail());
        user.setEmail(userUpdated.getEmail());
        userRepository.save(user);
    }

    public void updateSomeFields(User userUpdated) {
        User user = findById(userUpdated.getId());
        userValidator.isValidUserEmail(userUpdated.getEmail());
        user.setEmail(userUpdated.getEmail());
        user.setAddress(userUpdated.getAddress());
        user.setPhone(userUpdated.getPhone());
        userRepository.save(user);
    }

    public void registerUser(String firstName, String lastName, String email,
                             LocalDate dateOfBirth, String address, int phone) {
        if (!userValidator.isValidUserAge(dateOfBirth)) {
            throw new UnderAgeUserException("Cannot create a user younger than " + minAge + " years old");
        }
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setAddress(address);
        user.setPhone(phone);
        userRepository.save(user);
    }

    public List<User> findUsersByDateOfBirthBetween(LocalDate from, LocalDate to) {
        if (from.isAfter(to)) {
            throw new UsersByDateOfBirthBetweenException(from + " date must be less than " + to + " date");
        }
        return userRepository.findByDateOfBirthBetween(from, to);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
        throw new DeleteUserWithIdException("Deleted user with " + id + " excellent");
    }


}
