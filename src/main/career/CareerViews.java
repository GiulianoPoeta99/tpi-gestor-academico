package main.career;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import main.common.components.*;
import main.common.components.Button;
import main.studyplan.StudyPlan;
import main.subject.Subject;
import main.subject.SubjectService;

/**
 * The CareerViews class provides static methods for generating the user interface
 * components related to career management, including index, create, update, view,
 * delete, search, and view subjects.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>index() - Generates the components for the index view of careers.</li>
 *   <li>create(Career model) - Generates the components for the create career view.</li>
 *   <li>update(Career model) - Generates the components for the update career view.</li>
 *   <li>view(Career model) - Generates the components for the view career details.</li>
 *   <li>delete(boolean isDelete, int id) - Generates the components for the delete career view.</li>
 *   <li>search(boolean viewSubjects) - Generates the components for the search career view.</li>
 *   <li>viewSubjects(StudyPlan model) - Generates the components for the view subjects of a career view.</li>
 * </ul>
 *
 * @see Career
 * @see CareerController
 * @see CareerService
 * @see StudyPlan
 * @see Subject
 * @see SubjectService
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.02.08
 */
public class CareerViews {

    /**
     * Generates the components for the index view of careers.
     *
     * @return A list of JComponents for the index view.
     */
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(Career.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton createButton = Button.success("Crear carrera",
                () -> CareerController.getInstance().create(false, null));
        divButton.add(createButton);
        JButton searchButton = Button.warning("Ver carrera", () -> CareerController.getInstance().search(false));
        divButton.add(searchButton);
        JButton subjectButton = Button.info("Ver materias", () -> CareerController.getInstance().search(true));
        divButton.add(subjectButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(CareerService.getCustomColumns(), CareerService.getCustomData());
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }

    /**
     * Handles saving or updating a career model based on the input field values.
     *
     * @param model     The Career model to be saved or updated.
     * @param nameField The JTextField containing the career name.
     */
    private static void performSaveOrUpdate(Career model, JTextField nameField) {
        String newName = nameField.getText();
        if (!newName.isEmpty()) {
            assert model != null;
            if (!newName.equals(model.getName())) {
                model.setName(newName);
            }
        }
    }

    /**
     * Generates a form for creating or updating a career model.
     *
     * @param model The Career model to be created or updated.
     * @param update A boolean indicating whether the form is for updating an existing career.
     * @return A JPanel containing the form components.
     */
    private static JPanel form(Career model, boolean update) {
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

        JLabel nameLabel = Text.label("Nombre:");
        divForm.add(nameLabel, conditions);

        conditions.gridy++;
        JTextField nameField = Input.createInput(model != null ? model.getName() : "");
        divForm.add(nameField, conditions);

        div.add(divForm, BorderLayout.NORTH);
        divBox.add(div, BorderLayout.NORTH);

        JPanel divButton = new JPanel();
        divButton.setBackground(Common.BACKGROUND_COLOR);
        divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton saveButton = Button.success("Guardar", () -> {
            performSaveOrUpdate(model, nameField);
            CareerController.getInstance().create(true, model);
        });
        if (update) {
            saveButton = Button.primary("Actualizar", () -> {
                performSaveOrUpdate(model, nameField);
                assert model != null;
                CareerController.getInstance().update(true, model.getId());
            });
        }

        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> CareerController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        return divBox;
    }

    /**
     * Generates the components for the create career view.
     *
     * @param model The Career model to be created.
     * @return A list of JComponents for the create career view.
     */
    public static List<JComponent> create(Career model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Crear " + Career.TRANSLATE_NAME);

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, false);

        components.add(divBox);

        return components;
    }

    /**
     * Generates the components for the update career view.
     *
     * @param model The Career model to be updated.
     * @return A list of JComponents for the update career view.
     */
    public static List<JComponent> update(Career model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Actualizar " + Career.TRANSLATE_NAME + " registro: " + model.getId());

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = form(model, true);

        components.add(divBox);

        return components;
    }

    /**
     * Generates the components for viewing the details of a career.
     *
     * @param model The Career model to be viewed.
     * @return A list of JComponents for the view career details.
     */
    public static List<JComponent> view(Career model) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Ver %s ID: %d", Career.TRANSLATE_NAME, model.getId()));

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

        JButton continueButton = Button.secondary("Continuar", () -> CareerController.getInstance().index());
        divButton.add(continueButton);

        JButton createButton = Button.success("Crear", () -> CareerController.getInstance().create(false, null));
        divButton.add(createButton);

        JButton updateButton = Button.primary("Actualizar",
                () -> CareerController.getInstance().update(false, model.getId()));
        divButton.add(updateButton);

        JButton deleteButton = Button.danger("Eliminar",
                () -> CareerController.getInstance().delete(false, model.getId()));
        divButton.add(deleteButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    /**
     * Generates the components for the delete career view.
     *
     * @param isDelete A boolean indicating if the career has been deleted.
     * @param id The ID of the career to be deleted.
     * @return A list of JComponents for the delete career view.
     */
    public static List<JComponent> delete(boolean isDelete, int id) {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1(String.format("Eliminar %s ID: %d", Career.TRANSLATE_NAME, id));

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

            JLabel viewModel = Text.h3(CareerService.getById(id).toString());

            div.add(viewModel);

            divBox.add(div, BorderLayout.CENTER);

            JPanel divButton = new JPanel();
            divButton.setBackground(Common.BACKGROUND_COLOR);
            divButton.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton deleteButton = Button.danger("Eliminar", () -> CareerController.getInstance().delete(true, id));
            divButton.add(deleteButton);

            JButton goBackButton = Button.primary("Volver", () -> CareerController.getInstance().view(id));
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

            JButton continueButton = Button.secondary("Continuar", () -> CareerController.getInstance().index());
            divButton.add(continueButton);

            divBox.add(divButton, BorderLayout.SOUTH);
        }

        components.add(divBox);

        return components;
    }

    /**
     * Generates the components for the search career view.
     *
     * @param viewSubjects A boolean indicating whether to view subjects related to the career.
     * @return A list of JComponents for the search career view.
     */
    public static List<JComponent> search(boolean viewSubjects) {
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
            Integer selectedCareerId = (Integer) ((JComboBox<?>) careerIDField.getComponent(0))
                    .getClientProperty("selectedIndex");

            if (selectedCareerId > 0) {
                if (viewSubjects) {
                    CareerController.getInstance().viewSubjects(selectedCareerId);
                } else {
                    CareerController.getInstance().view(selectedCareerId);
                }
            }
        });
        divButton.add(saveButton);

        JButton backButton = Button.danger("Volver", () -> CareerController.getInstance().index());
        divButton.add(backButton);

        divBox.add(divButton, BorderLayout.SOUTH);

        components.add(divBox);

        return components;
    }

    /**
     * Generates the components for viewing the subjects of a career.
     *
     * @param model The StudyPlan model representing the study plan of the career.
     * @return A list of JComponents for the view subjects of a career view.
     */
    public static List<JComponent> viewSubjects(StudyPlan model) {
        List<JComponent> components = new ArrayList<>();
        String career = ((Career) CareerService.getById(model.getIdCareer())).getName();

        JLabel title = Text.h1(String.format("Ver %ss de la %s: %s y el %s %d (%s) Tipo: %s", Subject.TRANSLATE_NAME,
                Career.TRANSLATE_NAME, career, StudyPlan.TRANSLATE_NAME, model.getId(),
                model.getIsActive() ? "Vigente" : "No vigente", model.getType()));

        Box titleBox = Box.createHorizontalBox();
        titleBox.add(Box.createHorizontalGlue());
        titleBox.add(title);
        titleBox.add(Box.createHorizontalGlue());
        components.add(titleBox);

        JPanel divBox = UIComponent.bigBox();
        divBox.setLayout(new BorderLayout());

        JPanel divButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        divButton.setBackground(Common.BACKGROUND_COLOR);
        JButton backButton = Button.danger("Volver", CareerController.getInstance()::index);
        divButton.add(backButton);
        divBox.add(divButton, BorderLayout.NORTH);

        JScrollPane table = UIComponent.table(SubjectService.getCustomColumnsForStudyPlan(),
                SubjectService.getCustomDataForStudyPlan(model.getId()));
        divBox.add(table, BorderLayout.CENTER);

        components.add(divBox);

        return components;
    }
}
