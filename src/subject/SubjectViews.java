package subject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.Model;
import common.components.Text;
import common.components.UIComponent;

public class SubjectViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {

        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Subject.TRANSLATE_NAME);
        components.add(title);

        JPanel boxPanel = UIComponent.bigBox();

        JScrollPane table = UIComponent.table(allData);

        boxPanel.setLayout(new BorderLayout());
        boxPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        components.add(boxPanel);

        return components;
    }
}
