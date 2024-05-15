package main.career;

import main.common.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The CareerService class extends the Career class to provide additional
 * methods for retrieving and manipulating career data in custom formats.
 * This includes methods for getting custom columns, custom data, and mapping
 * IDs to names for use in selection components.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getCustomColumns() - Returns an array of custom column names for career data.</li>
 *   <li>getCustomData() - Returns a list of custom career data rows.</li>
 *   <li>getById(int id) - Retrieves a career model by its ID.</li>
 *   <li>getIDNameForSelect2() - Returns a map of career IDs to names for selection components.</li>
 * </ul>
 *
 * @see Career
 * @see Model
 * @see List
 * @see Map
 * @see ArrayList
 * @see LinkedHashMap
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.27
 */
public class CareerService extends Career {

    /**
     * Returns an array of custom column names for career data.
     *
     * @return An array of custom column names.
     */
    public static String[] getCustomColumns() {
        return new String[] { "Nombre" };
    }

    /**
     * Returns a list of custom career data rows.
     * Each row is represented as an array of objects containing the career name.
     *
     * @return A list of custom career data rows.
     */
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Career.getAll().values()) {
            if (model instanceof Career career) {
                Object[] rowData = new Object[] { career.getName() };
                customData.add(rowData);
            }
        }
        return customData;
    }

    /**
     * Retrieves a career model by its ID.
     *
     * @param id The ID of the career model to retrieve.
     * @return The career model with the specified ID.
     */
    public static Model getById(int id) {
        return all.get(id);
    }

    /**
     * Returns a map of career IDs to names for selection components.
     *
     * @return A map of career IDs to names.
     */
    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> careerMap = new LinkedHashMap<>();
        for (Model model : Career.getAll().values()) {
            if (model instanceof Career career) {
                careerMap.put(career.getId(), career.getName());
            }
        }
        return careerMap;
    }
}
