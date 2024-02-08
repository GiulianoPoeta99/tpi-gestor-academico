package common;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

public interface Controller {
    void index();

    void create();

    void update();

    void view();

    void delete();

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
