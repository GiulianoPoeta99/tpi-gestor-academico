package common;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

public interface Controller {
    void index();

    void create();

    void update(int id);

    void view();

    void delete();

    default void render(Supplier<List<JComponent>> viewMethod) {
        JPanel contentPanel = common.components.LayOutComponent.getContentPanel();
        contentPanel.removeAll();

        List<JComponent> components = viewMethod.get();
        for (JComponent component : components) {
            contentPanel.add(component);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
