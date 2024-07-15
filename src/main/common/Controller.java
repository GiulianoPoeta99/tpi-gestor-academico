package main.common;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

/**
 * The Controller interface provides a default method to render a list of Swing components
 * within a content panel. This method is intended to be used to update the UI dynamically.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>render(Supplier<List<JComponent>> viewMethod) - Renders the provided list of components in the content panel.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2023.12.05
 * @author Giuliano Ignacio Poeta
 */
public interface Controller {
    /**
     * Renders a list of Swing components within the content panel.
     *
     * @param viewMethod A supplier that provides the list of components to be rendered.
     */
    default void render(Supplier<List<JComponent>> viewMethod) {
        JPanel contentPanel = main.common.components.LayOut.getContentPanel();
        contentPanel.removeAll();

        List<JComponent> components = viewMethod.get();
        for (JComponent component : components) {
            contentPanel.add(component);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
