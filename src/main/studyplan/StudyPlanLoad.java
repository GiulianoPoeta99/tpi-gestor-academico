package main.studyplan;

/**
 * The StudyPlanLoad class is responsible for loading predefined study plans.
 * It extends the StudyPlan class and provides a method to initialize study plans with sample data.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>data() - Loads predefined study plans.</li>
 * </ul>
 *
 * @see StudyPlan
 *
 * @version 1.0.0
 * @since yyyy.mm.dd

 * @author Giuliano Ignacio Poeta
 */
public class StudyPlanLoad extends StudyPlan {

    /**
     * Loads predefined study plans.
     * Initializes study plans with sample data including name, ID, and a boolean status.
     */
    public static void data() {
        new StudyPlan("A", 1, true);
        new StudyPlan("B", 2, true);
        new StudyPlan("C", 3, true);
        new StudyPlan("D", 4, true);
        new StudyPlan("E", 5, true);
    }
}
