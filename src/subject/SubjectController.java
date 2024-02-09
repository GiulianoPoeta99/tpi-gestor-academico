package subject;

import common.Controller;
import studyplan.StudyPlan;
import studyplan.StudyPlanViews;

public class SubjectController implements Controller {
    private static final SubjectController instance = new SubjectController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private SubjectController() {
    }

    public static SubjectController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> SubjectViews.index(Subject.getAll()));
    }

    public void create() {
        // Implementation for creating a new subject.
    }

    public void update() {
        // Implementation for updating an existing subject.
    }

    public void view() {
        // Implementation for viewing subject data.
    }

    public void delete() {
        // Implementation for deleting a subject.
    }
}
