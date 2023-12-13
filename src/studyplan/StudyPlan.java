package studyplan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Model;

/**
 * Represents a study plan entity.
 * This class implements the Model interface.
 * It provides methods to manage study plan information.
 * 
 * The study plan has a type, and there are predefined types identified by letters A, B, C, D, and E.
 * Each study plan is associated with an ID.
 * 
 * @author Giuliano Ignacio Poeta
 */
public class StudyPlan implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Plan de Estudio";
    private static final List<String> TYPES_STUDY_PLAN = Arrays.asList("A", "B", "C", "D", "E");

    // Attributes
    private int id;
    private String type;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, StudyPlan> all = new HashMap<Integer, StudyPlan>();

    // Builders ============================================================

    /**
     * Default constructor for the StudyPlan class.
     */
    public StudyPlan() {}

    /**
     * Builder constructor for the StudyPlan class.
     * Initializes a new study plan with the specified type.
     * The type is set using the setType method, and the study plan is saved.
     *
     * @param type The type of the study plan.
     */
    protected StudyPlan(String type) {
        this.setType(type);
        this.save();
    }


    /**
     * Copy constructor for the StudyPlan class.
     * Initializes a new study plan with the same attributes as the given study plan.
     *
     * @param studyPlan The study plan to copy.
     */
    protected StudyPlan(StudyPlan studyPlan) {
        addSerial();
        studyPlan.setId(serial);
        all.put(studyPlan.getId(), studyPlan);
    }

    // Setters & Getters =======================================================

    /**
     * Sets the ID of the study plan.
     *
     * @param id The ID to set.
     * @return This study plan instance.
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
        return this.id;
    }

    /**
     * Sets the type of the study plan.
     * Checks if the new type is in the list before assigning it.
     * If the provided type is not in the predefined list, sets the type to "ERROR".
     *
     * @param type The type to set.
     * @return This study plan instance.
     */
    public StudyPlan setType(String type) {
        // Check if the new type is in the list before assigning it
        if (TYPES_STUDY_PLAN.contains(type)) {
            this.type = type;
        } else {
            this.type = "ERROR";
        }
        return this;
    }


    /**
     * Gets the type of the study plan.
     *
     * @return The type of the study plan.
     */
    public String getType() {
        return this.type;
    }

    // Methods ================================================================

    /**
     * Retrieves a study plan by ID from the collection of all study plans.
     *
     * @param id The ID of the study plan to retrieve.
     * @return The study plan with the specified ID, or null if not found.
     */
    public static StudyPlan getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a mapping of all study plans where the key is the study plan ID.
     *
     * @return A mapping of all study plans.
     */
    public static Map<Integer, StudyPlan> getAll() {
        return all;
    }

    /**
     * Increments the serial number for study plan instances.
     * This method is used internally.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Loads initial data for testing purposes.
     * This method creates a new study plan with default values.
     */
    public static void loadData() {
        new StudyPlan();
    }

    // Implements ==============================================================

    /**
     * Validates the study plan's information.
     * This method is part of the Model interface.
     *
     * @return true if the study plan is valid, false otherwise.
     */
    @Override
    public boolean validate() {
        // Validation logic goes here
        return (this.getType() != null);
    }

    /**
     * Saves the study plan if it passes validation.
     * This method is part of the Model interface.
     */
    @Override
    public void save() {
        if (this.validate()) {
            new StudyPlan(this);
        }
    }

    // Overrides ===============================================================

    /**
     * Generates a string representation of the study plan.
     *
     * @return A formatted string with study plan information.
     */
    @Override
    public String toString() {
        return String.format("""
            %s:
              * Tipo: %s
            """,
            TRANSLATE_NAME,
            this.getType(), "N/A"
        );
    }
}
