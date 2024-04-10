package main.correlative;

import main.career.Career;
import main.career.CareerSearch;
import main.common.Controller;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanSearch;
import main.subject.Subject;
import main.subject.SubjectSearch;

public class CorrelativeController implements Controller {
    private static final CorrelativeController instance = new CorrelativeController();

    private CorrelativeController() {
    }

    public static CorrelativeController getInstance() {
        return instance;
    }

    public void index() {
        render(CorrelativeViews::index);
    }

    public void create(boolean save, Correlative model, int idCareer) {
        if (model == null) {
            model = new Correlative();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Correlative finalModel = model;
            render(() -> CorrelativeViews.create(finalModel, idCareer));
        }
    }

    public void update(boolean save, int id) {
        Correlative model = (Correlative) CorrelativeSearch.getById(id);
        Subject subject = (Subject) SubjectSearch.getById(model.getIdSubject());
        StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(subject.getIdStudyPlan());
        Career career = (Career) CareerSearch.getById(studyPlan.getIdCareer());

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> CorrelativeViews.update(model, career.getId()));
        }
    }

    public void view(int id) {
        Correlative model = (Correlative) CorrelativeSearch.getById(id);
        render(() -> CorrelativeViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            Correlative model = (Correlative) CorrelativeSearch.getById(id);
            model.delete();
            render(() -> CorrelativeViews.delete(true, id));
        } else {
            render(() -> CorrelativeViews.delete(false, id));
        }
    }

    public void search() {
        render(CorrelativeViews::search);
    }

    public void searchCreate() {
        render(CorrelativeViews::searchCreate);
    }

    public void searchSubject() {
        render(CorrelativeViews::searchSubject);
    }

    public void correlativePerSubject(int idSubject) {
        render(() -> CorrelativeViews.correlativePerSubject(idSubject));
    }
}
