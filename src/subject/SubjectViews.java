package subject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import career.Career;
import common.Model;
import common.components.CommonComponent;

public class SubjectViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {

        List<JComponent> components = new ArrayList<>();

        // Título tipo H1
        JLabel title = CommonComponent.h1(Subject.TRANSLATE_NAME);
        components.add(title);

        // Box debajo del título
        JPanel boxPanel = CommonComponent.bigBox();

        // Crear tabla
        JTable table = CommonComponent.table(allData);

        // Agregar tabla al bigBox
        boxPanel.setLayout(new BorderLayout());
        boxPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        components.add(boxPanel);

        return components;
    }
}
