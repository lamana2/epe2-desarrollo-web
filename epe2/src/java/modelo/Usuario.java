package modelo;

/**
 * Representa un Usuario en el sistema.
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String email;
    private String password;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param idUsuario Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     */
    public Usuario(int idUsuario, String nombre, String email, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    /**
     * Obtiene el identificador del usuario.
     * 
     * @return El identificador del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param idUsuario El identificador del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param password La contraseña del usuario.
     */
    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
    }
}
