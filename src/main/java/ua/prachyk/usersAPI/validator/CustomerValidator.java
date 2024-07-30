package ua.prachyk.usersAPI.validator;

import ua.prachyk.usersAPI.dto.CustomerDTO;
import ua.prachyk.usersAPI.exception.InvalidEmailException;
import ua.prachyk.usersAPI.exception.InvalidPhoneException;

import java.util.Arrays;
import java.util.List;

public class CustomerValidator {


    public static final List<Character> FORBIDDEN_CHARS_EMAIL = Arrays.asList('!', '#', '$', '%', '^', '&', '*', '(', ')', '+', '\\', '|', '\'', '"', '/', '<', '>', '?');
    public static final List<Character> FORBIDDEN_CHARS_PHONE = Arrays.asList('!', '#', '$', '%', '^', '&', '*', '(', ')', '\\', '|', '\'', '"', '/', '<', '>', '?');

    private static String regexForEmail = ".*?@.*\\..*";
    private static String regexForPhone = "^\\+\\d{6,14}$";


    public static void validateCustomerDTO(CustomerDTO customerDTO){
        if (!CustomerValidator.isValidUserEmail(customerDTO.getEmail())){
            throw new InvalidEmailException("Invalid email format");
        }
        if (customerDTO.getPhone() != null && !customerDTO.getPhone().isEmpty() && !CustomerValidator.isValidPhone(customerDTO.getPhone())){
            throw new InvalidPhoneException("Phone number must have length between 6 and 14");
        }
    }
    public static boolean isValidUserEmail(String email) {
        if (email == null) {
            return false;
        }
        if (!email.matches(regexForEmail)) {
            return false;
        }

        for (char chars : email.toCharArray()) {
            if (FORBIDDEN_CHARS_EMAIL.contains(chars)) {
                return false;
            }
        }
        if (email.split("@").length > 2) {
            return false;
        }
        return email.matches(regexForEmail);
    }

    public static boolean isValidPhone(String phone) {
        if (phone.isEmpty()) {
            return false;
        }
        if (!phone.matches(regexForPhone)) {
            return false;
        }

        for (char chairs : phone.toCharArray()) {
            if (FORBIDDEN_CHARS_PHONE.contains(chairs)) {
                return false;
            }
        }
        return phone.matches(regexForPhone);
    }
}
