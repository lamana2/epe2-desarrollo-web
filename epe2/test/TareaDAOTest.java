import dao.TareaDAO;
import modelo.Tarea;
import java.util.List;

public class TareaDAOTest {
    public static void main(String[] args) {
        TareaDAO dao = new TareaDAO();

        try {
            // Prueba registrar
            Tarea nuevaTarea = new Tarea(0, "Desarrollo de Login", "Implementar funcionalidad de inicio de sesión", "En Progreso", new java.sql.Date(System.currentTimeMillis()), 1);
            boolean registrada = dao.registrar(nuevaTarea);
            System.out.println("Tarea registrada: " + registrada);

            // Verificar si la tarea se ha registrado correctamente
            if (registrada) {
                // Prueba listar
                List<Tarea> tareas = dao.listar();
                System.out.println("Total de tareas: " + tareas.size());
                for (Tarea tarea : tareas) {
                    System.out.println(tarea.getIdTarea() + " - " + tarea.getTitulo() + " - " + tarea.getDescripcion() + " - " + tarea.getEstado() + " - " + tarea.getFecha() + " - " + tarea.getIdUsuario());
                }

                // Prueba eliminar
                boolean eliminada = dao.eliminar(nuevaTarea.getIdTarea());
                System.out.println("Tarea eliminada: " + eliminada);
            } else {
                System.out.println("La tarea no se pudo registrar, por lo tanto, no se realizaron pruebas adicionales.");
            }
        } catch (Exception e) {
            System.err.println("Error durante la prueba del DAO: " + e.getMessage());
        }
    }
}
