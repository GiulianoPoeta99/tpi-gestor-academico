package common;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

/**
 * Represents a generic controller interface.
 * Controllers are responsible for handling user interactions and managing data flow.
 * Implementations of this interface should define methods for basic CRUD operations.
 * 
 * The main purpose of each method is as follows:
 * - main(): Entry point for the controller, typically used to initiate the application or module.
 * - create(): Handles the creation of new entities or data.
 * - update(): Handles the update or modification of existing entities or data.
 * - view(): Handles the retrieval and presentation of data for user viewing.
 * - delete(): Handles the deletion or removal of entities or data.
 * 
 * @author Giuliano Ignacio Poeta
 */
public interface Controller {
    /**
     * Entry point for the controller.
     * This method is typically used to initiate the application or module.
     */
    void index();

    /**
     * Handles the creation of new entities or data.
     */
    void create();

    /**
     * Handles the update or modification of existing entities or data.
     */
    void update();

    /**
     * Handles the retrieval and presentation of data for user viewing.
     */
    void view();

    /**
     * Handles the deletion or removal of entities or data.
     */
    void delete();

    /**
     * Renders the view specified by the provided method.
     * @param viewMethod The method of the view to render.
     */
    default void render(Supplier<List<JComponent>> viewMethod) {
        // Get the content panel
        JPanel contentPanel = common.components.LayOutComponent.getContentPanel();

        // Clear existing content
        contentPanel.removeAll();

        // Execute the view method to render the content
        List<JComponent> components = viewMethod.get(); // Utilizar get() en lugar de run()

        // Add the components to the content panel
        for (JComponent component : components) {
            contentPanel.add(component);
        }

        // Repaint the content panel
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
