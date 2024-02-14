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
        redirections.put("Planes de Estudio", StudyPlanController.getInstance()::index);
        redirections.put("Materias", SubjectController.getInstance()::index);
        redirections.put("Alumnos", StudentController.getInstance()::index);

        SwingUtilities.invokeLater(() -> {
            SiteViews.layout(redirections);
            index();
        });
    }

    public void index() {
        render(SiteViews::index);
    }

    public void create() {
        index();
    }

    public void update(int id) {
        index();
    }

    public void view() {
        index();
    }

    public void delete() {
        index();
    }
}
