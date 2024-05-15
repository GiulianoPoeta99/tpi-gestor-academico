package main;

import main.academichistory.AcademicHistoryLoad;
import main.career.CareerLoad;
import main.correlative.CorrelativeLoad;
import main.site.SiteController;
import main.student.StudentLoad;
import main.studyplan.StudyPlanLoad;
import main.subject.SubjectLoad;

/**
 * The AcademicManager class serves as the entry point for the academic management system.
 * It coordinates the loading of various data components and initializes the user interface.
 *
 * @author Giuliano Ignacio Poeta
 * @version 1.0.0
 * @since 2023.12.05
 */
public class AcademicManager {

    /**
     * Loads initial data required for the system to function properly.
     * This includes career data, student data, study plan data, subject data,
     * correlative data, and academic history data.
     */
    private static void loadData() {
        CareerLoad.data();
        StudentLoad.data();
        StudyPlanLoad.data();
        SubjectLoad.data();
        CorrelativeLoad.data();
        AcademicHistoryLoad.data();
    }

    /**
     * Main method to start the academic management system.
     * It loads initial data and initializes the user interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Load initial data
        AcademicManager.loadData();

        // Initialize the user interface (UI) using SiteController
        SiteController.getInstance().principal();
    }
}
