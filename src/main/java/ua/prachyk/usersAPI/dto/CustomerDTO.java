package ua.prachyk.usersAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50, message = "Full name should be 2 between 50 charters size")
    private String fullName;

    @Email
    @NotNull
    private String email;


    @NotNull
    @Size(min = 6, max = 14, message = "Error,only use number")
    private String phone;

}
