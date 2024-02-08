import site.SiteController;
import career.Career;
import studyplan.StudyPlan;
import subject.Subject;
import student.Student;

public class AcademicManager {

    protected void loadData() {
        Career.loadData();
        StudyPlan.loadData();
        Subject.loadData();
        Student.loadData();
    }

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
