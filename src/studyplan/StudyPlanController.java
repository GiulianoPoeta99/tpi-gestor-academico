package studyplan;

import common.Controller;
import common.Model;

import java.util.Map;

public class StudyPlanController implements Controller {
    private static final StudyPlanController instance = new StudyPlanController();

    private StudyPlanController() {
    }

    public static StudyPlanController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> StudyPlanViews.index(StudyPlan.getAll()));
    }

    public void create() {
        // Implementation for creating a new study plan.
    }

    public void update(int id) {
        // Implementation for updating an existing study plan.
    }

    public void view() {
        // Implementation for viewing study plan data.
    }

    public void delete() {
        // Implementation for deleting a study plan.
    }
}
