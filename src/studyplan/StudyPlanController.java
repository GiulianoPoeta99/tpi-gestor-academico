package studyplan;

import common.Controller;

public class StudyPlanController implements Controller {
    private static final StudyPlanController instance = new StudyPlanController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private StudyPlanController() {
    }

    public static StudyPlanController getInstance() {
        return instance;
    }

    public void index() {
        render(StudyPlanViews::index);
    }

    public void create() {
        // Implementation for creating a new study plan.
    }

    public void update() {
        // Implementation for updating an existing study plan.
    }

    public void view() {
        // Implementation for viewing study plan data.
    }

    public void delete() {
        // Implementation for deleting a study plan.
    }
}
