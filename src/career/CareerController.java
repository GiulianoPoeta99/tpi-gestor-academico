package career;

import common.Controller;
import studyplan.StudyPlan;
import studyplan.StudyPlanSearch;

import java.util.Objects;

public class CareerController implements Controller {
    private static final CareerController instance = new CareerController();

    private CareerController() {
    }

    public static CareerController getInstance() {
        return instance;
    }

    public void index() {
        render(CareerViews::index);
    }

    public void create(boolean save, Career model) {
        if (model == null) {
            model = new Career();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Career finalModel = model;
            render(() -> CareerViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        Career model = (Career) CareerSearch.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> CareerViews.update(model));
        }
    }

    public void view(int id) {
        Career model = (Career) CareerSearch.getById(id);
        render(() -> CareerViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            Career model = (Career) CareerSearch.getById(id);
            model.delete();
            render(() -> CareerViews.delete(true, id));
        } else {
            render(() -> CareerViews.delete(false, id));
        }
    }

    public void search(boolean viewSubjects) {
        render(() -> CareerViews.search(viewSubjects));
    }

    public void viewSubjects(int idCareer) {
        int idStudyPlan = ((StudyPlan) Objects.requireNonNull(StudyPlanSearch.getByIdCareer(idCareer))).getId();
        StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(idStudyPlan);
        render(() -> CareerViews.viewSubjects(studyPlan));
    }
}
