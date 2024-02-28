package subject;

import common.Controller;
import studyplan.StudyPlan;


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

    public void create(boolean save, Subject model, int idCareer) {
        if (model == null) {
            model = new Subject();
        }

        if (save) {
            if (idCareer != 0) {
                StudyPlan studyPlan = (StudyPlan) StudyPlan.getByIdCareer(idCareer);

                if ((studyPlan != null) && (studyPlan.getId() != model.getIdStudyPlan())) {
                    model.setIdStudyPlan(studyPlan.getId());
                }

                if (model.save()) {
                    view(model.getId());
                }
            }

        } else {
            Subject finalModel = model;
            render(() -> SubjectViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        Subject model = (Subject) Subject.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> SubjectViews.update(model));
        }
    }

    public void view(int id) {
        Subject model = (Subject) Subject.getById(id);
        render(() -> SubjectViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            Subject model = (Subject) Subject.getById(id);
            model.delete();
            render(() -> SubjectViews.delete(true, id));
        } else {
            render(() -> SubjectViews.delete(false, id));
        }
    }
}
