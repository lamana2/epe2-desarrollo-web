package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.ConexionDB;
import modelo.Usuario;

public class UsuarioDAO {

    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("password") // Opcional: considerar hashing
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger en lugar de printStackTrace
        }
        return null;
    }

    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nombre, email, password) VALUES (?, ?, ?)";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword()); // Considera hashing
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger
            return false;
        }
    }

    public Usuario validar(String email, String password) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND password = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, email);
            ps.setString(2, password); // Considera hashing
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        null // No se devuelve la contraseña por seguridad
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger
        }
        return null;
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    null // No se incluye la contraseña en la lista
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger
        }
        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger
            return false;
        }
    }

    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre = ?, email = ?, password = ? WHERE idUsuario = ?";
        try (Connection con = ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword()); // Considera hashing
            ps.setInt(4, usuario.getIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger
            return false;
        }
    }
}
