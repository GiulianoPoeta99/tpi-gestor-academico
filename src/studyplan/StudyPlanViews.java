package studyplan;

import career.CareerSearch;
import common.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.components.*;
import common.components.Button;

public class StudyPlanViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(StudyPlan.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JButton createButton = Button.success("Crear plan de estudio", () -> StudyPlanController.getInstance().create(false, null));
        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.add(createButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(StudyPlanSearch.getCustomColumns(), StudyPlanSearch.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    private static void performSaveOrUpdate(StudyPlan model, JPanel typeField, JPanel careerIDField, JPanel isActiveField) {
        String selectedType = (String) ((JComboBox<?>) typeField.getComponent(0)).getClientProperty("selectedIndex");
        Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0)).getClientProperty("selectedIndex");
        boolean selectedIsActive = (boolean) ((JComboBox<?>) isActiveField.getComponent(0)).getClientProperty("selectedIndex");
        if (selectedType != null && !selectedType.isEmpty() && !selectedType.equals(model.getType())) {
            model.setType(selectedType);
        }

        if (selectedCareerId > 0 && selectedCareerId != model.getIdCareer()) {
            model.setIdCareer(selectedCareerId);
        }

        if (selectedIsActive != model.getIsActive()) {
            model.setIsActive(selectedIsActive);
        }
    }

    private static JPanel form(StudyPlan model, boolean update) {
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

        JLabel typeLabel = Text.label("Tipo:");
        divForm.add(typeLabel, constraints);

        constraints.gridy++;
        JPanel typeField = Input.createSelect2InputStrStr(StudyPlanSearch.getTypeForSelect2());
        divForm.add(typeField, constraints);

        constraints.gridy++;
        JLabel careerIDLabel = Text.label("Carrera:");
        divForm.add(careerIDLabel, constraints);

        constraints.gridy++;
        JPanel careerIDField = Input.createSelect2InputStrInt(CareerSearch.getIDNameForSelect2());
        divForm.add(careerIDField, constraints);

        constraints.gridy++;
        JLabel isActiveLabel = Text.label("Vigente:");
        divForm.add(isActiveLabel, constraints);

        constraints.gridy++;
        JPanel isActiveField = Input.createSelect2InputBoolStr();
        divForm.add(isActiveField, constraints);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            performSaveOrUpdate(model,typeField,careerIDField,isActiveField);
            StudyPlanController.getInstance().create(true, model);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                performSaveOrUpdate(model,typeField,careerIDField,isActiveField);
                StudyPlanController.getInstance().update(true, model.getId());
            });
        }
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> StudyPlanController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    public static List<JComponent> create(StudyPlan model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + StudyPlan.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, false);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> update(StudyPlan model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + StudyPlan.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, true);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> view(StudyPlan model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Ver %s ID: %d", StudyPlan.TRANSLATE_NAME, model.getId()));

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

        JButton continueButton = Button.secondary("Continuar", () -> StudyPlanController.getInstance().index());
        divButton.add(continueButton);

        JButton createButton = Button.success("Crear", () -> StudyPlanController.getInstance().create(false, null));
        divButton.add(createButton);

        JButton updateButton = Button.primary("Actualizar", () -> StudyPlanController.getInstance().update(false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = Button.danger("Eliminar", () -> StudyPlanController.getInstance().delete(false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    public static List<JComponent> delete(boolean isDelete, int id) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Eliminar %s ID: %d", StudyPlan.TRANSLATE_NAME, id));

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

            JLabel viewModel = Text.h3(StudyPlanSearch.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = Button.danger("Eliminar", () -> StudyPlanController.getInstance().delete(true, id));
            divButton.add(deleteButton);

            JButton goBackButton = Button.primary("Volver", () -> StudyPlanController.getInstance().view(id));
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

            JButton continueButton = Button.secondary("Continuar", () -> StudyPlanController.getInstance().index());
            divButton.add(continueButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        }

        components.add(divBox);

        return components;
    }
}