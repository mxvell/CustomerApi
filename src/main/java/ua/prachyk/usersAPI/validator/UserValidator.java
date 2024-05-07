package ua.prachyk.usersAPI.validator;

import org.springframework.beans.factory.annotation.Value;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class UserValidator {

    public static int MIN_AGE;
    public static final List<Character> FORBIDDEN_CHARS = Arrays.asList('!', '#', '$', '%', '^', '&', '*', '(', ')', '+', '\\', '|', '\'', '"', '/', '<', '>', '?');
    private static String regex = ".*?@.*\\..*";


    public static boolean isValidUserEmail(String email) {
        if (email == null) {
            return false;
        }
        if (!email.matches(regex)) {
            return false;
        }

        for (char chairs : email.toCharArray()) {
            if (FORBIDDEN_CHARS.contains(chairs)) {
                return false;
            }
        }
        if (email.split("@").length > 2) {
            return false;
        }
        return email.matches(regex);
    }

    public static boolean isValidUserAge(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        int age = Period.between(dateOfBirth, today).getYears();
        return age >= MIN_AGE;
    }

    @Value("${app.min.age}")
    public void setMinAge(int minAge) {
        MIN_AGE = minAge;
    }
}
