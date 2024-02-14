package career;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.Model;
import common.components.CommonComponent;
import common.components.ButtonComponent;
import common.components.TextComponent;
import common.components.UIComponent;

public class CareerViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {

        List<JComponent> components = new ArrayList<>();

        // Título tipo H1
        JLabel title = TextComponent.h1(Career.TRANSLATE_NAME);
        components.add(title);

        // Box debajo del título
        JPanel boxPanel = UIComponent.bigBox();
        boxPanel.setLayout(new BorderLayout()); // Usar BorderLayout

        // Crear botón y agregarlo arriba a la izquierda
        JButton createButton = ButtonComponent.buttonSuccess("Crear carrera", CareerController.getInstance()::create);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Usar FlowLayout para el botón
        buttonPanel.setBackground(CommonComponent.BACKGROUND_COLOR);
        buttonPanel.add(createButton);
        boxPanel.add(buttonPanel, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(allData);
        boxPanel.add(table, BorderLayout.CENTER);

        components.add(boxPanel);

        return components;
    }
}