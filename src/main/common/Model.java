package main.common;

/**
 * The Model interface provides a contract for validating, saving, updating,
 * and deleting objects, as well as retrieving their attribute values and names.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>{@code validate()} - Validates the model instance.</li>
 *   <li>{@code save()} - Saves the model instance if valid.</li>
 *   <li>{@code update()} - Updates the model instance if valid.</li>
 *   <li>{@code delete()} - Deletes the model instance.</li>
 *   <li>{@code getAttributeValues()} - Retrieves the attribute values of the model instance.</li>
 *   <li>{@code getAttributeNames()} - Retrieves the attribute names of the model instance.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2023.12.05
 * @author Giuliano Ignacio Poeta
 */
public interface Model {
    /**
     * Validates the model instance.
     *
     * @return {@code true} if the model instance is valid, {@code false} otherwise.
     */
    boolean validate();

    /**
     * Saves the model instance if valid.
     *
     * @return {@code true} if the model instance was successfully saved, {@code false} otherwise.
     */
    boolean save();

    /**
     * Updates the model instance if valid.
     *
     * @return {@code true} if the model instance was successfully updated, {@code false} otherwise.
     */
    boolean update();

    /**
     * Deletes the model instance.
     */
    void delete();

    /**
     * Retrieves the attribute values of the model instance.
     *
     * @return An array of attribute values.
     */
    Object[] getAttributeValues();

    /**
     * Retrieves the attribute names of the model instance.
     *
     * @return An array of attribute names.
     */
    String[] getAttributeNames();
}
