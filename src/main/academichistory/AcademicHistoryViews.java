package main.academichistory;

import main.common.components.*;
import main.common.components.Button;
import main.student.StudentSearch;
import main.subject.SubjectSearch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AcademicHistoryViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(AcademicHistory.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton createButton = main.common.components.Button.success("Crear historia", () -> AcademicHistoryController.getInstance().create(false, null));
        divButton.add(createButton);
        JButton searchButton = main.common.components.Button.warning("Ver historia", () -> AcademicHistoryController.getInstance().search());
        divButton.add(searchButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(AcademicHistorySearch.getCustomColumns(), AcademicHistorySearch.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static void performSaveOrUpdate(AcademicHistory model, JPanel studentIDField,  JPanel subjectIDField, JPanel stateField, JTextField gradeField) {
        int selectedStudentId = (int) ((JComboBox<?>) studentIDField.getComponent(0)).getClientProperty("selectedIndex");
        int selectedSubjectID= (int) ((JComboBox<?>) subjectIDField.getComponent(0)).getClientProperty("selectedIndex");
        String selectedState = (String) ((JComboBox<?>) stateField.getComponent(0)).getClientProperty("selectedIndex");
        String newGrade = gradeField.getText();

        if (selectedStudentId > 0 && selectedStudentId != model.getIdStudent()) {
            model.setIdStudent(selectedStudentId);
        }

        if (selectedSubjectID > 0 && selectedSubjectID != model.getIdSubject()) {
            model.setIdSubject(selectedSubjectID);
        }

        if (selectedState != null && !selectedState.isEmpty() && !selectedState.equals(model.getState())) {
            model.setState(selectedState);
        }

        model.setGrade(Integer.parseInt(newGrade));
    }

    private static JPanel form(AcademicHistory model, boolean update) {
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

        conditions.gridy++;
        JLabel subjectIDLabel = Text.label("Materia:");
        divForm.add(subjectIDLabel, conditions);
        conditions.gridy++;
        JPanel subjectIDField = Input.createSelect2InputStrInt(SubjectSearch.getIDNameForSelect2());
        divForm.add(subjectIDField, conditions);

        conditions.gridy++;
        JLabel stateLabel = Text.label("Estado:");
        divForm.add(stateLabel, conditions);
        conditions.gridy++;
        JPanel stateField = Input.createSelect2InputStrStr(AcademicHistorySearch.getStateForSelect2());
        divForm.add(stateField, conditions);

        conditions.gridy++;
        JLabel gradeLabel = Text.label("Nota:");
        divForm.add(gradeLabel, conditions);

        conditions.gridy++;
        JTextField gradeField = Input.createInput(model != null ? String.valueOf(model.getGrade()) : "");
        divForm.add(gradeField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            performSaveOrUpdate(model, studentIDField, subjectIDField, stateField, gradeField);
            AcademicHistoryController.getInstance().create(true, model);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                performSaveOrUpdate(model, studentIDField, subjectIDField, stateField, gradeField);
                assert model != null;
                AcademicHistoryController.getInstance().update(true, model.getId());
            });
        }

        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> AcademicHistoryController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    public static List<JComponent> create(AcademicHistory model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + AcademicHistory.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, false);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> update(AcademicHistory model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + AcademicHistory.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, true);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> view(AcademicHistory model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Ver %s ID: %d", AcademicHistory.TRANSLATE_NAME, model.getId()));

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

        JButton continueButton = Button.secondary("Continuar", () -> AcademicHistoryController.getInstance().index());
        divButton.add(continueButton);

        JButton createButton = Button.success("Crear",
                () -> AcademicHistoryController.getInstance().create(false, null));
        divButton.add(createButton);

        JButton updateButton = Button.primary("Actualizar",
                () -> AcademicHistoryController.getInstance().update(false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = Button.danger("Eliminar",
                () -> AcademicHistoryController.getInstance().delete(false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> delete(boolean isDelete, int id) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Eliminar %s ID: %d", AcademicHistory.TRANSLATE_NAME, id));

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

            JLabel viewModel = Text.h3(AcademicHistorySearch.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = Button.danger("Eliminar",
                    () -> AcademicHistoryController.getInstance().delete(true, id));
            divButton.add(deleteButton);

            JButton goBackButton = Button.primary("Volver", () -> AcademicHistoryController.getInstance().view(id));
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

            JButton continueButton = Button.secondary("Continuar",
                    () -> AcademicHistoryController.getInstance().index());
            divButton.add(continueButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        }

        components.add(divBox);

        return components;
    }

    public static List<JComponent> search() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Buscar %s", AcademicHistory.TRANSLATE_NAME));

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

        JLabel academicHistoryIDLabel = Text.label("Carrera:");
        divForm.add(academicHistoryIDLabel, conditions);

        conditions.gridy++;
        JPanel academicHistoryIDField = Input.createSelect2InputStrInt(AcademicHistorySearch.getIDNameForSelect2());
        divForm.add(academicHistoryIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.info("Buscar", () -> {
            Integer selectedAcademicHistoryId = (Integer) ((JComboBox<?>) academicHistoryIDField.getComponent(0))
                    .getClientProperty("selectedIndex");

            if (selectedAcademicHistoryId > 0) {
                AcademicHistoryController.getInstance().view(selectedAcademicHistoryId);
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> AcademicHistoryController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }
}
