package ua.prachyk.usersAPI.valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
@Configuration
public class UserValidator {
    @Value("${app.min.age}")
    private int minAge;
    private  String regex = ".*?@.*\\..*";
    private final List<Character> forbiddenChairs = Arrays.asList('!', '#', '$', '%', '^', '&', '*', '(', ')', '+', '\\', '|', '\'', '"', '/', '<', '>', '?');

    public boolean isValidUserEmail(String email) {
        if (email == null) {
            return false;
        }
        if (!email.matches(regex)) {
            return false;
        }

        for (char chairs : email.toCharArray()) {
            if (forbiddenChairs.contains(chairs)) {
                return false;
            }
        }
        if (email.split("@").length > 2) {
            return false;
        }
        return email.matches(regex);
    }

    public boolean isValidUserAge(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        int age = Period.between(dateOfBirth, today).getYears();
        return age >= minAge;
    }
}
