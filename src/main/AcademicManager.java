package main;

import main.academichistory.AcademicHistory;
import main.site.SiteController;
import main.career.Career;
import main.studyplan.StudyPlan;
import main.subject.Subject;
import main.student.Student;

public class AcademicManager {

    private static void loadData() {
        Career.loadData();
        StudyPlan.loadData();
        Subject.loadData();
        Student.loadData();
        AcademicHistory.loadData();
    }

    public static void main(String[] args) {
        // Carga inicial de datos
        AcademicManager.loadData();

        // Inicializar la interfaz gráfica de usuario (UI) utilizando SiteController
        SiteController.getInstance().principal();
    }
}
