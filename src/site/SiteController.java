package site;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

import career.CareerController;
import common.Controller;
import student.StudentController;
import studyplan.StudyPlanController;
import subject.SubjectController;

public class SiteController implements Controller {

    private static final SiteController instance = new SiteController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private SiteController() {
    }

    public static SiteController getInstance() {
        return instance;
    }

    public void principal() {
        // Crear un array list de redirecciones
        Map<String, Runnable> redirections = new LinkedHashMap<>();
        redirections.put("Inicio",SiteController.getInstance()::index);
        redirections.put("Carreras", CareerController.getInstance()::index);
        redirections.put("Planes de Estudio", StudyPlanController.getInstance()::index);
        redirections.put("Materias", SubjectController.getInstance()::index);
        redirections.put("Alumnos", StudentController.getInstance()::index);

        // Inicializar la GUI utilizando SwingUtilities.invokeLater()
        SwingUtilities.invokeLater(() -> {
            // Invocar el método layout de SiteViews para configurar la interfaz gráfica
            SiteViews.layout(redirections);

            // Mostrar la vista de inicio (index)
            index();
        });
    }

    public void index() {
        render(SiteViews::index);
    }

    public void create() {
        index();
    }

    public void update() {
        index();
    }

    public void view() {
        index();
    }

    public void delete() {
        index();
    }
}
