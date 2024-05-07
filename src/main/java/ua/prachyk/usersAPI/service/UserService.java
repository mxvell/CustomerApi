package ua.prachyk.usersAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.prachyk.usersAPI.exception.UserNotFoundException;
import ua.prachyk.usersAPI.exception.UsersByDateOfBirthBetweenException;
import ua.prachyk.usersAPI.model.User;
import ua.prachyk.usersAPI.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
    }

    public void updateUser(User userUpdated) {
        User user = findById(userUpdated.getId());
        user.setFirstName(userUpdated.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(userUpdated.getEmail());
        user.setDateOfBirth(userUpdated.getDateOfBirth());
        user.setAddress(user.getAddress());
        user.setPhone(user.getPhone());
        userRepository.save(user);
    }

    public void updateEmail(User userUpdated) {
        User user = findById(userUpdated.getId());
        user.setEmail(userUpdated.getEmail());
        userRepository.save(user);
    }

    public void updateFields(User userUpdated) {
        User user = findById(userUpdated.getId());
        user.setEmail(userUpdated.getEmail());
        user.setAddress(userUpdated.getAddress());
        user.setPhone(userUpdated.getPhone());
        userRepository.save(user);
    }

    public void registerUser(String firstName, String lastName, String email,
                             LocalDate dateOfBirth, String address, String phone) {
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
    }


}
