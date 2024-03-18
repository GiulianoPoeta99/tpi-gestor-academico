package main.studyplan;

import main.common.Controller;

public class StudyPlanController implements Controller {
    private static final StudyPlanController instance = new StudyPlanController();

    private StudyPlanController() {
    }

    public static StudyPlanController getInstance() {
        return instance;
    }

    public void index() {
        render(StudyPlanViews::index);
    }

    public void create(boolean save, StudyPlan model) {
        if (model == null) {
            model = new StudyPlan();
        }

        if (save) {
            model.setIsActive(true);
            StudyPlan studyPlanActive = (StudyPlan) StudyPlanSearch.getByIdCareer(model.getIdCareer());
            if (studyPlanActive != null) {
                studyPlanActive.setIsActive(false);
                if (studyPlanActive.update()) {
                    if (model.save()) {
                        view(model.getId());
                    }
                }
            } else {
                if (model.save()) {
                    view(model.getId());
                }
            }
        } else {
            StudyPlan finalModel = model;
            render(() -> StudyPlanViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        StudyPlan model = (StudyPlan) StudyPlanSearch.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> StudyPlanViews.update(model));
        }
    }

    public void view(int id) {
        StudyPlan model = (StudyPlan) StudyPlanSearch.getById(id);
        render(() -> StudyPlanViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            StudyPlan model = (StudyPlan) StudyPlanSearch.getById(id);
            model.delete();
            render(() -> StudyPlanViews.delete(true, id));
        } else {
            render(() -> StudyPlanViews.delete(false, id));
        }
    }

    public void search(boolean viewSubjects) {
        render(() -> StudyPlanViews.search(viewSubjects));
    }

    public void viewSubjects(int idStudyPlan) {
        StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(idStudyPlan);
        render(() -> StudyPlanViews.viewSubjects(studyPlan));
    }
}
