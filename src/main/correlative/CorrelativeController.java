package main.correlative;

import main.career.Career;
import main.career.CareerService;
import main.common.Controller;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanService;
import main.subject.Subject;
import main.subject.SubjectService;

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
        Correlative model = (Correlative) CorrelativeService.getById(id);
        Subject subject = (Subject) SubjectService.getById(model.getIdSubject());
        StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(subject.getIdStudyPlan());
        Career career = (Career) CareerService.getById(studyPlan.getIdCareer());

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> CorrelativeViews.update(model, career.getId()));
        }
    }

    public void view(int id) {
        Correlative model = (Correlative) CorrelativeService.getById(id);
        render(() -> CorrelativeViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            Correlative model = (Correlative) CorrelativeService.getById(id);
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
