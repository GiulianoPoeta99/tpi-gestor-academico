package main.student;

import main.career.Career;
import main.career.CareerService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.common.components.*;
import main.common.components.Button;

public class StudentViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Student.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton createButton = Button.success("Crear estudiante", () -> StudentController.getInstance().create(false, false, null));
        divButton.add(createButton);
        JButton searchButton = Button.warning("Ver estudiante", () -> StudentController.getInstance().search(false));
        divButton.add(searchButton);
        JButton searchCareerButton = Button.info("Ver estudiante por carrera", StudentController.getInstance()::searchCareer);
        divButton.add(searchCareerButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(StudentSearch.getCustomColumns(), StudentSearch.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static void performSaveOrUpdate(boolean isRegister, Student model, JTextField firstNameField, JTextField lastNameField, JTextField birthDateField, JPanel careerIDField) {
        String newFirstName = firstNameField.getText();
        String newLastName = lastNameField.getText();
        String newBirthDate = birthDateField.getText();
        Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0)).getClientProperty("selectedIndex");

        if (!newFirstName.isEmpty() && !newFirstName.equals(model.getFirstName())) {
            model.setFirstName(newFirstName);
        }

        if (!newLastName.isEmpty() && !newLastName.equals(model.getLastName())) {
            model.setLastName(newLastName);
        }

        if (!newBirthDate.isEmpty()) {
            model.setBirthDate(LocalDate.parse(newBirthDate));
        }
        if (!isRegister) {
            if (selectedCareerId > 0 && selectedCareerId != model.getIdCareer()) {
                model.setIdCareer(selectedCareerId);
            }
        }
    }

    private static JPanel form(Student model, boolean update, boolean isRegister) {
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

        JLabel careerIDLabel = Text.label("Carrera:");

        JPanel careerIDField = Input.createSelect2InputStrInt(CareerService.getIDNameForSelect2());

        if (!isRegister) {
            constraints.gridy++;
            divForm.add(careerIDLabel, constraints);
            constraints.gridy++;
            divForm.add(careerIDField, constraints);
        }

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            performSaveOrUpdate(isRegister, model, firstNameField, lastNameField, birthDateField, careerIDField);
            StudentController.getInstance().create(isRegister, true, model);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                performSaveOrUpdate(isRegister, model, firstNameField, lastNameField, birthDateField, careerIDField);
                assert model != null;
                StudentController.getInstance().update(isRegister, true, model.getId());
            });
        }
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> StudentController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    public static List<JComponent> create(boolean isRegister, Student model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + Student.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model,false, isRegister);
        components.add(divBox);

        return components;
    }

    public static List<JComponent> update(boolean isRegister, Student model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + Student.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model,true, isRegister);
        components.add(divBox);

        return components;
    }

    public static List<JComponent> view(boolean isRegister, Student model) {
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

        JButton createButton = Button.success("Crear", () -> StudentController.getInstance().create(isRegister, false, null));
        divButton.add(createButton);

        JButton updateButton = Button.primary("Actualizar", () -> StudentController.getInstance().update(isRegister, false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = Button.danger("Eliminar", () -> StudentController.getInstance().delete(isRegister, false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> delete(boolean isRegister, boolean isDelete, int id) {
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

            JLabel viewModel = Text.h3(StudentSearch.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = Button.danger("Eliminar", () -> StudentController.getInstance().delete(isRegister, true, id));
            divButton.add(deleteButton);

            JButton goBackButton = Button.primary("Volver", () -> StudentController.getInstance().view(isRegister, id));
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

    public static List<JComponent> search(boolean isRegister) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Buscar %s", Student.TRANSLATE_NAME));

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

        JLabel studentIDLabel = Text.label("Estudiante:");
        divForm.add(studentIDLabel, conditions);

        conditions.gridy++;
        JPanel studentIDField = Input.createSelect2InputStrInt(StudentSearch.getIDNameForSelect2());
        divForm.add(studentIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.info("Buscar", () -> {
            Integer selectedStudentId = (Integer) ((JComboBox<?>) studentIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (selectedStudentId > 0) {
                if (isRegister) {
                    StudentController.getInstance().enrollCareer(selectedStudentId);
                } else {
                    StudentController.getInstance().view(false, selectedStudentId);
                }
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> StudentController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> enrollCareer(Student model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Inscribir %s: %s - %s %s  a %s", Student.TRANSLATE_NAME, model.getDossierNumber(), model.getLastName(), model.getLastName(), Career.TRANSLATE_NAME));

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

        JLabel careerIDLabel = Text.label("Carrera:");
        divForm.add(careerIDLabel, conditions);

        conditions.gridy++;
        JPanel careerIDField = Input.createSelect2InputStrInt(CareerService.getIDNameForSelect2());
        divForm.add(careerIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (selectedCareerId > 0 && selectedCareerId != model.getIdCareer()) {
                model.setIdCareer(selectedCareerId);
            }
            StudentController.getInstance().update(false, true, model.getId());
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> StudentController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> searchCareer() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Buscar %s", Career.TRANSLATE_NAME));

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

        JLabel careerIDLabel = Text.label("Carrera:");
        divForm.add(careerIDLabel, conditions);

        conditions.gridy++;
        JPanel careerIDField = Input.createSelect2InputStrInt(CareerService.getIDNameForSelect2());
        divForm.add(careerIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.info("Buscar", () -> {
            Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (selectedCareerId > 0) {
                StudentController.getInstance().studentsForCareer(selectedCareerId);
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", StudentController.getInstance()::index);
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> studentsForCareer(int idCareer) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Student.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton createButton = Button.success("Crear estudiante", () -> StudentController.getInstance().create(false, false, null));
        divButton.add(createButton);
        JButton searchButton = Button.warning("Ver estudiante", () -> StudentController.getInstance().search(false));
        divButton.add(searchButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(StudentSearch.getCustomColumns(), StudentSearch.getCustomDataForCareer(idCareer));
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }
}