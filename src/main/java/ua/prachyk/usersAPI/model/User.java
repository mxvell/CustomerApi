package ua.prachyk.usersAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.prachyk.usersAPI.exception.InvalidEmailException;
import ua.prachyk.usersAPI.exception.UnderAgeUserException;
import ua.prachyk.usersAPI.validator.UserValidator;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "first_name")
    @Size(min = 2, max = 30, message = "Fist name should be 2 between 30 charters size")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    @Size(min = 2, max = 30, message = "Last name should be 2 between 30 charters size")
    private String lastName;

    @Email
    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "phone")
    private String phone;

    public void setEmail(String email) {
        boolean isEmailValid = UserValidator.isValidUserEmail(email);
        if (!isEmailValid) {
            throw new InvalidEmailException("User email is not valid!");
        } else {
            this.email = email;
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (!UserValidator.isValidUserAge(dateOfBirth)) {
            throw new UnderAgeUserException("Cannot create a user younger than " + UserValidator.MIN_AGE + " years old");
        }

        this.dateOfBirth = dateOfBirth;
    }
}
