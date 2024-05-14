package main.academichistory;

import main.career.Career;
import main.career.CareerSearch;
import main.common.components.*;
import main.common.components.Button;
import main.student.Student;
import main.student.StudentSearch;
import main.subject.Subject;
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
        JButton searchStudentButton = main.common.components.Button.info("Ver historia de alumno", () -> AcademicHistoryController.getInstance().searchStudent(false,true));
        divButton.add(searchStudentButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(AcademicHistorySearch.getCustomColumns(), AcademicHistorySearch.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static void performSaveOrUpdate(AcademicHistory model, JPanel studentIDField,  JPanel subjectIDField, JPanel stateField, JTextField partial1Field, JTextField partial2Field, JPanel isPromotedField, JTextField finalExamField, JTextField gradeField) {
        int selectedStudentId = (int) ((JComboBox<?>) studentIDField.getComponent(0)).getClientProperty("selectedIndex");
        int selectedSubjectID= (int) ((JComboBox<?>) subjectIDField.getComponent(0)).getClientProperty("selectedIndex");
        String selectedState = (String) ((JComboBox<?>) stateField.getComponent(0)).getClientProperty("selectedIndex");
        String newPartial1 = partial1Field.getText();
        String newPartial2 = partial2Field.getText();
        boolean selectedIsPromoted = (boolean) ((JComboBox<?>) isPromotedField.getComponent(0)).getClientProperty("selectedIndex");
        String newFinalExam = finalExamField.getText();
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

        if (!newPartial1.isEmpty()) {
            model.setPartial1(Integer.parseInt(newPartial1));
        }

        if (!newPartial2.isEmpty()) {
            model.setPartial2(Integer.parseInt(newPartial2));
        }

        assert model != null;
        if (selectedIsPromoted != model.getIsPromoted()) {
            model.setIsPromoted(selectedIsPromoted);
        }

        if (!newFinalExam.isEmpty()) {
            model.setFinalExam(Integer.parseInt(newFinalExam));
        }

        if (!newGrade.isEmpty()) {
            model.setGrade(Integer.parseInt(newGrade));
        }

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
        JLabel partial1Label = Text.label("Parcial 1:");
        divForm.add(partial1Label, conditions);
        conditions.gridy++;
        JTextField partial1Field = Input.createInput(model != null ? String.valueOf(model.getPartial1()) : "");
        divForm.add(partial1Field, conditions);

        conditions.gridy++;
        JLabel partial2Label = Text.label("Parcial 2:");
        divForm.add(partial2Label, conditions);
        conditions.gridy++;
        JTextField partial2Field = Input.createInput(model != null ? String.valueOf(model.getPartial2()) : "");
        divForm.add(partial2Field, conditions);

        conditions.gridy++;
        JLabel isPromotedLabel = Text.label("Promoción:");
        divForm.add(isPromotedLabel, conditions);
        conditions.gridy++;
        JPanel isPromotedField = Input.createSelect2InputBoolStr();
        divForm.add(isPromotedField, conditions);

        conditions.gridy++;
        JLabel finalExamLabel = Text.label("Parcial 2:");
        divForm.add(finalExamLabel, conditions);
        conditions.gridy++;
        JTextField finalExamField = Input.createInput(model != null ? String.valueOf(model.getFinalExam()) : "");
        divForm.add(finalExamField, conditions);

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
            performSaveOrUpdate(model, studentIDField, subjectIDField, stateField, partial1Field, partial2Field, isPromotedField, finalExamField, gradeField);
            AcademicHistoryController.getInstance().create(true, model);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                performSaveOrUpdate(model, studentIDField, subjectIDField, stateField, partial1Field, partial2Field, isPromotedField, finalExamField, gradeField);
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

        JLabel academicHistoryIDLabel = Text.label("Alumno/Materia:");
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
            Integer selectedAcademicHistoryId = (Integer) ((JComboBox<?>) academicHistoryIDField.getComponent(0)).getClientProperty("selectedIndex");

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

    public static List<JComponent> searchStudent(boolean isVerifyGraduate, boolean isVerifyStudent) {
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
                if (isVerifyGraduate) {
                    AcademicHistoryController.getInstance().verifyGraduate(selectedStudentId);
                } else {
                    if (isVerifyStudent) {
                        AcademicHistoryController.getInstance().viewPerStudent(selectedStudentId);
                    } else {
                        AcademicHistoryController.getInstance().enrollSubject(false, null, selectedStudentId);
                    }
                }
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> AcademicHistoryController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> enrollSubject(AcademicHistory model) {
        Student student = (Student) StudentSearch.getById(model.getIdStudent());
        Career career = (Career) CareerSearch.getById(student.getIdCareer());

        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + AcademicHistory.TRANSLATE_NAME);

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

        JLabel subjectIDLabel = Text.label("Materia:");
        divForm.add(subjectIDLabel, conditions);
        conditions.gridy++;
        JPanel subjectIDField = Input.createSelect2InputStrInt(SubjectSearch.getAllSubjectsForCareerForSelect2(career.getId()));
        divForm.add(subjectIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            int selectedSubjectID= (int) ((JComboBox<?>) subjectIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (selectedSubjectID > 0 && selectedSubjectID != model.getIdSubject()) {
                model.setIdSubject(selectedSubjectID);
            }

            AcademicHistoryController.getInstance().enrollSubject(true, model, model.getIdStudent());
        });

        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", AcademicHistoryController.getInstance()::index);
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> historyPerStudent(int idStudent) {
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
        JButton backButton = main.common.components.Button.danger("Volver", AcademicHistoryController.getInstance()::index);
        divButton.add(backButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(AcademicHistorySearch.getCustomColumns(), AcademicHistorySearch.getCustomDataForStudent(idStudent));
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> verifyGraduate(boolean isGraduated, List<Subject> subjectsNotApproved) {
        List<JComponent> components = new ArrayList<>();
        JLabel title = Text.h1("Verificar graduado");

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton backButton = main.common.components.Button.danger("Volver", AcademicHistoryController.getInstance()::index);
        divButton.add(backButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JPanel subjectsPanel = UIComponent.bigBox();
        subjectsPanel.setLayout(new BoxLayout(subjectsPanel, BoxLayout.Y_AXIS));

        if (!isGraduated) {
            JLabel graduatedLabel = Text.h2("El estudiante no está recibido.");
            subjectsPanel.add(graduatedLabel);

            JLabel listSubjectLabel = Text.h3("Materias faltantes:");
            subjectsPanel.add(listSubjectLabel);
            for (Subject subject : subjectsNotApproved) {
                JLabel subjectLabel = Text.p(String.format("* %s (cuatrimestre: %d)", subject.getName(), subject.getFourMonths()));
                subjectsPanel.add(subjectLabel);
            }
        } else {
            JLabel graduatedLabel = Text.h2("El estudiante está recibido.");
            subjectsPanel.add(graduatedLabel);
        }

        // Crear JScrollPane y envolver subjectsPanel
        JScrollPane scrollPane = UIComponent.scrollPane(subjectsPanel);

        divBox.add(scrollPane, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

}
