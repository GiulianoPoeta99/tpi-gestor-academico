package subject;

import career.CareerViews;
import common.Controller;
import studyplan.StudyPlanController;

/**
 * Represents a controller for managing subjects.
 * This class implements the Controller interface.
 * It provides methods for handling main functionalities related to subjects.
 * 
 * The main functionalities include creating, updating, viewing, and deleting subjects.
 * 
 * @author Giuliano Ignacio Poeta
 */
public class SubjectController implements Controller {
    private static final SubjectController instance = new SubjectController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private SubjectController() {
    }

    /**
     * Método estático para obtener la instancia única del controlador.
     *
     * @return La instancia única del controlador.
     */
    public static SubjectController getInstance() {
        return instance;
    }

    /**
     * Main method for the subject controller.
     * Implementations for the main functionality of the subject controller should be provided here.
     */
    public void index() {
        render(SubjectViews::index);
    }

    /**
     * Method for creating a new subject.
     * Implementations for creating a new subject should be provided here.
     */
    public void create() {
        // Implementation for creating a new subject.
    }

    /**
     * Method for updating an existing subject.
     * Implementations for updating an existing subject should be provided here.
     */
    public void update() {
        // Implementation for updating an existing subject.
    }

    /**
     * Method for viewing subject data.
     * Implementations for viewing subject data should be provided here.
     */
    public void view() {
        // Implementation for viewing subject data.
    }

    /**
     * Method for deleting a subject.
     * Implementations for deleting a subject should be provided here.
     */
    public void delete() {
        // Implementation for deleting a subject.
    }
}
