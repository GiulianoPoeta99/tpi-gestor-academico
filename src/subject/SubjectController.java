package subject;

import common.Controller;
import common.Model;
import studyplan.StudyPlan;
import studyplan.StudyPlanViews;

public class SubjectController implements Controller {
    private static final SubjectController instance = new SubjectController();

    private SubjectController() {
    }

    public static SubjectController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> SubjectViews.index(Subject.getAll()));
    }

    public void create(boolean save, Model model) {
        // Implementation for creating a new subject.
    }

    public void update(int id) {
        // Implementation for updating an existing subject.
    }

    public void view(int id) {
        // Implementation for viewing subject data.
    }

    public void delete(int id) {
        // Implementation for deleting a subject.
    }
}
