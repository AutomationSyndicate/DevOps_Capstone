package com.autosyn.user_service.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {
    private Long id;
    private String firstname;
    private String lastname;


}
