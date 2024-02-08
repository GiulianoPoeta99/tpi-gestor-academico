package student;

import career.CareerController;
import career.CareerViews;
import common.Controller;

public class StudentController implements Controller {
    private static final StudentController instance = new StudentController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private StudentController() {
    }

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

    public void create() {
        // Implementation for creating a new student.
    }

    public void update() {
        // Implementation for updating an existing student.
    }

    public void view() {
        // Implementation for viewing student data.
    }

    public void delete() {
        // Implementation for deleting a student.
    }
}
