package career;

import java.util.HashMap;
import java.util.Map;

import common.Model;

/**
 * Represents a career entity.
 * This class implements the Model interface.
 * It provides methods to manage career information.
 *
 * @author Giuliano Ignacio Poeta
 */
public class Career implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Carrera";

    // Attributes
    private int id;
    private String name;
    private int idStudyPlan;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Career> all = new HashMap<>();

    // Constructors ============================================================

    /**
     * Default constructor for the Career class.
     */
    public Career() {}

    /**
     * Parameterized constructor for the Career class.
     * Initializes a new career with the provided attributes and saves it.
     *
     * @param name The name of the career.
     */
    protected Career(String name) {
        this.setName(name);
        this.save();
    }

    /**
     * Copy constructor for the Career class.
     * Initializes a new career with the same attributes as the given career.
     *
     * @param career The career to copy.
     */
    protected Career(Career career) {
        addSerial();
        career.setId(serial);
        this.setId(serial);
        all.put(career.getId(), career);
    }

    // Setters & Getters =======================================================

    /**
     * Sets the ID of the career.
     *
     * @param id The ID to set.
     * @return This career instance.
     */
    public Career setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the ID of the career.
     *
     * @return The ID of the career.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the name of the career.
     *
     * @param name The name to set.
     * @return This career instance.
     */
    public Career setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the name of the career.
     *
     * @return The name of the career.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the ID of the study plan associated with the career.
     *
     * @param idStudyPlan The ID of the study plan to set.
     * @return This career instance.
     */
    public Career setIdStudyPlan(int idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
        return this;
    }

    /**
     * Gets the ID of the study plan associated with the career.
     *
     * @return The ID of the study plan.
     */
    public int getIdStudyPlan() {
        return this.idStudyPlan;
    }

    // Methods ================================================================

    /**
     * Retrieves a career by ID from the collection of all careers.
     *
     * @param id The ID of the career to retrieve.
     * @return The career with the specified ID, or null if not found.
     */
    public static Career getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a mapping of all careers where the key is the career ID.
     *
     * @return A mapping of all careers.
     */
    public static Map<Integer, Career> getAll() {
        return Career.all;
    }

    /**
     * Increments the serial number for career instances.
     * This method is used internally.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Loads initial data for testing purposes.
     * This method initializes career instances with sample data.
     * The careers are then added to the collection of all careers.
     */
    public static void loadData() {
        new Career("Tecnicatura en sistemas");
        new Career("Licenciatura en sistemas");
    }

    // Implements ==============================================================

    /**
     * Validates the career's information.
     * This method is part of the Model interface.
     *
     * @return true if the career is valid, false otherwise.
     */
    @Override
    public boolean validate() {
        return (
            this.getName() != null &&
            this.getIdStudyPlan() != 0
        );
    }

    /**
     * Saves the career if it passes validation.
     * This method is part of the Model interface.
     */
    @Override
    public void save() {
        if (this.validate()) {
            new Career(this);
        }
    }

    // Overrides ===============================================================

    /**
     * Generates a string representation of the career.
     *
     * @return A formatted string with career information.
     */
    @Override
    public String toString() {
        return String.format("""
            %s:
              * Nombre: %s
            """,
            TRANSLATE_NAME,
            this.getName(), "N/A"
        );
    }
}
