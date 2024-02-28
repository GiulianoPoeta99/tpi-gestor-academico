package student;

import career.Career;
import career.CareerSearch;
import common.Model;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.components.*;
import common.components.Button;

public class StudentViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Student.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JButton createButton = Button.success("Crear estudiante", () -> StudentController.getInstance().create(false, null));
        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.add(createButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(allData);
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static JPanel form(Student model, boolean update) {
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

        JLabel firstNameLabel = Text.label("Nombre:");
        divForm.add(firstNameLabel, constraints);

        constraints.gridy++;
        JTextField firstNameField = Input.createInput(model != null ? model.getFirstName() : "");
        divForm.add(firstNameField, constraints);

        constraints.gridy++;
        JLabel lastNameLabel = Text.label("Apellido:");
        divForm.add(lastNameLabel, constraints);

        constraints.gridy++;
        JTextField lastNameField = Input.createInput(model != null ? model.getLastName() : "");
        divForm.add(lastNameField, constraints);

        constraints.gridy++;
        JLabel birthDateLabel = Text.label("Fecha de nacimiento (yyyy-mm-dd):");
        divForm.add(birthDateLabel, constraints);

        constraints.gridy++;
        JTextField birthDateField = Input.createDateInput(model != null ? model.getBirthDate() : LocalDate.now());
        divForm.add(birthDateField, constraints);

        constraints.gridy++;
        JLabel careerIDLabel = Text.label("Carrera:");
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
            String newFirstName = firstNameField.getText();
            String newLastName = lastNameField.getText();
            String newBirthDate = birthDateField.getText();
            Integer selectedCareerId = (Integer) ((JComboBox) ((JPanel) careerIDField).getComponent(0)).getClientProperty("selectedIndex");

            if (!newFirstName.isEmpty() && !newFirstName.equals(model.getFirstName())) {
                model.setFirstName(newFirstName);
            }

            if (!newLastName.isEmpty() && !newLastName.equals(model.getLastName())) {
                model.setLastName(newLastName);
            }

            if (!newBirthDate.isEmpty() && !newBirthDate.equals(model.getBirthDate())) {
                model.setBirthDate(LocalDate.parse(newBirthDate));
            }

            if (selectedCareerId > 0 && selectedCareerId != model.getIdCareer()) {
                model.setIdCareer(selectedCareerId);
            }

            StudentController.getInstance().create(true, model);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                String newFirstName = firstNameField.getText();
                String newLastName = lastNameField.getText();
                String newBirthDate = birthDateField.getText();
                Integer selectedCareerId = (Integer) ((JComboBox) ((JPanel) careerIDField).getComponent(0)).getClientProperty("selectedIndex");

                if (!newFirstName.isEmpty() && !newFirstName.equals(model.getFirstName())) {
                    model.setFirstName(newFirstName);
                }

                if (!newLastName.isEmpty() && !newLastName.equals(model.getLastName())) {
                    model.setLastName(newLastName);
                }

                if (!newBirthDate.isEmpty() && !newBirthDate.equals(model.getBirthDate())) {
                    model.setBirthDate(LocalDate.parse(newBirthDate));
                }

                if (selectedCareerId > 0 && selectedCareerId != model.getIdCareer()) {
                    model.setIdCareer(selectedCareerId);
                }

                StudentController.getInstance().update(true, model.getId());
            });
        }
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> StudentController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    public static List<JComponent> create(Student model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + Student.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model,false);
        components.add(divBox);

        return components;
    }

    public static List<JComponent> update(Student model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + Student.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model,true);
        components.add(divBox);

        return components;
    }

    public static List<JComponent> view(Student model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Ver %s ID: %d", Student.TRANSLATE_NAME, model.getId()));

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

        JButton continueButton = Button.secondary("Continuar", () -> StudentController.getInstance().index());
        divButton.add(continueButton);

        JButton createButton = Button.success("Crear", () -> StudentController.getInstance().create(false, null));
        divButton.add(createButton);

        JButton updateButton = Button.primary("Actualizar", () -> StudentController.getInstance().update(false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = Button.danger("Eliminar", () -> StudentController.getInstance().delete(false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> delete(boolean isDelete, int id) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Eliminar %s ID: %d", Student.TRANSLATE_NAME, id));

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

            JLabel viewModel = Text.h3(Student.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = Button.danger("Eliminar", () -> StudentController.getInstance().delete(true, id));
            divButton.add(deleteButton);

            JButton goBackButton = Button.primary("Volver", () -> StudentController.getInstance().view(id));
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

            JButton continueButton = Button.secondary("Continuar", () -> StudentController.getInstance().index());
            divButton.add(continueButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        }

        components.add(divBox);

        return components;
    }
}