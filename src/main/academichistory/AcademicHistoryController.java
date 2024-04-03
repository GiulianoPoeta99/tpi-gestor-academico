package main.academichistory;

import main.common.Controller;

public class AcademicHistoryController implements Controller {
    private static final AcademicHistoryController instance = new AcademicHistoryController();

    private AcademicHistoryController() {
    }

    public static AcademicHistoryController getInstance() {
        return instance;
    }

    public void index() {
        render(AcademicHistoryViews::index);
    }

    public void create(boolean save, AcademicHistory model) {
        if (model == null) {
            model = new AcademicHistory();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            AcademicHistory finalModel = model;
            render(() -> AcademicHistoryViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        AcademicHistory model = (AcademicHistory) AcademicHistorySearch.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> AcademicHistoryViews.update(model));
        }
    }

    public void view(int id) {
        AcademicHistory model = (AcademicHistory) AcademicHistorySearch.getById(id);
        render(() -> AcademicHistoryViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            AcademicHistory model = (AcademicHistory) AcademicHistorySearch.getById(id);
            model.delete();
            render(() -> AcademicHistoryViews.delete(true, id));
        } else {
            render(() -> AcademicHistoryViews.delete(false, id));
        }
    }

    public void search() {
        render(AcademicHistoryViews::search);
    }
}
