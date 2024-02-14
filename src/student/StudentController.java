package student;

import career.Career;
import career.CareerController;
import career.CareerViews;
import common.Controller;
import common.Model;

import java.util.Map;

public class StudentController implements Controller {
    private static final StudentController instance = new StudentController();

    private StudentController() {
    }

    public static StudentController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> StudentViews.index(Student.getAll()));
    }

    public void create(boolean save) {
        // Implementation for creating a new student.
    }

    public void update(int id) {
        // Implementation for updating an existing student.
    }

    public void view(int id) {
        // Implementation for viewing student data.
    }

    public void delete(int id) {
        // Implementation for deleting a student.
    }
}
