package com.salesianostriana.dam.rest.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    private String username;
    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String password;

}
