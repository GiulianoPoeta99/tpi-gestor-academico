package main.studyplan;

import main.career.Career;
import main.career.CareerService;
import main.common.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The StudyPlanService class provides various services for managing study plans.
 * It extends the StudyPlan class and includes methods for retrieving custom columns,
 * custom data, and study plans by different criteria.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getCustomColumns() - Retrieves the custom columns for display.</li>
 *   <li>getCustomData() - Retrieves custom data for display.</li>
 *   <li>getById(int id) - Retrieves a study plan by its ID.</li>
 *   <li>getByIdCareer(int idCareer) - Retrieves an active study plan by career ID.</li>
 *   <li>getTypeForSelect2() - Retrieves study plan types for selection.</li>
 *   <li>getIDNameForSelect2() - Retrieves study plan IDs and names for selection.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.27
 */
public class StudyPlanService extends StudyPlan {
    /**
     * Retrieves the custom columns for display.
     *
     * @return An array of custom column names.
     */
    public static String[] getCustomColumns() {
        return new String[] { "Identificador", "Tipo", "Carrera", "Vigente" };
    }

    /**
     * Retrieves custom data for display.
     *
     * @return A list of custom data arrays.
     */
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : StudyPlan.getAll().values()) {
            if (model instanceof StudyPlan studyPlan) {
                Model career = CareerService.getById(studyPlan.getIdCareer());
                if (career instanceof Career) {
                    Object[] rowData = new Object[] {
                            studyPlan.getId(),
                            studyPlan.getType(),
                            ((Career) career).getName(),
                            studyPlan.getIsActive() ? "Si" : "No"
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    /**
     * Retrieves a study plan by its ID.
     *
     * @param id The ID of the study plan to retrieve.
     * @return The study plan with the specified ID.
     */
    public static Model getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves an active study plan by career ID.
     *
     * @param idCareer The career ID to search by.
     * @return The active study plan for the specified career ID.
     */
    public static Model getByIdCareer(int idCareer) {
        for (Model model : all.values()) {
            if (model instanceof StudyPlan studyPlan) {
                if (studyPlan.getIdCareer() == idCareer && studyPlan.getIsActive()) {
                    return studyPlan;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves study plan types for selection.
     *
     * @return A map of study plan types.
     */
    public static Map<String, String> getTypeForSelect2() {
        Map<String, String> typeMap = new LinkedHashMap<>();
        for (String type : StudyPlan.TYPES_STUDY_PLAN) {
            typeMap.put(type, type);
        }
        return typeMap;
    }

    /**
     * Retrieves study plan IDs and names for selection.
     *
     * @return A map of study plan IDs and names.
     */
    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> studyPlanMap = new LinkedHashMap<>();
        for (Model model : StudyPlan.getAll().values()) {
            if (model instanceof StudyPlan studyPlan) {
                Career career = (Career) CareerService.getById(studyPlan.getIdCareer());
                String name = String.format("%s - %d (%s) Tipo: %s", career.getName(), studyPlan.getId(),
                        studyPlan.getIsActive() ? "Vigente" : "No Vigente", studyPlan.getType());
                studyPlanMap.put(studyPlan.getId(), name);
            }
        }
        return studyPlanMap;
    }
}
