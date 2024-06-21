package main.academichistory;

/**
 * The AcademicHistoryLoad class is responsible for loading predefined academic history data
 * for multiple students. This class provides methods to initialize the data for each student
 * and populate the academic history records.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>data() - Loads the academic history data for all students.</li>
 *   <li>dataStudent1() - Loads the academic history data for student 1.</li>
 *   <li>dataStudent2() - Loads the academic history data for student 2.</li>
 *   <li>dataStudent3() - Loads the academic history data for student 3.</li>
 *   <li>dataStudent4() - Loads the academic history data for student 4.</li>
 *   <li>dataStudent5() - Loads the academic history data for student 5.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2024.04.05
 * @author Giuliano Ignacio Poeta
 */
public class
AcademicHistoryLoad extends AcademicHistory {
    /**
     * Loads the academic history data for all students.
     */
    public static void data() {
        dataStudent1();
        dataStudent2();
        dataStudent3();
        dataStudent4();
        dataStudent5();
    }

    /**
     * Loads the academic history data for student 1.
     */
    private static void dataStudent1() {
        new AcademicHistory(1, 1, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(1, 2, "Aprobado", 6, 5, false, 9, 9);
        new AcademicHistory(1, 3, "Desaprobado", 6, 5, false, 3, 2);
        new AcademicHistory(1, 3, "Desaprobado", 4, 7, false, 3, 3);
        new AcademicHistory(1, 3, "Aprobado", 6, 4, false, 10, 10);
        new AcademicHistory(1, 4, "Aprobado", 4, 7, false, 7, 7);
        new AcademicHistory(1, 5, "Aprobado", 4, 4, false, 5, 5);
        new AcademicHistory(1, 6, "Promocionado", 8, 8, true, 0, 8);
        new AcademicHistory(1, 7, "Promocionado", 10, 9, true, 0, 9);
        new AcademicHistory(1, 8, "Promocionado", 7, 9, true, 0, 8);
        new AcademicHistory(1, 9, "Aprobado", 4, 9, false, 5, 5);
        new AcademicHistory(1, 10, "Aprobado", 8, 6, false, 10, 10);
        new AcademicHistory(1, 11, "Aprobado", 6, 5, false, 4, 4);
        new AcademicHistory(1, 12, "Aprobado", 6, 9, false, 6, 6);
        new AcademicHistory(1, 13, "Promocionado", 7, 9, true, 0, 8);
        new AcademicHistory(1, 14, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(1, 15, "Aprobado", 6, 9, false, 8, 8);
        new AcademicHistory(1, 16, "Promocionado", 7, 7, true, 0, 7);
        new AcademicHistory(1, 17, "Aprobado", 6, 9, false, 10, 10);
    }

    /**
     * Loads the academic history data for student 2.
     */
    private static void dataStudent2() {
        new AcademicHistory(2, 51, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 52, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 53, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 54, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 55, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 56, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 57, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 58, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 59, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 60, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 61, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 62, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 63, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 64, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 65, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 66, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(2, 67, "Aprobado", 6, 9, false, 7, 7);
    }

    /**
     * Loads the academic history data for student 3.
     */
    private static void dataStudent3() {
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
        new AcademicHistory(3, 104, "Aprobado", 6, 9, false, 7, 7);
    }

    /**
     * Loads the academic history data for student 4.
     */
    private static void dataStudent4() {
        new AcademicHistory(4, 165, "Promocionado", 7, 7, true, 0, 7);
        new AcademicHistory(4, 166, "Aprobado", 6, 7, false, 6, 6);
        new AcademicHistory(4, 167, "Promocionado", 10, 10, true, 0, 10);
        new AcademicHistory(4, 168, "Promocionado", 7, 7, true, 0, 7);
        new AcademicHistory(4, 169, "Aprobado", 4, 4, false, 4, 4);
        new AcademicHistory(4, 170, "Promocionado", 10, 10, true, 0, 10);
        new AcademicHistory(4, 171, "Promocionado", 7, 10, true, 0, 8);
        new AcademicHistory(4, 172, "Aprobado", 5, 6, false, 8, 8);
        new AcademicHistory(4, 173, "Aprobado", 5, 4, false, 0, 7);
        new AcademicHistory(4, 174, "Promocionado", 7, 7, true, 0, 7);
        new AcademicHistory(4, 175, "Promocionado", 10, 10, true, 0, 10);
        new AcademicHistory(4, 176, "Promocionado", 7, 10, true, 0, 8);
        new AcademicHistory(4, 180, "Cursando", 0, 0, false, 0, 0);
        new AcademicHistory(4, 181, "Cursando", 0, 0, false, 0, 0);
        new AcademicHistory(4, 182, "Cursando", 0, 0, false, 0, 0);
        new AcademicHistory(4, 183, "Cursando", 0, 0, false, 0, 0);
    }

    /**
     * Loads the academic history data for student 5.
     */
    private static void dataStudent5() {
        new AcademicHistory(5, 199, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 200, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 201, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 202, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 203, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 204, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 205, "Aprobado", 6, 7, false, 7, 7);
        new AcademicHistory(5, 206, "Aprobado", 6, 7, false, 7, 7);
    }
}
