package main;

import main.academichistory.AcademicHistory;
import main.academichistory.AcademicHistoryLoad;
import main.career.CareerLoad;
import main.correlative.CorrelativeLoad;
import main.site.SiteController;
import main.career.Career;
import main.student.StudentLoad;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanLoad;
import main.subject.Subject;
import main.student.Student;
import main.subject.SubjectLoad;

public class AcademicManager {

    private static void loadData() {
        CareerLoad.data();
        StudentLoad.data();
        StudyPlanLoad.data();
        SubjectLoad.data();
        CorrelativeLoad.data();
        AcademicHistoryLoad.data();
    }

    public static void main(String[] args) {
        // Carga inicial de datos
        AcademicManager.loadData();

        // Inicializar la interfaz gráfica de usuario (UI) utilizando SiteController
        SiteController.getInstance().principal();
    }
}
