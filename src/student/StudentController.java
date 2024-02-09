package student;

import career.Career;
import career.CareerController;
import career.CareerViews;
import common.Controller;
import common.Model;

import java.util.Map;

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
        render(() -> StudentViews.index(Student.getAll()));
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
