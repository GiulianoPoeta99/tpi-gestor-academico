package student;

import career.CareerController;
import career.CareerViews;
import common.Controller;

/**
 * Controller class for managing student entities.
 * This class implements the common Controller interface.
 * It provides methods to handle user interactions related to students, such as creation, updating,
 * viewing, and deletion of student records.
 * 
 * @author Giuliano Ignacio Poeta
 */
public class StudentController implements Controller {
    private static final StudentController instance = new StudentController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private StudentController() {
    }

    /**
     * Método estático para obtener la instancia única del controlador.
     *
     * @return La instancia única del controlador.
     */
    public static StudentController getInstance() {
        return instance;
    }

    /**
     * Entry point for the student controller.
     * This method is typically used to initiate the student-related functionality.
     */
    public void index() {
        render(StudentViews::index);
    }
    
    /**
     * Handles the creation of a new student.
     * This method is responsible for capturing user input and creating a new student entity.
     */
    public void create() {
        // Implementation for creating a new student.
    }
    
    /**
     * Handles the update or modification of an existing student.
     * This method is responsible for capturing user input and updating an existing student entity.
     */
    public void update() {
        // Implementation for updating an existing student.
    }
    
    /**
     * Handles the retrieval and presentation of student data for user viewing.
     * This method is responsible for displaying information about students to the user.
     */
    public void view() {
        // Implementation for viewing student data.
    }
    
    /**
     * Handles the deletion or removal of a student entity.
     * This method is responsible for capturing user input and deleting an existing student entity.
     */
    public void delete() {
        // Implementation for deleting a student.
    }
}
