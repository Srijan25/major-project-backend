package com.learn.portal.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int userId;

    @NotEmpty(message = "Name cannot be empty!")
    @Pattern(regexp = "^[a-zA-Z ]*", message = "Incorrect format for Name!")
    private String name;


    @Pattern(regexp = "^(9|8|7|6)[0-9]*$", message = "Incorrect Number!")
    private String mobileNumber;

    @NotEmpty(message = "Email ID cannot be empty!")
    @Email(message = "Kindly enter correct email id!")
    private String emailId;

   @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-{}|:\"<>?/.,';\\[\\]])[A-Za-z\\d!@#$%^&*()_+=\\-{}|:\"<>?/.,';\\[\\]]+$", message = "Password should contain at least one upper-case letter, lower-case letter, a digit and a special character")
    private String password;
    private String role;
    private Boolean status = false;

}
