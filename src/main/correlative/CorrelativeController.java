package main.correlative;

import main.common.Controller;

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

    public void create(boolean save, Correlative model) {
        if (model == null) {
            model = new Correlative();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Correlative finalModel = model;
            render(() -> CorrelativeViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        Correlative model = (Correlative) CorrelativeSearch.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> CorrelativeViews.update(model));
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
}
