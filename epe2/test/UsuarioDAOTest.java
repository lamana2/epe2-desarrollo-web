import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.List;

public class UsuarioDAOTest {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        try {
            // Prueba registrar
            Usuario nuevoUsuario = new Usuario(11, "Sebastian", "sebastian@mail.com", "1234");
            boolean registrado = dao.registrar(nuevoUsuario);
            System.out.println("Usuario registrado: " + registrado);

            // Verificar si el usuario se ha registrado correctamente
            if (registrado) {
                // Prueba validar
                Usuario usuario = dao.validar("sebastian@mail.com", "1234");
                if (usuario != null) {
                    System.out.println("Usuario encontrado: " + usuario.getNombre());

                    // Prueba listar
                    List<Usuario> usuarios = dao.listar();
                    System.out.println("Total de usuarios: " + usuarios.size());
                    for (Usuario u : usuarios) {
                        System.out.println(u.getIdUsuario() + " - " + u.getNombre() + " - " + u.getEmail());
                    }

                    // Prueba eliminar
                    boolean eliminado = dao.eliminar(usuario.getIdUsuario());
                    System.out.println("Usuario eliminado: " + eliminado);
                } else {
                    System.out.println("Usuario no encontrado para validación.");
                }
            } else {
                System.out.println("El usuario no se pudo registrar, por lo tanto, no se realizaron pruebas adicionales.");
            }
        } catch (Exception e) {
            System.err.println("Error durante la prueba del DAO: " + e.getMessage());
        }
    }
}
