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

    public void create(boolean save, StudyPlan model) {
        if (model == null) {
            model = new StudyPlan();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            StudyPlan finalModel = model;
            render(() -> StudyPlanViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        StudyPlan model = (StudyPlan) StudyPlan.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> StudyPlanViews.update(model));
        }
    }

    public void view(int id) {
        StudyPlan model = (StudyPlan) StudyPlan.getById(id);
        render(() -> StudyPlanViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            StudyPlan model = (StudyPlan) StudyPlan.getById(id);
            model.delete();
            render(() -> StudyPlanViews.delete(true, id));
        } else {
            render(() -> StudyPlanViews.delete(false, id));
        }
    }
}
