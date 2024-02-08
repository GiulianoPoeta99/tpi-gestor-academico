package career;

import common.Controller;
import site.SiteViews;

/**
 * Controller class for managing career entities.
 * This class implements the common Controller interface.
 * It provides methods to handle user interactions related to careers, such as creation, updating,
 * viewing, and deletion of career records.
 * 
 * @author Giuliano Ignacio Poeta
 */
public class CareerController implements Controller {
    private static final CareerController instance = new CareerController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private CareerController() {
    }

    /**
     * Método estático para obtener la instancia única del controlador.
     *
     * @return La instancia única del controlador.
     */
    public static CareerController getInstance() {
        return instance;
    }

    /**
     * Entry point for the career controller.
     * This method is typically used to initiate the career-related functionality.
     */
    public void index() {
        render(CareerViews::index);
    }
    
    /**
     * Handles the creation of a new career.
     * This method is responsible for capturing user input and creating a new career entity.
     */
    public void create() {
        // Implementation for creating a new career.
    }
    
    /**
     * Handles the update or modification of an existing career.
     * This method is responsible for capturing user input and updating an existing career entity.
     */
    public void update() {
        // Implementation for updating an existing career.
    }
    
    /**
     * Handles the retrieval and presentation of career data for user viewing.
     * This method is responsible for displaying information about careers to the user.
     */
    public void view() {
        // Implementation for viewing career data.
    }
    
    /**
     * Handles the deletion or removal of a career entity.
     * This method is responsible for capturing user input and deleting an existing career entity.
     */
    public void delete() {
        // Implementation for deleting a career.
    }
}
