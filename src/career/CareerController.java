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

    public void create(boolean save) {
        Career model = new Career();

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {

            render(CareerViews::create);
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
