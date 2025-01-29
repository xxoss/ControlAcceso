package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa a un usuario en el sistema.
 * @author José Menéndez
 */
@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private String username;
    private String password; // La contraseña ya debe estar encriptada
    private String rol; // Ejemplo: "Admin", "User"
}
