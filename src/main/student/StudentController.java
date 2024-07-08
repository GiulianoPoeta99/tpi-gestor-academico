package main.student;

import main.common.Controller;

/**
 * The StudentController class handles the actions related to student management.
 * It follows the Singleton pattern and provides methods for various operations
 * such as creating, updating, viewing, deleting, and searching for students, as well
 * as managing student enrollments in careers.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>instance - A single instance of StudentController.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getInstance() - Retrieves the singleton instance of the StudentController.</li>
 *   <li>index() - Renders the index view of students.</li>
 *   <li>create(boolean isRegister, boolean save, Student model) - Handles the creation of a student.</li>
 *   <li>update(boolean isRegister, boolean save, int id) - Handles the update of a student.</li>
 *   <li>view(boolean isRegister, int id) - Displays the details of a student.</li>
 *   <li>delete(boolean isRegister, boolean validation, int id) - Handles the deletion of a student.</li>
 *   <li>search(boolean isRegister) - Renders the search view for students.</li>
 *   <li>enrollCareer(int idStudent) - Manages student enrollment in a career.</li>
 *   <li>searchCareer() - Renders the view for searching careers.</li>
 *   <li>studentsForCareer(int idCareer) - Displays students enrolled in a specific career.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.05
 */
public class StudentController implements Controller {
    private static final StudentController instance = new StudentController();

    /**
     * Private constructor to prevent instantiation.
     */
    private StudentController() {
    }

    /**
     * Retrieves the singleton instance of the StudentController.
     *
     * @return The single instance of StudentController.
     */
    public static StudentController getInstance() {
        return instance;
    }

    /**
     * Renders the index view of students.
     */
    public void index() {
        render(StudentViews::index);
    }

    /**
     * Handles the creation of a student.
     *
     * @param isRegister Indicates if the operation is a registration.
     * @param save Indicates if the student should be saved.
     * @param model The student model to be created.
     */
    public void create(boolean isRegister, boolean save, Student model) {
        if (model == null) {
            model = new Student();
        }

        if (save) {
            if (model.save()) {
                view(isRegister, model.getId());
            }
        } else {
            Student finalModel = model;
            render(() -> StudentViews.create(isRegister, finalModel));
        }
    }

    /**
     * Handles the update of a student.
     *
     * @param isRegister Indicates if the operation is a registration.
     * @param save Indicates if the student should be saved.
     * @param id The ID of the student to be updated.
     */
    public void update(boolean isRegister, boolean save, int id) {
        Student model = (Student) StudentService.getById(id);

        if (save) {
            if (model.update()) {
                view(isRegister, model.getId());
            }
        } else {
            render(() -> StudentViews.update(isRegister, model));
        }
    }

    /**
     * Displays the details of a student.
     *
     * @param isRegister Indicates if the operation is a registration.
     * @param id The ID of the student to be viewed.
     */
    public void view(boolean isRegister, int id) {
        Student model = (Student) StudentService.getById(id);
        render(() -> StudentViews.view(isRegister, model));
    }

    /**
     * Handles the deletion of a student.
     *
     * @param isRegister Indicates if the operation is a registration.
     * @param validation Indicates if the deletion requires validation.
     * @param id The ID of the student to be deleted.
     */
    public void delete(boolean isRegister, boolean validation, int id) {
        if (validation) {
            Student model = (Student) StudentService.getById(id);
            model.delete();
            render(() -> StudentViews.delete(isRegister, true, id));
        } else {
            render(() -> StudentViews.delete(isRegister, false, id));
        }
    }

    /**
     * Renders the search view for students.
     *
     * @param isRegister Indicates if the operation is a registration.
     */
    public void search(boolean isRegister) {
        render(() -> StudentViews.search(isRegister));
    }

    /**
     * Manages student enrollment in a career.
     *
     * @param idStudent The ID of the student to be enrolled in a career.
     */
    public void enrollCareer(int idStudent) {
        Student student = (Student) StudentService.getById(idStudent);
        render(() -> StudentViews.enrollCareer(student));
    }

    /**
     * Renders the view for searching careers.
     */
    public void searchCareer() {
        render(StudentViews::searchCareer);
    }

    /**
     * Displays students enrolled in a specific career.
     *
     * @param idCareer The ID of the career.
     */
    public void studentsForCareer(int idCareer) {
        render(() -> StudentViews.studentsForCareer(idCareer));
    }
}
