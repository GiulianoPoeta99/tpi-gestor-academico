package subject;


import career.CareerSearch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import common.components.*;
import common.components.Button;

public class SubjectViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Subject.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JButton createButton = Button.success("Crear Materia", () -> SubjectController.getInstance().create(false, null, 0));
        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.add(createButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(SubjectSearch.getCustomColumns(), SubjectSearch.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static JPanel form(Subject model, boolean update) {
        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel div = new JPanel(new FlowLayout(FlowLayout.LEFT));
        div.setBackground(Common.BACKGROUND_COLOR);

        JPanel divForm = new JPanel(new GridBagLayout());
        divForm.setBackground(Common.BACKGROUND_COLOR);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = Text.label("Nombre:");
        divForm.add(nameLabel, constraints);

        constraints.gridy++;
        JTextField nameField = Input.createInput(model != null ? model.getName() : "");
        divForm.add(nameField, constraints);

        constraints.gridy++;
        JLabel isOptionalLabel = Text.label("Opcional:");
        divForm.add(isOptionalLabel, constraints);

        constraints.gridy++;
        JPanel isOptionalField = Input.createSelect2InputBoolStr();
        divForm.add(isOptionalField, constraints);

        constraints.gridy++;
        JLabel fourMonthsLabel = Text.label("Cuatrimestre:");
        divForm.add(fourMonthsLabel, constraints);

        constraints.gridy++;
        JTextField fourMonthsField = Input.createInput(model != null ? String.valueOf(model.getFourMonths()) : "");
        divForm.add(fourMonthsField, constraints);

        constraints.gridy++;
        JLabel careerIDLabel = Text.label("Plan de estudios:");
        divForm.add(careerIDLabel, constraints);

        constraints.gridy++;
        JPanel careerIDField = Input.createSelect2InputStrInt(CareerSearch.getIDNameForSelect2());
        divForm.add(careerIDField, constraints);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            String newName = nameField.getText();
            boolean selectedIsOptional = (boolean) ((JComboBox<?>) isOptionalField.getComponent(0)).getClientProperty("selectedIndex");
            String newFourMonths = fourMonthsField.getText();
            Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (!newName.isEmpty()) {
                assert model != null;
                if (!newName.equals(model.getName())) {
                    model.setName(newName);
                }
            }

            assert model != null;
            if (selectedIsOptional != model.getIsOptional()) {
                model.setIsOptional(selectedIsOptional);
            }

            if (!newFourMonths.isEmpty()) {
                model.setFourMonths(Integer.parseInt(newFourMonths));
            }

            SubjectController.getInstance().create(true, model, selectedCareerId);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                String newName = nameField.getText();
                boolean selectedIsOptional = (boolean) ((JComboBox<?>) isOptionalField.getComponent(0)).getClientProperty("selectedIndex");
                String newFourMonths = fourMonthsField.getText();

                if (!newName.isEmpty()) {
                    assert model != null;
                    if (!newName.equals(model.getName())) {
                        model.setName(newName);
                    }
                }

                assert model != null;
                if (selectedIsOptional != model.getIsOptional()) {
                    model.setIsOptional(selectedIsOptional);
                }

                if (!newFourMonths.isEmpty()) {
                    model.setName(newName);
                }

                SubjectController.getInstance().update(true, model.getId());
            });
        }
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> SubjectController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    public static List<JComponent> create(Subject model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + Subject.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model,false);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> update(Subject model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + Subject.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model,true);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> view(Subject model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Ver %s ID: %d", Subject.TRANSLATE_NAME, model.getId()));

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel div = new JPanel(new FlowLayout(FlowLayout.LEFT));
        div.setBackground(Common.BACKGROUND_COLOR);

        JLabel viewModel = Text.h3(model.toString());

        div.add(viewModel);

        divBox.add(div, BorderLayout.CENTER);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton continueButton = Button.secondary("Continuar", () -> SubjectController.getInstance().index());
        divButton.add(continueButton);

        JButton createButton = Button.success("Crear", () -> SubjectController.getInstance().create(false, null, 0));
        divButton.add(createButton);

        JButton updateButton = Button.primary("Actualizar", () -> SubjectController.getInstance().update(false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = Button.danger("Eliminar", () -> SubjectController.getInstance().delete(false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> delete(boolean isDelete, int id) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Eliminar %s ID: %d", Subject.TRANSLATE_NAME, id));

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        if (!isDelete) {
            JPanel divText = new JPanel(new FlowLayout(FlowLayout.LEFT));
            divText.setBackground(Common.BACKGROUND_COLOR);

            JLabel warning = Text.p("¿Esta seguro de eliminar el registro? No habra forma de recuperarlo.");

            divText.add(warning);

            divBox.add(divText, BorderLayout.NORTH);

            JPanel div = new JPanel(new FlowLayout(FlowLayout.LEFT));
            div.setBackground(Common.BACKGROUND_COLOR);

            JLabel viewModel = Text.h3(Subject.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = Button.danger("Eliminar", () -> SubjectController.getInstance().delete(true, id));
            divButton.add(deleteButton);

            JButton goBackButton = Button.primary("Volver", () -> SubjectController.getInstance().view(id));
            divButton.add(goBackButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        } else {
            JPanel divText = new JPanel(new FlowLayout(FlowLayout.LEFT));
            divText.setBackground(Common.BACKGROUND_COLOR);

            JLabel warning = Text.p("Se elminino el registro satisfactoriamente.");

            divText.add(warning);

            divBox.add((divText));

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton continueButton = Button.secondary("Continuar", () -> SubjectController.getInstance().index());
            divButton.add(continueButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        }

        components.add(divBox);

        return components;
    }
}