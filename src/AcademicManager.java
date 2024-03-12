import site.SiteController;
import career.Career;
import studyplan.StudyPlan;
import subject.Subject;
import student.Student;

public class AcademicManager {

    private static void loadData() {
        Career.loadData();
        StudyPlan.loadData();
        Subject.loadData();
        Student.loadData();
    }

    public static void main(String[] args) {
        // Carga inicial de datos
        AcademicManager.loadData();

        // Inicializar la interfaz gráfica de usuario (UI) utilizando SiteController
        SiteController.getInstance().principal();
    }
}
