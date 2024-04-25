package ua.prachyk.usersAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.prachyk.usersAPI.model.User;
import ua.prachyk.usersAPI.repository.UserRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    @Value("${app.min.age}")
    private int minAge;


    public User findById(Long id){
        Optional<User> foundUser =  userRepository.findById(id);
        return foundUser.orElse(null);
    }
    public User updateAllUserFields(Long id, String firstName, String lastName, String email, LocalDate yearOfBirth){
        User user = findById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setYearOfBirth(yearOfBirth);
        return userRepository.save(user);
    }
    public User registerUser(String firstName, String lastName, String email, LocalDate yearOfBirth){
        if (!isValidAge(yearOfBirth)){
            throw new IllegalArgumentException("User must be at least " + minAge + " years old");
        }
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setYearOfBirth(yearOfBirth);
        return userRepository.save(user);
    }
    public List<User> findUsersByDateOfBirthBetween(LocalDate from, LocalDate to){

    }


    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    private boolean isValidAge(LocalDate yearOfBirth){
        LocalDate today = LocalDate.now();
        int age = Period.between(yearOfBirth, today).getYears();
        return age >= minAge;
    }
}
