package main.career;

import java.util.LinkedHashMap;
import java.util.Map;

import main.common.Model;

/**
 * The Career class represents an academic career within the system.
 * It includes attributes such as ID and name, and provides methods to
 * manage career data, including saving, updating, and deleting instances.
 * Implements the Model interface for consistent data handling.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>TRANSLATE_NAME - A constant for the translated name of the career.</li>
 * </ul>
 *
 * <p>Static Attributes:</p>
 * <ul>
 *   <li>serial - A counter for generating unique IDs.</li>
 *   <li>all - A map to store all career instances by their ID.</li>
 * </ul>
 *
 * <p>Attributes:</p>
 * <ul>
 *   <li>id - The unique identifier for the career.</li>
 *   <li>name - The name of the career.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *   <li>Career() - Default constructor.</li>
 *   <li>Career(String name) - Protected constructor to create a career with a given name and save it.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>setId(int id) - Sets the ID of the career.</li>
 *   <li>getId() - Gets the ID of the career.</li>
 *   <li>setName(String name) - Sets the name of the career.</li>
 *   <li>getName() - Gets the name of the career.</li>
 *   <li>getAll() - Retrieves all career instances.</li>
 *   <li>addSerial() - Increments the serial counter.</li>
 *   <li>validate() - Validates the career instance.</li>
 *   <li>save() - Saves the career instance if valid.</li>
 *   <li>update() - Updates the career instance if valid.</li>
 *   <li>delete() - Deletes the career instance.</li>
 *   <li>getAttributeValues() - Gets the attribute values of the career.</li>
 *   <li>getAttributeNames() - Gets the attribute names of the career.</li>
 *   <li>toString() - Returns a string representation of the career.</li>
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
 * @since 2023.12.05
 */
public class Career implements Model {

    public static final String TRANSLATE_NAME = "Carrera";

    private int id;
    private String name;

    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    /**
     * Default constructor.
     */
    public Career() {
    }

    /**
     * Protected constructor to create a Career with a specified name.
     *
     * @param name The name of the career.
     */
    protected Career(String name) {
        this.name = name;
        save();
    }

    /**
     * Sets the ID of the career.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the career.
     *
     * @return The ID of the career.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the name of the career.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the career.
     *
     * @return The name of the career.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves all career instances.
     *
     * @return A map of all career instances.
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
     * Validates the career instance.
     *
     * @return True if the career name is not null, otherwise false.
     */
    @Override
    public boolean validate() {
        return name != null;
    }

    /**
     * Saves the career instance if valid.
     *
     * @return True if the career instance was successfully saved, otherwise false.
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
     * Updates the career instance if valid.
     *
     * @return True if the career instance was successfully updated, otherwise false.
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
     * Deletes the career instance.
     */
    @Override
    public void delete() {
        all.remove(id, this);
    }

    /**
     * Gets the attribute values of the career.
     *
     * @return An array of attribute values.
     */
    @Override
    public Object[] getAttributeValues() {
        return new Object[] { name };
    }

    /**
     * Gets the attribute names of the career.
     *
     * @return An array of attribute names.
     */
    @Override
    public String[] getAttributeNames() {
        return new String[] { "Nombre" };
    }

    /**
     * Returns a string representation of the career.
     *
     * @return A string representation of the career.
     */
    @Override
    public String toString() {
        return String.format("""
                %s
                  * Nombre: %s
                """,
                TRANSLATE_NAME,
                name != null ? name : "N/A");
    }
}
