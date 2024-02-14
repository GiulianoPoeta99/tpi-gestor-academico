package common;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

public interface Controller {
    void index();

    void create(boolean save);

    void update(int id);

    void view(int id);

    void delete(int id);

    default void render(Supplier<List<JComponent>> viewMethod) {
        JPanel contentPanel = common.components.LayOut.getContentPanel();
        contentPanel.removeAll();

        List<JComponent> components = viewMethod.get();
        for (JComponent component : components) {
            contentPanel.add(component);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
