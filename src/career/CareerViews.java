package career;

import common.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.components.*;
import common.components.Button;

public class CareerViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {
        List<JComponent> components = new ArrayList<>();

        // Título tipo H1
        JLabel title = Text.h1(Career.TRANSLATE_NAME);

        // Crear un Box para centrar el título
        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue()); // Agregar espacio a la izquierda
        titleBox.add(title); // Agregar el título
        titleBox.add(Box.createHorizontalGlue()); // Agregar espacio a la derecha

        // Box debajo del título
        JPanel boxPanel = UIComponent.bigBox();
        boxPanel.setLayout(new BorderLayout()); // Usar BorderLayout

        // Crear botón y agregarlo arriba a la izquierda
        JButton createButton = Button.success("Crear carrera", () -> CareerController.getInstance().create(false, null));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Usar FlowLayout para el botón
        buttonPanel.setBackground(Common.BACKGROUND_COLOR);
        buttonPanel.add(createButton);
        boxPanel.add(buttonPanel, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(allData);
        boxPanel.add(table, BorderLayout.CENTER);

        // Agregar el Box con el título al comienzo de la lista de componentes
        components.add(0, titleBox);

        // Agregar el panel debajo del título
        components.add(boxPanel);

        return components;
    }

    public static List<JComponent> create(Career model) {
        List<JComponent> components = new ArrayList<>();

        // Título tipo H1
        JLabel title = Text.h1("Crear " + Career.TRANSLATE_NAME);

        // Crear un Box para centrar el título
        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue()); // Agregar espacio a la izquierda
        titleBox.add(title); // Agregar el título
        titleBox.add(Box.createHorizontalGlue()); // Agregar espacio a la derecha

        // Agregar el Box con el título al comienzo de la lista de componentes
        components.add(titleBox);

        // Box debajo del título
        JPanel boxPanel = UIComponent.bigBox();
        boxPanel.setLayout(new BorderLayout()); // Usar BorderLayout

        // Crear formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Common.BACKGROUND_COLOR);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Nombre de la carrera (ejemplo de uso del input creado)
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = Input.createInput(model != null ? model.getName() : ""); // Utilizar el nuevo componente de entrada
        formPanel.add(nameLabel, constraints);
        constraints.gridx = 1;
        formPanel.add(nameField, constraints);

        boxPanel.add(formPanel, BorderLayout.CENTER);

        // Botones
        JPanel buttonJPanel = new JPanel(new GridBagLayout());
        buttonJPanel.setBackground(Common.BACKGROUND_COLOR);
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;

        constraints.gridx = 0;
        constraints.gridy = 0;
        buttonJPanel.add(Box.createVerticalStrut(10), constraints);

        JButton saveButton = Button.success("Guardar", () -> {
            String newName = nameField.getText();
            if (!newName.isEmpty() && !newName.equals(model.getName())) {
                model.setName(newName);
            }
            CareerController.getInstance().create(true, model);
        });

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

        // Agregar el panel debajo del título
        components.add(boxPanel);

        return components;
    }
}
