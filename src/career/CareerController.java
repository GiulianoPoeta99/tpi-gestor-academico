package career;

import common.Controller;
import common.Model;

import java.util.Map;

public class CareerController implements Controller {
    private static final CareerController instance = new CareerController();

    private CareerController() {
    }

    public static CareerController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> CareerViews.index(Career.getAll()));
    }

    public void create(boolean save, Model model) {
        if (model == null) {
            model = new Career();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Model finalModel = model;
            render(() -> CareerViews.create(finalModel));
        }
    }

    public void update(int id) {
        // Implementation for updating an existing career.
    }

    public void view(int id) {
        // Implementation for viewing career data.
    }

    public void delete(int id) {
        // Implementation for deleting a career.
    }
}
