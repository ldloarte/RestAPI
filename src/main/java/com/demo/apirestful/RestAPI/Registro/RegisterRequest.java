package com.demo.apirestful.RestAPI.Registro;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    @NotBlank(message = "Favor colocar su correo electrónico")
    @Email(message = "Por favor colocar un formato de correo que sea correcto. Ejemplo: (aaaaaaa@dominio.cl)")
    private String email;
    private String password;

}
