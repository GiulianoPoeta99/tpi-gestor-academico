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

        JLabel title = Text.h1(Career.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JButton createButton = Button.success("Crear carrera", () -> CareerController.getInstance().create(false, null));
        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.add(createButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(allData);
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> create(Career model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + Career.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel div = new JPanel(new FlowLayout(FlowLayout.LEFT));
        div.setBackground(Common.BACKGROUND_COLOR);

        JPanel divForm = new JPanel(new GridBagLayout());
        divForm.setBackground(Common.BACKGROUND_COLOR);

        GridBagConstraints conditions = new GridBagConstraints();
        conditions.gridx = 0;
        conditions.gridy = 0;
        conditions.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setForeground(Common.TEXT_COLOR);
        divForm.add(nameLabel, conditions);

        conditions.gridy++;
        JTextField nameField = Input.createInput(model != null ? model.getName() : "");
        divForm.add(nameField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        // Botones
        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER)); // Cambiar a FlowLayout con alineación centrada

        JButton saveButton = Button.success("Guardar", () -> {
            String newName = nameField.getText();
            if (!newName.isEmpty() && !newName.equals(model.getName())) {
                model.setName(newName);
            }
            CareerController.getInstance().create(true, model);
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> CareerController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

}
