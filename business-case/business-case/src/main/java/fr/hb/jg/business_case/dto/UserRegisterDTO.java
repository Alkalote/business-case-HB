package fr.hb.jg.business_case.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDTO {

    @NotBlank
    private String birthedAt;

    @NotBlank
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @NotBlank
    private String password2;

    @NotBlank
    private String phone;

}