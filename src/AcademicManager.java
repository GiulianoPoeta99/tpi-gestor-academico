import site.SiteController;
import career.Career;
import studyplan.StudyPlan;
import subject.Subject;
import student.Student;

/**
 * Manages academic-related operations such as student enrollment, career registration,
 * and course enrollment.
 * 
 * This class serves as the entry point for the academic management system.
 * It includes a method for loading initial data and a main method to perform various academic tasks.
 * 
 * @author Giuliano Ignacio Poeta
 */
public class AcademicManager {

    /**
     * Loads initial data for testing purposes.
     * This method initializes students with sample data.
     */
    protected void loadData() {
        Career.loadData();
        StudyPlan.loadData();
        Subject.loadData();
        Student.loadData();
    }

    /**
     * Entry point for the academic management system.
     * This method contains tasks related to student enrollment, career registration,
     * course enrollment, and checking if a student has completed a career.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        /*
        TODO: Student enrollment
        TODO: Career and study plan registration
        TODO: Enrollment of a student in a career
        TODO: Enrollment of a student in a course
        TODO: Verify if a student has completed a career
        */

        // Carga inicial de datos
        new AcademicManager().loadData();

        // Inicializar la interfaz gráfica de usuario (UI) utilizando SiteController
        SiteController.getInstance().principal();
    }
}
