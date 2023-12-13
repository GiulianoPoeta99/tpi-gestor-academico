package subject;

import java.util.HashMap;
import java.util.Map;

import common.Model;

/**
 * Represents a subject entity.
 * This class implements the Model interface.
 * It provides methods to manage subject information.
 * 
 * The subject has a name, optional status, a duration of four months, and is associated with a study plan.
 * Each subject is identified by an ID.
 * 
 * @author Giuliano Ignacio Poeta
 */
public class Subject implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Subject";

    // Attributes
    private int id;
    private String name;
    private boolean isOptional;
    private int fourMonths;
    private int idStudyPlan;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Subject> all = new HashMap<Integer, Subject>();

    // Builders ============================================================

    /**
     * Default constructor for the Subject class.
     */
    public Subject() {}

    /**
     * Builder constructor for the Subject class.
     * Initializes a new subject with the specified attributes.
     * The subject is saved if it passes validation.
     *
     * @param name The name of the subject.
     * @param isOptional The optional status of the subject.
     * @param fourMonths The duration of the subject in months.
     * @param idStudyPlan The ID of the study plan associated with the subject.
     */
    protected Subject(
        String name,
        boolean isOptional,
        int fourMonths,
        int idStudyPlan
    ) {
        this.setName(name);
        this.setIsOptional(isOptional);
        this.setFourMonths(fourMonths);
        this.setIdStudyPlan(idStudyPlan);
        this.save();
    }

    /**
     * Copy constructor for the Subject class.
     * Initializes a new subject with the same attributes as the given subject.
     *
     * @param subject The subject to copy.
     */
    protected Subject(Subject subject) {
        addSerial();
        subject.setId(serial);
        this.setId(serial);
        all.put(subject.getId(), subject);
    }

    // Setters & Getters =======================================================

    /**
     * Sets the ID of the subject.
     *
     * @param id The ID to set.
     * @return This subject instance.
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
     * @return This subject instance.
     */
    public Subject setName(String name) {
        this.name = name;
        return this;
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
     * Sets the optional status of the subject.
     *
     * @param isOptional The optional status to set.
     * @return This subject instance.
     */
    public Subject setIsOptional(boolean isOptional) {
        this.isOptional = isOptional;
        return this;
    }

    /**
     * Gets the optional status of the subject.
     *
     * @return The optional status of the subject.
     */
    public boolean getIsOptional() {
        return this.isOptional;
    }

    /**
     * Sets the duration of the subject in months.
     *
     * @param fourMonths The duration in months to set.
     * @return This subject instance.
     */
    public Subject setFourMonths(int fourMonths) {
        this.fourMonths = fourMonths;
        return this;
    }

    /**
     * Gets the duration of the subject in months.
     *
     * @return The duration of the subject in months.
     */
    public int getFourMonths() {
        return this.fourMonths;
    }

    /**
     * Sets the ID of the study plan associated with the subject.
     *
     * @param idStudyPlan The ID of the study plan.
     * @return This subject instance.
     */
    public Subject setIdStudyPlan(int idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
        return this;
    }

    /**
     * Gets the ID of the study plan associated with the subject.
     *
     * @return The ID of the study plan.
     */
    public int getIdStudyPlan() {
        return this.idStudyPlan;
    }

    // Methods ================================================================

    /**
     * Retrieves a subject by ID from the collection of all subjects.
     *
     * @param id The ID of the subject to retrieve.
     * @return The subject with the specified ID, or null if not found.
     */
    public static Subject getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a mapping of all subjects where the key is the subject ID.
     *
     * @return A mapping of all subjects.
     */
    public static Map<Integer, Subject> getAll() {
        return all;
    }

    /**
     * Increments the serial number for subject instances.
     * This method is used internally.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Loads initial data for testing purposes.
     * This method creates a new subject with default values.
     */
    public static void loadData() {
        new Subject();
    }

    // Implements ==============================================================

    /**
     * Validates the subject's information.
     * This method is part of the Model interface.
     *
     * @return true if the subject is valid, false otherwise.
     */
    @Override
    public boolean validate() {
        return (
            this.getName() != null &&
            this.getFourMonths() != 0 &&
            this.getIdStudyPlan() != 0
        );
    }

    /**
     * Saves the subject if it passes validation.
     * This method is part of the Model interface.
     */
    @Override
    public void save() {
        if (this.validate()) {
            new Subject(this);
        }
    }

    // Overrides ===============================================================

    /**
     * Generates a string representation of the subject.
     *
     * @return A formatted string with subject information.
     */
    @Override
    public String toString() {
        return String.format("""
            %s:
              * Name: %s
              * Four Months: %s
            """,
            TRANSLATE_NAME,
            this.getName(), "N/A",
            this.getFourMonths(), "N/A"
        );
    }
}
