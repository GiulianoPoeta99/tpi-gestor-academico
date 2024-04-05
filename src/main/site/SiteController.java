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

public class SiteController implements Controller {

    private static final SiteController instance = new SiteController();

    private SiteController() {
    }

    public static SiteController getInstance() {
        return instance;
    }

    public void principal() {
        Map<String, Runnable> redirections = new LinkedHashMap<>();
        redirections.put("Inicio",SiteController.getInstance()::index);
        redirections.put("Carreras", CareerController.getInstance()::index);
        redirections.put("Planes de estudio", StudyPlanController.getInstance()::index);
        redirections.put("Alumnos", StudentController.getInstance()::index);
        redirections.put("Materias", SubjectController.getInstance()::index);
        redirections.put("Correlativas", CorrelativeController.getInstance()::index);
        redirections.put("Historia academica", AcademicHistoryController.getInstance()::index);
        redirections.put("Registrar alumno", () -> StudentController.getInstance().create(true, false, null));
        redirections.put("Inscribir a carrera", () -> StudentController.getInstance().search(true));
        redirections.put("Inscribir a materia", () -> AcademicHistoryController.getInstance().searchStudent(false));

        SwingUtilities.invokeLater(() -> {
            SiteViews.layout(redirections);
            index();
        });
    }

    public void index() {
        render(SiteViews::index);
    }
}
