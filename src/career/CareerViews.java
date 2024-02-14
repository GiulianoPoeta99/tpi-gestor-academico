package career;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.Model;
import common.components.Common;
import common.components.Button;
import common.components.Text;
import common.components.UIComponent;

public class CareerViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {

        List<JComponent> components = new ArrayList<>();

        // Título tipo H1
        JLabel title = Text.h1(Career.TRANSLATE_NAME);
        components.add(title);

        // Box debajo del título
        JPanel boxPanel = UIComponent.bigBox();
        boxPanel.setLayout(new BorderLayout()); // Usar BorderLayout

        // Crear botón y agregarlo arriba a la izquierda
        JButton createButton = Button.success("Crear carrera", () -> CareerController.getInstance().create(false));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Usar FlowLayout para el botón
        buttonPanel.setBackground(Common.BACKGROUND_COLOR);
        buttonPanel.add(createButton);
        boxPanel.add(buttonPanel, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(allData);
        boxPanel.add(table, BorderLayout.CENTER);

        components.add(boxPanel);

        return components;
    }

    public static List<JComponent> create() {
        List<JComponent> components = new ArrayList<>();

        // Título tipo H1
        JLabel title = Text.h1("Crear " + Career.TRANSLATE_NAME);
        components.add(title);

        // Box debajo del título
        JPanel boxPanel = UIComponent.bigBox();
        boxPanel.setLayout(new BorderLayout()); // Usar BorderLayout

        // armar formulario

        //botones
        JPanel buttonJPanel = new JPanel(new GridBagLayout());
        buttonJPanel.setBackground(Common.BACKGROUND_COLOR);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;

        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonJPanel.add(Box.createVerticalStrut(10), constraints);

        JButton saveButton = Button.success("Guardar", () -> CareerController.getInstance().create(false));
        constraints.gridx = 0;
        constraints.gridy = 1;
        buttonJPanel.add(saveButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        buttonJPanel.add(Box.createHorizontalStrut(10), constraints);

        JButton backButton = Button.danger("Volver", () -> CareerController.getInstance().index());
        constraints.gridx = 2;
        constraints.gridy = 1;
        buttonJPanel.add(backButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        buttonJPanel.add(Box.createVerticalGlue(), constraints);

        boxPanel.add(buttonJPanel, BorderLayout.SOUTH);

        components.add(boxPanel);

        return components;
    }
}