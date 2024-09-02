package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "validar";
        }

        switch (action) {
            case "insertar":
                insertarUsuario(request, response);
                break;
            case "actualizar":
                actualizarUsuario(request, response);
                break;
            default:
                validarUsuario(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listarUsuarios(request, response);
                break;
            case "nuevo":
                mostrarFormularioCrear(request, response);
                break;
            case "editar":
                mostrarFormularioEditar(request, response);
                break;
            case "borrar":
                eliminarUsuario(request, response);
                break;
            case "salir":
                request.getSession().invalidate();
                response.sendRedirect("login.jsp");
                break;
            default:
                listarUsuarios(request, response);
                break;
        }
    }

    private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null) {
            request.setAttribute("mensajeError", "Email o contraseña no pueden estar vacíos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Usuario usuario = usuarioDAO.validar(email, password);
        if (usuario != null) {
            request.getSession().setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("mensajeError", "Correo o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> listaUsuarios = usuarioDAO.listar();
        request.setAttribute("listaUsuarios", listaUsuarios);
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }

    private void mostrarFormularioCrear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("formularioUsuario.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuario = request.getParameter("id");
        if (idUsuario != null) {
            try {
                Usuario usuario = usuarioDAO.obtenerPorId(Integer.parseInt(idUsuario));
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("formularioUsuario.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                request.setAttribute("mensajeError", "ID de usuario inválido.");
                response.sendRedirect("UsuarioControlador?action=listar");
            }
        } else {
            request.setAttribute("mensajeError", "ID de usuario no proporcionado.");
            response.sendRedirect("UsuarioControlador?action=listar");
        }
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (nombre == null || email == null || password == null || nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("mensajeError", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("formularioUsuario.jsp").forward(request, response);
