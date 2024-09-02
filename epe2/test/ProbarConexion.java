import config.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;

public class ProbarConexion {
    public static void main(String[] args) {
        ConexionDB conexion = new ConexionDB();
        Connection conn = null;

        try {
            conn = conexion.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexión a la base de datos establecida con éxito.");
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar conectar con la base de datos: " + e.getMessage());
        } finally {
            // Aquí podrías cerrar la conexión si fuera necesario
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
