package common;

/**
 * Represents a generic model interface.
 * Models typically represent entities or data structures in an application.
 * Implementations of this interface should define methods for data validation and persistence.
 * 
 * The main purpose of each method is as follows:
 * - validate(): Validates the data integrity of the model.
 * - save(): Persists the model data, typically by storing it in a database or another storage medium.
 * 
 * @author Giuliano Ignacio Poeta
 */
public interface Model {
    /**
     * Validates the data integrity of the model.
     * 
     * @return true if the model data is valid, false otherwise.
     */
    boolean validate(); 

    /**
     * Persists the model data.
     * This method is responsible for saving the model data, typically by storing it in a database
     * or another storage medium.
     */
    void save();
}
