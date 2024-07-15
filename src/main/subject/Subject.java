package main.subject;

import java.util.LinkedHashMap;
import java.util.Map;

import main.common.Model;

/**
 * The Subject class represents an academic subject within the system.
 * It includes attributes such as ID, name, optional status, promotable status,
 * four-month period, and study plan ID, and provides methods to manage subject data,
 * including saving, updating, and deleting instances. Implements the Model interface for consistent data handling.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>TRANSLATE_NAME - A constant for the translated name of the subject.</li>
 * </ul>
 *
 * <p>Static Attributes:</p>
 * <ul>
 *   <li>serial - A counter for generating unique IDs.</li>
 *   <li>all - A map to store all subject instances by their ID.</li>
 * </ul>
 *
 * <p>Attributes:</p>
 * <ul>
 *   <li>id - The unique identifier for the subject.</li>
 *   <li>name - The name of the subject.</li>
 *   <li>isOptional - Indicates if the subject is optional.</li>
 *   <li>isPromotable - Indicates if the subject is promotable.</li>
 *   <li>fourMonths - The four-month period for the subject.</li>
 *   <li>idStudyPlan - The study plan ID associated with the subject.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *   <li>Subject() - Default constructor.</li>
 *   <li>Subject(String name, boolean isOptional, boolean isPromotable, int fourMonths, int idStudyPlan) - Protected constructor to create a subject with specified attributes and save it.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>setId(int id) - Sets the ID of the subject.</li>
 *   <li>getId() - Gets the ID of the subject.</li>
 *   <li>setName(String name) - Sets the name of the subject.</li>
 *   <li>getName() - Gets the name of the subject.</li>
 *   <li>setIsOptional(boolean isOptional) - Sets whether the subject is optional.</li>
 *   <li>getIsOptional() - Gets whether the subject is optional.</li>
 *   <li>setIsPromotable(boolean isPromotable) - Sets whether the subject is promotable.</li>
 *   <li>getIsPromotable() - Gets whether the subject is promotable.</li>
 *   <li>setFourMonths(int fourMonths) - Sets the four-month period for the subject.</li>
 *   <li>getFourMonths() - Gets the four-month period for the subject.</li>
 *   <li>setIdStudyPlan(int idStudyPlan) - Sets the study plan ID associated with the subject.</li>
 *   <li>getIdStudyPlan() - Gets the study plan ID associated with the subject.</li>
 *   <li>getAll() - Retrieves all subject instances.</li>
 *   <li>addSerial() - Increments the serial counter.</li>
 *   <li>validate() - Validates the subject instance.</li>
 *   <li>save() - Saves the subject instance if valid.</li>
 *   <li>update() - Updates the subject instance if valid.</li>
 *   <li>delete() - Deletes the subject instance.</li>
 *   <li>getAttributeValues() - Gets the attribute values of the subject.</li>
 *   <li>getAttributeNames() - Gets the attribute names of the subject.</li>
 *   <li>toString() - Returns a string representation of the subject.</li>
 * </ul>
 *
 * @see Model
 * @see LinkedHashMap
 * @see Map
 * @see String
 * @see Integer
 * @see Boolean
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.06
 */
public class Subject implements Model {
    public static final String TRANSLATE_NAME = "Materia";
    private int id;
    private String name;
    private boolean isOptional;
    private boolean isPromotable;
    private int fourMonths;
    private int idStudyPlan;
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    /**
     * Default constructor.
     */
    public Subject() {
    }

    /**
     * Protected constructor to create a Subject with specified attributes.
     *
     * @param name The name of the subject.
     * @param isOptional Indicates if the subject is optional.
     * @param isPromotable Indicates if the subject is promotable.
     * @param fourMonths The four-month period for the subject.
     * @param idStudyPlan The study plan ID associated with the subject.
     */
    protected Subject(
            String name,
            boolean isOptional,
            boolean isPromotable,
            int fourMonths,
            int idStudyPlan) {
        this.name = name;
        this.isOptional = isOptional;
        this.isPromotable = isPromotable;
        this.fourMonths = fourMonths;
        this.idStudyPlan = idStudyPlan;
        this.save();
    }

    /**
     * Sets the ID of the subject.
     *
     * @param id The ID to set.
     * @return The Subject instance with the updated ID.
     */
    public Subject setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the ID of the subject.
     *
     * @return The ID of the subject.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the name of the subject.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the subject.
     *
     * @return The name of the subject.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets whether the subject is optional.
     *
     * @param isOptional The optional status to set.
     */
    public void setIsOptional(boolean isOptional) {
        this.isOptional = isOptional;
    }

    /**
     * Gets whether the subject is optional.
     *
     * @return The optional status of the subject.
     */
    public boolean getIsOptional() {
        return this.isOptional;
    }

    /**
     * Sets whether the subject is promotable.
     *
     * @param isPromotable The promotable status to set.
     */
    public void setIsPromotable(boolean isPromotable) {
        this.isPromotable = isPromotable;
    }

    /**
     * Gets whether the subject is promotable.
     *
     * @return The promotable status of the subject.
     */
    public boolean getIsPromotable() {
        return this.isPromotable;
    }

    /**
     * Sets the four-month period for the subject.
     *
     * @param fourMonths The four-month period to set.
     */
    public void setFourMonths(int fourMonths) {
        this.fourMonths = fourMonths;
    }

    /**
     * Gets the four-month period for the subject.
     *
     * @return The four-month period of the subject.
     */
    public int getFourMonths() {
        return this.fourMonths;
    }

    /**
     * Sets the study plan ID associated with the subject.
     *
     * @param idStudyPlan The study plan ID to set.
     */
    public void setIdStudyPlan(int idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
    }

    /**
     * Gets the study plan ID associated with the subject.
     *
     * @return The study plan ID of the subject.
     */
    public int getIdStudyPlan() {
        return this.idStudyPlan;
    }

    /**
     * Retrieves all subject instances.
     *
     * @return A map of all subject instances.
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
     * Validates the subject instance.
     *
     * @return True if the subject has a name, a non-zero four-month period, and a non-zero study plan ID; otherwise, false.
     */
    @Override
    public boolean validate() {
        return (name != null &&
                fourMonths != 0 &&
                idStudyPlan != 0);
    }

    /**
     * Saves the subject instance if valid.
     *
     * @return True if the subject instance was successfully saved, otherwise false.
     */
    @Override
    public boolean save() {
        if (this.validate()) {
            addSerial();
            id = serial;
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Updates the subject instance if valid.
     *
     * @return True if the subject instance was successfully updated, otherwise false.
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
     * Deletes the subject instance.
     */
    @Override
    public void delete() {
        all.remove(id, this);
    }

    /**
     * Gets the attribute values of the subject.
     *
     * @return An array of attribute values.
     */
    @Override
    public Object[] getAttributeValues() {
        return new Object[] { name, isOptional, fourMonths, idStudyPlan };
    }

    /**
     * Gets the attribute names of the subject.
     *
     * @return An array of attribute names.
     */
    @Override
    public String[] getAttributeNames() {
        return new String[] { "Nombre", "Opcional", "Cuatrimestre", "ID Plan de studio" };
    }

    /**
     * Returns a string representation of the subject.
     *
     * @return A string representation of the subject.
     */
    @Override
    public String toString() {
        return String.format("""
                %s:
                  * Nombre: %s
                  * Cuatrimestre: %d
                  * ID plan de estudio: %s
                """,
                TRANSLATE_NAME,
                name,
                fourMonths,
                idStudyPlan);
    }
}
