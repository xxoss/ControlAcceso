# Mecanismos de Control de Acceso

He creado un programa de mecanismos de control de acceso que permite la autenticación y gestión de usuarios con diferentes roles. Se implementa utilizando **Maven** en **IntelliJ IDEA** y se utilizan librerías externas para mejorar la seguridad y optimizar el código.

El sistema permite a los usuarios registrarse, iniciar sesión y visualizar los usuarios existentes junto con sus roles. Para garantizar la seguridad, se emplea la librería **BCrypt** para encriptar las contraseñas antes de almacenarlas. De esta manera, incluso si alguien accede al archivo donde se guardan las credenciales, no podrá ver las contraseñas en texto plano.

La información de los usuarios se almacena en un archivo de texto (`usuarios.txt`), lo que proporciona una persistencia básica de datos. Al iniciar el programa, se cargan los usuarios registrados previamente desde este archivo. Cuando se agrega un nuevo usuario, sus datos se guardan automáticamente, permitiendo que estén disponibles en futuras ejecuciones del programa.

## Estructura del Código

El código está estructurado en dos clases principales:

### **ControlAcceso:**
Maneja la autenticación de usuarios, el registro y el almacenamiento de credenciales.

### **Usuario:**
Representa a cada usuario del sistema, almacenando su nombre de usuario, contraseña encriptada y rol.

## Métodos Clave

El programa cuenta con varios métodos clave que permiten la gestión de usuarios en el sistema de control de acceso:

- **registrarUsuario:**  
  Toma un nombre de usuario, una contraseña y un rol. Antes de almacenarlo, la contraseña se encripta con **BCrypt** para garantizar su seguridad. Luego, se llama al método **guardarUsuarioEnArchivo** (explicado más adelante).

- **iniciarSesion:**  
  Verifica que su nombre de usuario exista en el sistema. Luego, compara la contraseña ingresada con la almacenada usando `BCrypt.checkpw()`. Si coinciden, devuelve `true`, permitiendo el acceso; de lo contrario, devuelve `false`.

- **mostrarUsuarios:**  
  Permite visualizar los usuarios registrados en el sistema. Muestra solo nombre de usuario y su rol para evitar riesgos de seguridad, sin revelar la contraseña.

- **cargarUsuariosDesdeArchivo:**  
  Lee el archivo línea por línea, separa los datos y reconstruye los objetos **Usuario**, almacenándolos en el mapa de usuarios registrados. Si el archivo no existe o hay un error, el sistema lo ignora y sigue funcionando sin problemas.

- **guardarUsuarioEnArchivo:**  
  Sirve para registrar un nuevo usuario. Abre el archivo en modo escritura y agrega la información en formato `username,password,rol`. Si ocurre un error al escribir, se muestra un mensaje en la consola.

## Clase Usuario

Finalmente, la clase **Usuario** proporciona métodos para obtener el nombre de usuario, la contraseña encriptada y el rol. La contraseña no puede modificarse después de ser almacenada, lo que evita posibles vulnerabilidades.

---

## Librerías Utilizadas

- **BCrypt**: Para encriptar las contraseñas de manera segura.
- **Lombok**: Para reducir código repetitivo en la creación de métodos `getters`, `setters`, `toString`, etc.

---


