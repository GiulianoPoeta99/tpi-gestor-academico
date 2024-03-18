package main.common;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

public interface Controller {
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
