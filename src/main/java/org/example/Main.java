package org.example;

import org.example.ControlAcceso;

import java.util.Scanner;

/**
 * Clase principal que contiene el menú y la interacción con el usuario.
 *  @author José Menéndez
 */
public class Main {
    public static void main(String[] args) {
        ControlAcceso controlAcceso = new ControlAcceso();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Información de usuarios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    if (controlAcceso.iniciarSesion(username, password)) {
                        System.out.println("Inicio de sesión exitoso");
                    } else {
                        System.out.println("Credenciales incorrectas");
                    }
                    break;

                case 2:
                    System.out.print("Nuevo username: ");
                    String nuevoUsername = scanner.nextLine();
                    System.out.print("Nueva contraseña: ");
                    String nuevaPassword = scanner.nextLine();
                    System.out.print("Rol (Admin/User): ");
                    String rol = scanner.nextLine();
                    controlAcceso.registrarUsuario(nuevoUsername, nuevaPassword, rol);
                    System.out.println("Usuario registrado exitosamente");
                    break;

                case 3:
                    controlAcceso.mostrarUsuarios();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
