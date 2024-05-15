package main.correlative;

import main.career.Career;
import main.career.CareerService;
import main.common.components.Button;
import main.common.components.Common;
import main.common.components.Input;
import main.common.components.Text;
import main.common.components.UIComponent;
import main.subject.Subject;
import main.subject.SubjectService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CorrelativeViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Correlative.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton createButton = main.common.components.Button.success("Crear correlativa", () -> CorrelativeController.getInstance().searchCreate());
        divButton.add(createButton);
        JButton searchButton = main.common.components.Button.warning("Ver correlativa", () -> CorrelativeController.getInstance().search());
        divButton.add(searchButton);
        JButton searchSubjectButton = main.common.components.Button.info("Ver correlativa de materia", () -> CorrelativeController.getInstance().searchSubject());
        divButton.add(searchSubjectButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(CorrelativeService.getCustomColumns(), CorrelativeService.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static void performSaveOrUpdate(Correlative model, JPanel subjectIDField, JPanel subjectCorrelativeIDField) {
        Integer selectedSubjectId = (Integer) ((JComboBox<?>) subjectIDField.getComponent(0)).getClientProperty("selectedIndex");
        Integer selectedCorrelativeSubjectId = (Integer) ((JComboBox<?>) subjectCorrelativeIDField.getComponent(0)).getClientProperty("selectedIndex");

        if (selectedSubjectId > 0) {
            model.setIdSubject(selectedSubjectId);
        }

        if (selectedCorrelativeSubjectId > 0) {
            model.setIdSubjectCorrelative(selectedCorrelativeSubjectId);
        }
    }

    private static JPanel form(Correlative model, int idCareer, boolean update) {
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
        JPanel subjectIDField = Input.createSelect2InputStrInt(SubjectService.getAllSubjectsForCareerForSelect2(idCareer));
        divForm.add(subjectIDField, conditions);

        conditions.gridy++;
        JLabel subjectCorrelativeIDLabel = Text.label("Materia Correlativa:");
        divForm.add(subjectCorrelativeIDLabel, conditions);
        conditions.gridy++;
        JPanel subjectCorrelativeIDField = Input.createSelect2InputStrInt(SubjectService.getAllSubjectsForCareerForSelect2(idCareer));
        divForm.add(subjectCorrelativeIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = main.common.components.Button.success("Guardar", () -> {
            performSaveOrUpdate(model, subjectIDField, subjectCorrelativeIDField);
            CorrelativeController.getInstance().create(true, model, idCareer);
        });
        if (update) {
            saveButton = main.common.components.Button.primary("Actualizar", () -> {
                performSaveOrUpdate(model, subjectIDField, subjectCorrelativeIDField);
                assert model != null;
                CorrelativeController.getInstance().update(true, model.getId());
            });
        }

        divButton.add(saveButton);

        JButton backButton = main.common.components.Button.danger("Volver",
                () -> CorrelativeController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    public static List<JComponent> create(Correlative model, int idCareer) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + Correlative.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, idCareer, false);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> update(Correlative model, int idCareer) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + Correlative.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, idCareer, true);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> view(Correlative model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Ver %s ID: %d", Correlative.TRANSLATE_NAME, model.getId()));

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

        JButton continueButton = main.common.components.Button.secondary("Continuar", () -> CorrelativeController.getInstance().index());
        divButton.add(continueButton);

        JButton createButton = main.common.components.Button.success("Crear", () -> CorrelativeController.getInstance().searchCreate());
        divButton.add(createButton);

        JButton updateButton = main.common.components.Button.primary("Actualizar", () -> CorrelativeController.getInstance().update(false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = main.common.components.Button.danger("Eliminar",
                () -> CorrelativeController.getInstance().delete(false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> delete(boolean isDelete, int id) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Eliminar %s ID: %d", Correlative.TRANSLATE_NAME, id));

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

            JLabel viewModel = Text.h3(CorrelativeService.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = main.common.components.Button.danger("Eliminar",
                    () -> CorrelativeController.getInstance().delete(true, id));
            divButton.add(deleteButton);

            JButton goBackButton = main.common.components.Button.primary("Volver",
                    () -> CorrelativeController.getInstance().view(id));
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

            JButton continueButton = main.common.components.Button.secondary("Continuar",
                    () -> CorrelativeController.getInstance().index());
            divButton.add(continueButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        }

        components.add(divBox);

        return components;
    }

    public static List<JComponent> search() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Buscar %s", Correlative.TRANSLATE_NAME));

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

        JLabel correlativeIDLabel = Text.label("Carrera:");
        divForm.add(correlativeIDLabel, conditions);

        conditions.gridy++;
        JPanel correlativeIDField = Input.createSelect2InputStrInt(CorrelativeService.getIDNameForSelect2());
        divForm.add(correlativeIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = main.common.components.Button.info("Buscar", () -> {
            Integer selectedCorrelativeId = (Integer) ((JComboBox<?>) correlativeIDField.getComponent(0))
                    .getClientProperty("selectedIndex");

            if (selectedCorrelativeId > 0) {
                CorrelativeController.getInstance().view(selectedCorrelativeId);
            }
        });
        divButton.add(saveButton);

        JButton backButton = main.common.components.Button.danger("Volver",
                () -> CorrelativeController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> searchCreate() {
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

        JButton saveButton = main.common.components.Button.info("Buscar", () -> {
            Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (selectedCareerId > 0) {
                CorrelativeController.getInstance().create(false,null, selectedCareerId);
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> CorrelativeController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> searchSubject() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Buscar %s", Subject.TRANSLATE_NAME));

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
        JPanel subjectIDField = Input.createSelect2InputStrInt(SubjectService.getIDNameForSelect2());
        divForm.add(subjectIDField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.info("Buscar", () -> {
            Integer selectedSubjectId = (Integer) ((JComboBox<?>) subjectIDField.getComponent(0)).getClientProperty("selectedIndex");

            if (selectedSubjectId > 0) {
                CorrelativeController.getInstance().correlativePerSubject(selectedSubjectId);
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", CorrelativeController.getInstance()::index);
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> correlativePerSubject(int idSubject) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Correlative.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton backButton = main.common.components.Button.danger("Volver", CorrelativeController.getInstance()::index);
        divButton.add(backButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(CorrelativeService.getCustomColumns(), CorrelativeService.getCustomDataForSubject(idSubject));
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }
}
