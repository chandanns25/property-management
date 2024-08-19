package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull (message = "email cannot be null")
    @Size(min = 1,max = 50,message = "email should be between 1 to 50 characters in length")
    @NotEmpty(message = "email cannot be blank")
    private String ownerEmail;
    private String phone;
    @NotNull (message = "password cannot be null")
    @NotEmpty(message = "password cannot be blank")
    private String password;
}
