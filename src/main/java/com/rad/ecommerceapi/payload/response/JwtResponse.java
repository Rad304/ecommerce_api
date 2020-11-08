package com.rad.ecommerceapi.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class JwtResponse {
    private String token;
	private final String type = "Bearer";
	private Long id;
	private String firstname;
    private String lastname;
    private String address;
    private String tel;
    private String gender;
	private String username;
	private String email;
	private List<String> roles;
}
