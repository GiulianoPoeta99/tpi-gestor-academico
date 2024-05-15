package main.site;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

import main.academichistory.AcademicHistoryController;
import main.career.CareerController;
import main.common.Controller;
import main.correlative.CorrelativeController;
import main.student.StudentController;
import main.studyplan.StudyPlanController;
import main.subject.SubjectController;

/**
 * The SiteController class manages the main site functionality, including navigation and UI initialization.
 * It follows the singleton pattern to ensure only one instance exists throughout the application.
 *
 * @author Giuliano Ignacio Poeta
 * @version 1.0.0
 * @since 2024.02.07
 */
public class SiteController implements Controller {

    private static final SiteController instance = new SiteController();

    private SiteController() {
    }

    /**
     * Retrieves the singleton instance of SiteController.
     *
     * @return The singleton instance of SiteController.
     */
    public static SiteController getInstance() {
        return instance;
    }

    /**
     * Initializes the main user interface (UI) layout and navigation.
     * Redirects to the index page.
     */
    public void principal() {
        Map<String, Runnable> redirections = new LinkedHashMap<>();
        redirections.put("Inicio", SiteController.getInstance()::index);
        redirections.put("Carreras", CareerController.getInstance()::index);
        redirections.put("Planes de estudio", StudyPlanController.getInstance()::index);
        redirections.put("Alumnos", StudentController.getInstance()::index);
        redirections.put("Materias", SubjectController.getInstance()::index);
        redirections.put("Correlativas", CorrelativeController.getInstance()::index);
        redirections.put("Historia academica", AcademicHistoryController.getInstance()::index);
        redirections.put("Registrar alumno", () -> StudentController.getInstance().create(true, false, null));
        redirections.put("Inscribir a carrera", () -> StudentController.getInstance().search(true));
        redirections.put("Inscribir a materia", () -> AcademicHistoryController.getInstance().searchStudent(false, false));
        redirections.put("Verificar graduado", () -> AcademicHistoryController.getInstance().searchStudent(true, false));

        SwingUtilities.invokeLater(() -> {
            SiteViews.layout(redirections);
            index();
        });
    }

    /**
     * Renders the index page of the site.
     */
    public void index() {
        render(SiteViews::index);
    }
}
