package ua.prachyk.usersAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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
    @UniqueElements
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "year_of_birth")
    @Min(value = 1990, message = "Error, year must be higher 1990")
    private LocalDate yearOfBirth;



}
