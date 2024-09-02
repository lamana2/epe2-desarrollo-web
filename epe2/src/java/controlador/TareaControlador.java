package controlador;

import dao.TareaDAO;
import modelo.Tarea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/TareaControlador")
public class TareaControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TareaDAO tareaDAO = new TareaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "lista";
        }

        switch (action) {
            case "lista":
                listarTareas(request, response);
                break;
            case "editar":
                mostrarFormularioCrear(request, response);
                break;
            case "borrar":
                eliminarTarea(request, response);
                break;
            default:
                listarTareas(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "insertar";
        }

        switch (action) {
            case "insertar":
                insertarTarea(request, response);
                break;
            case "actualizar":
                actualizarTarea(request, response);
                break;
            default:
                listarTareas(request, response);
                break;
        }
    }

    private void listarTareas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tarea> listaTareas = tareaDAO.listar();
        request.setAttribute("listaTareas", listaTareas);
        request.getRequestDispatcher("tareas.jsp").forward(request, response);
    }

    private void mostrarFormularioCrear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTarea = request.getParameter("id");
        if (idTarea != null && !idTarea.isEmpty()) {
            try {
                Tarea tarea = tareaDAO.obtenerPorId(Integer.parseInt(idTarea));
                request.setAttribute("tarea", tarea);
            } catch (NumberFormatException e) {
                // Manejo de error en caso de formato incorrecto
                request.setAttribute("error", "ID de tarea inválido.");
            }
        }
        request.getRequestDispatcher("formularioTarea.jsp").forward(request, response);
    }

    private void actualizarTarea(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int idTarea = Integer.parseInt(request.getParameter("idTarea"));
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String estado = request.getParameter("estado");
            Date fecha = Date.valueOf(request.getParameter("fecha"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            Tarea tareaActualizada = new Tarea(idTarea, titulo, descripcion, estado, fecha, idUsuario);
            tareaDAO.actualizar(tareaActualizada);
        } catch (NumberFormatException | IllegalArgumentException e) {
            // Manejo de errores
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error en los datos proporcionados.");
            return;
        }
        response.sendRedirect("TareaControlador?action=lista");
    }

    private void insertarTarea(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String estado = request.getParameter("estado");
            String fechaString = request.getParameter("fecha");
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            Date fecha = null;
            if (fechaString != null && !fechaString.isEmpty()) {
                fecha = Date.valueOf(fechaString);
            }

            Tarea nuevaTarea = new Tarea();
            nuevaTarea.setTitulo(titulo);
            nuevaTarea.setDescripcion(descripcion);
            nuevaTarea.setEstado(estado);
            nuevaTarea.setFecha(fecha);
            nuevaTarea.setIdUsuario(idUsuario);

            tareaDAO.registrar(nuevaTarea);
        } catch (NumberFormatException | IllegalArgumentException e) {
            // Manejo de errores
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Error en los datos proporcionados.");
            return;
        }
        response.sendRedirect("TareaControlador?action=lista");
    }

    private void eliminarTarea(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            tareaDAO.eliminar(id);
        } catch (NumberFormatException e) {
            // Manejo de error en caso de formato incorrecto
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de tarea inválido.");
            return;
        }
        response.sendRedirect("TareaControlador?action=lista");
    }
}
