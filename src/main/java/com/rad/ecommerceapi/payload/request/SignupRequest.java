package com.rad.ecommerceapi.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String firstname;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastname;

    @NotBlank
    @Size(min = 5, max = 50)
    private String address;

    @NotBlank
    @Size(min=10, max = 10)
    private String tel;

    @NotBlank
    private String gender;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
