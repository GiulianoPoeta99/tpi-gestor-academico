package main.studyplan;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import main.common.Model;

/**
 * The StudyPlan class represents a study plan within the system.
 * It includes attributes such as ID, type, career ID, and active status,
 * and provides methods to manage study plan data, including saving, updating,
 * and deleting instances.
 * Implements the Model interface for consistent data handling.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>TRANSLATE_NAME - A constant for the translated name of the study plan.</li>
 *   <li>TYPES_STUDY_PLAN - A list of valid types for study plans.</li>
 * </ul>
 *
 * <p>Static Attributes:</p>
 * <ul>
 *   <li>serial - A counter for generating unique IDs.</li>
 *   <li>all - A map to store all study plan instances by their ID.</li>
 * </ul>
 *
 * <p>Attributes:</p>
 * <ul>
 *   <li>id - The unique identifier for the study plan.</li>
 *   <li>type - The type of the study plan (e.g., A, B, C).</li>
 *   <li>idCareer - The ID of the associated career for the study plan.</li>
 *   <li>isActive - Indicates if the study plan is active or not.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *   <li>StudyPlan() - Default constructor.</li>
 *   <li>StudyPlan(String type, int idCareer, boolean isActive) - Protected constructor
 *   to create a study plan with a specified type, career ID, and active status.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>setId(int id) - Sets the ID of the study plan.</li>
 *   <li>getId() - Gets the ID of the study plan.</li>
 *   <li>setType(String type) - Sets the type of the study plan.</li>
 *   <li>getType() - Gets the type of the study plan.</li>
 *   <li>setIdCareer(int idCareer) - Sets the career ID of the study plan.</li>
 *   <li>getIdCareer() - Gets the career ID of the study plan.</li>
 *   <li>setIsActive(boolean isActive) - Sets the active status of the study plan.</li>
 *   <li>getIsActive() - Checks if the study plan is active.</li>
 *   <li>getAll() - Retrieves all study plan instances.</li>
 *   <li>addSerial() - Increments the serial counter.</li>
 *   <li>validate() - Validates the study plan instance.</li>
 *   <li>save() - Saves the study plan instance if valid.</li>
 *   <li>update() - Updates the study plan instance if valid.</li>
 *   <li>delete() - Deletes the study plan instance.</li>
 *   <li>getAttributeValues() - Gets the attribute values of the study plan.</li>
 *   <li>getAttributeNames() - Gets the attribute names of the study plan.</li>
 *   <li>toString() - Returns a string representation of the study plan.</li>
 * </ul>
 *
 * @see Model
 * @see LinkedHashMap
 * @see Map
 * @see String
 * @see Integer
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.06
 */
public class StudyPlan implements Model {
    public static final String TRANSLATE_NAME = "Plan de Estudio";
    public static final List<String> TYPES_STUDY_PLAN = Arrays.asList("A", "B", "C", "D", "E");
    private int id;
    private String type;
    private int idCareer;
    private boolean isActive;
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    /**
     * Default constructor.
     */
    public StudyPlan() {
    }

    /**
     * Protected constructor to create a StudyPlan with a specified type,
     * career ID, and active status.
     *
     * @param type The type of the study plan.
     * @param idCareer The ID of the associated career.
     * @param isActive The active status of the study plan.
     */
    protected StudyPlan(String type, int idCareer, boolean isActive) {
        this.type = type;
        this.idCareer = idCareer;
        this.isActive = isActive;
        this.save();
    }

    /**
     * Sets the ID of the study plan.
     *
     * @param id The ID to set.
     * @return This StudyPlan instance.
     */
    public StudyPlan setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the ID of the study plan.
     *
     * @return The ID of the study plan.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the type of the study plan.
     * If the provided type is not in the valid list, sets it to "ERROR".
     *
     * @param type The type to set.
     */
    public void setType(String type) {
        if (TYPES_STUDY_PLAN.contains(type)) {
            this.type = type;
        } else {
            this.type = "ERROR";
        }
    }

    /**
     * Gets the type of the study plan.
     *
     * @return The type of the study plan.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the career ID of the study plan.
     *
     * @param idCareer The career ID to set.
     */
    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }

    /**
     * Gets the career ID of the study plan.
     *
     * @return The career ID of the study plan.
     */
    public int getIdCareer() {
        return idCareer;
    }

    /**
     * Sets the active status of the study plan.
     *
     * @param isActive The active status to set.
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Checks if the study plan is active.
     *
     * @return True if the study plan is active, false otherwise.
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Retrieves all study plan instances.
     *
     * @return A map of all study plan instances.
     */
    public static Map<Integer, Model> getAll() {
        return all;
    }

    /**
     * Increments the serial counter.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Validates the study plan instance.
     *
     * @return True if the study plan instance is valid, false otherwise.
     */
    @Override
    public boolean validate() {
        return (type != null &&
                idCareer != 0);
    }

    /**
     * Saves the study plan instance if valid.
     *
     * @return True if the study plan instance was successfully saved, false otherwise.
     */
    @Override
    public boolean save() {
        if (validate()) {
            addSerial();
            id = serial;
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Updates the study plan instance if valid.
     *
     * @return True if the study plan instance was successfully updated, false otherwise.
     */
    @Override
    public boolean update() {
        if (this.validate()) {
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Deletes the study plan instance.
     */
    @Override
    public void delete() {
        all.remove(id, this);
    }

    /**
     * Gets the attribute values of the study plan.
     *
     * @return An array of attribute values.
     */
    @Override
    public Object[] getAttributeValues() {
        return new Object[] { type, idCareer, isActive };
    }

    /**
     * Gets the attribute names of the study plan.
     *
     * @return An array of attribute names.
     */
    @Override
    public String[] getAttributeNames() {
        return new String[] { "Tipo", "ID Carrera", "Vigente" };
    }

    /**
     * Returns a string representation of the study plan.
     *
     * @return A string representation of the study plan.
     */
    @Override
    public String toString() {
        return String.format("""
                %s:
                  * Tipo: %s
                  * Carrera: %s
                  * Vigente: %s
                """,
                TRANSLATE_NAME,
                type != null ? type : "N/A",
                idCareer != 0 ? idCareer : "N/A",
                isActive);
    }
}
