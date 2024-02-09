package career;

import common.Controller;
import common.Model;

import java.util.Map;

public class CareerController implements Controller {
    private static final CareerController instance = new CareerController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private CareerController() {
    }

    public static CareerController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> CareerViews.index(Career.getAll()));
    }

    public void create() {
        // Implementation for creating a new career.
    }

    public void update() {
        // Implementation for updating an existing career.
    }

    public void view() {
        // Implementation for viewing career data.
    }

    public void delete() {
        // Implementation for deleting a career.
    }
}
