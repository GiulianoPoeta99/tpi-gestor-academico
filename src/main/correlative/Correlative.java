package main.correlative;

import main.common.Model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Correlative class represents the relationship between subjects
 * in terms of academic prerequisites or corequisites within the system.
 * It includes attributes such as IDs of the related subjects and provides
 * methods to manage correlative data, including saving, updating, and deleting instances.
 * Implements the Model interface for consistent data handling.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>TRANSLATE_NAME - A constant for the translated name of the correlative relationship.</li>
 * </ul>
 *
 * <p>Static Attributes:</p>
 * <ul>
 *   <li>serial - A counter for generating unique IDs.</li>
 *   <li>all - A map to store all correlative instances by their ID.</li>
 * </ul>
 *
 * <p>Attributes:</p>
 * <ul>
 *   <li>id - The unique identifier for the correlative relationship.</li>
 *   <li>idSubject - The ID of the subject.</li>
 *   <li>idSubjectCorrelative - The ID of the correlative subject.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *   <li>Correlative() - Default constructor.</li>
 *   <li>Correlative(int idSubject, int idSubjectCorrelative) - Protected constructor
 *       to create a correlative relationship between two subjects and save it.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>setId(int id) - Sets the ID of the correlative relationship.</li>
 *   <li>getId() - Gets the ID of the correlative relationship.</li>
 *   <li>setIdSubject(int idSubject) - Sets the ID of the subject.</li>
 *   <li>getIdSubject() - Gets the ID of the subject.</li>
 *   <li>setIdSubjectCorrelative(int idSubjectCorrelative) - Sets the ID of the correlative subject.</li>
 *   <li>getIdSubjectCorrelative() - Gets the ID of the correlative subject.</li>
 *   <li>getAll() - Retrieves all correlative instances.</li>
 *   <li>addSerial() - Increments the serial counter.</li>
 *   <li>validate() - Validates the correlative relationship instance.</li>
 *   <li>save() - Saves the correlative relationship instance if valid.</li>
 *   <li>update() - Updates the correlative relationship instance if valid.</li>
 *   <li>delete() - Deletes the correlative relationship instance.</li>
 *   <li>getAttributeValues() - Gets the attribute values of the correlative relationship.</li>
 *   <li>getAttributeNames() - Gets the attribute names of the correlative relationship.</li>
 *   <li>toString() - Returns a string representation of the correlative relationship.</li>
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
 * @since 2024.04.04
 */
public class Correlative implements Model {
    public static final String TRANSLATE_NAME = "Correlativas";
    private int id;
    private int idSubject;
    private int idSubjectCorrelative;
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    /**
     * Default constructor.
     */
    public Correlative() {
    }

    /**
     * Protected constructor to create a Correlative relationship between two subjects.
     *
     * @param idSubject             The ID of the subject.
     * @param idSubjectCorrelative  The ID of the correlative subject.
     */
    protected Correlative(int idSubject, int idSubjectCorrelative) {
        this.idSubject = idSubject;
        this.idSubjectCorrelative = idSubjectCorrelative;
        save();
    }

    /**
     * Sets the ID of the correlative relationship.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the correlative relationship.
     *
     * @return The ID of the correlative relationship.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the subject.
     *
     * @param idSubject The ID to set.
     */
    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    /**
     * Gets the ID of the subject.
     *
     * @return The ID of the subject.
     */
    public int getIdSubject() {
        return idSubject;
    }

    /**
     * Sets the ID of the correlative subject.
     *
     * @param idSubjectCorrelative The ID to set.
     */
    public void setIdSubjectCorrelative(int idSubjectCorrelative) {
        this.idSubjectCorrelative = idSubjectCorrelative;
    }

    /**
     * Gets the ID of the correlative subject.
     *
     * @return The ID of the correlative subject.
     */
    public int getIdSubjectCorrelative() {
        return idSubjectCorrelative;
    }

    /**
     * Retrieves all correlative instances.
     *
     * @return A map of all correlative instances.
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
     * Validates the correlative relationship instance.
     *
     * @return True if both subject IDs are greater than zero, otherwise false.
     */
    @Override
    public boolean validate() {
        return ((idSubject > 0) && (idSubjectCorrelative > 0));
    }

    /**
     * Saves the correlative relationship instance if valid.
     *
     * @return True if the correlative relationship instance was successfully saved, otherwise false.
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
     * Updates the correlative relationship instance if valid.
     *
     * @return True if the correlative relationship instance was successfully updated, otherwise false.
     */
    @Override
    public boolean update() {
        if (validate()) {
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Deletes the correlative relationship instance.
     */
    @Override
    public void delete() {
        all.remove(id, this);
    }

    /**
     * Gets the attribute values of the correlative relationship.
     *
     * @return An empty array (no specific attributes to return).
     */
    @Override
    public Object[] getAttributeValues() {
        return new Object[] {};
    }

    /**
     * Gets the attribute names of the correlative relationship.
     *
     * @return An empty array (no specific attributes to return).
     */
    @Override
    public String[] getAttributeNames() {
        return new String[] {};
    }

    /**
     * Returns a string representation of the correlative relationship.
     *
     * @return A string representation of the correlative relationship.
     */
    @Override
    public String toString() {
        return String.format("""
                %s
                  * Materia: %d
                  * Materia correlativa: %d
                """,
                TRANSLATE_NAME,
                idSubject,
                idSubjectCorrelative);
    }
}
