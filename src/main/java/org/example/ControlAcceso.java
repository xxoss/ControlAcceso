package org.example;

import org.example.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  @author José Menéndez
 */

public class ControlAcceso {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    // Constructor: carga los usuarios desde el archivo
    public ControlAcceso() {
        cargarUsuariosDesdeArchivo();
    }

    /**
     * Registra un nuevo usuario en el sistema y lo guarda en un archivo.
     * @param username El nombre de usuario.
     * @param password La contraseña que se encriptará.
     * @param rol El rol del usuario.
     */
    public void registrarUsuario(String username, String password, String rol) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Usuario usuario = new Usuario(username, hashedPassword, rol);
        usuariosRegistrados.put(username, usuario);
        guardarUsuarioEnArchivo(usuario);
    }

    /**
     * Verifica si un usuario puede iniciar sesión comparando la contraseña ingresada con la almacenada.
     * @param username El nombre de usuario.
     * @param password La contraseña ingresada.
     * @return True si la contraseña es válida, false si no.
     */
    public boolean iniciarSesion(String username, String password) {
        Usuario usuario = usuariosRegistrados.get(username);
        if (usuario != null) {
            return BCrypt.checkpw(password, usuario.getPassword());
        }
        return false;
    }

    /**
     * Muestra la información de todos los usuarios registrados.
     */
    public void mostrarUsuarios() {
        for (Usuario usuario : usuariosRegistrados.values()) {
            System.out.println("Username: " + usuario.getUsername() + ", Rol: " + usuario.getRol());
        }
    }

    /**
     * Carga los usuarios desde el archivo de texto.
     */
    private void cargarUsuariosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String username = datos[0];
                    String password = datos[1];
                    String rol = datos[2];
                    usuariosRegistrados.put(username, new Usuario(username, password, rol));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios desde el archivo.");
        }
    }

    /**
     * Guarda un usuario en el archivo.
     */
    private void guardarUsuarioEnArchivo(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true))) {
            writer.write(usuario.getUsername() + "," + usuario.getPassword() + "," + usuario.getRol());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario en el archivo.");
        }
    }
}

