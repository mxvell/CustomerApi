package ua.prachyk.usersAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import ua.prachyk.usersAPI.exception.InvalidEmailException;
import ua.prachyk.usersAPI.validator.CustomerValidator;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "customer", schema = "public")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created")
    private BigInteger created;

    @Column(name = "updated")
    private BigInteger updated;

    @NotEmpty
    @Column(name = "full_name")
    @Size(min = 2, max = 50, message = "Full name should be 2 between 50 charters size")
    private String fullName;

    @Email
    @NotNull
    @Column(name = "email")
    private String email;


    @NotNull
    @Column(name = "phone")
    @Size(min = 6, max = 14, message = "Error,only use number")
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

    public void setEmail(String email) {
        boolean isEmailValid = CustomerValidator.isValidUserEmail(email);
        if (!isEmailValid) {
            throw new InvalidEmailException("User email is not valid!");
        } else {
            this.email = email;
        }
    }

    public BigInteger getCreated() {
        return this.created = BigInteger.valueOf(System.currentTimeMillis());
    }

    public BigInteger getUpdated() {
        return this.updated = BigInteger.valueOf(System.currentTimeMillis());
    }

    public boolean isActive() {
        return this.isActive = true;
    }
}
