package main.career;

import main.common.Controller;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanService;

import java.util.Objects;

/**
 * The CareerController class provides methods to manage careers, including creating, updating, viewing,
 * and deleting career instances. It also allows searching and viewing subjects related to a specific career.
 * Implements the Controller interface to provide consistent control flow and rendering methods.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getInstance() - Retrieves the singleton instance of the CareerController.</li>
 *   <li>index() - Renders the index view for careers.</li>
 *   <li>create(boolean save, Career model) - Creates a new career instance and optionally saves it.</li>
 *   <li>update(boolean save, int id) - Updates an existing career instance by its ID and optionally saves it.</li>
 *   <li>view(int id) - Views a career instance by its ID.</li>
 *   <li>delete(boolean validation, int id) - Deletes a career instance by its ID with optional validation.</li>
 *   <li>search(boolean viewSubjects) - Renders the search view for careers with an option to view subjects.</li>
 *   <li>viewSubjects(int idCareer) - Views the subjects related to a specific career by its ID.</li>
 * </ul>
 *
 * @see Controller
 * @see Career
 * @see StudyPlan
 * @see StudyPlanService
 * @see CareerViews
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.05
 */
public class CareerController implements Controller {
    private static final CareerController instance = new CareerController();

    /**
     * Default constructor.
     */
    private CareerController() {
    }

    /**
     * Retrieves the singleton instance of the CareerController.
     *
     * @return The singleton instance of the CareerController.
     */
    public static CareerController getInstance() {
        return instance;
    }

    /**
     * Renders the index view for careers.
     */
    public void index() {
        render(CareerViews::index);
    }

    /**
     * Creates a new career instance and optionally saves it.
     *
     * @param save Indicates whether to save the career instance.
     * @param model The career model to be created or null to create a new instance.
     */
    public void create(boolean save, Career model) {
        if (model == null) {
            model = new Career();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Career finalModel = model;
            render(() -> CareerViews.create(finalModel));
        }
    }

    /**
     * Updates an existing career instance by its ID and optionally saves it.
     *
     * @param save Indicates whether to save the updated career instance.
     * @param id The ID of the career instance to be updated.
     */
    public void update(boolean save, int id) {
        Career model = (Career) CareerService.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> CareerViews.update(model));
        }
    }

    /**
     * Views a career instance by its ID.
     *
     * @param id The ID of the career instance to be viewed.
     */
    public void view(int id) {
        Career model = (Career) CareerService.getById(id);
        render(() -> CareerViews.view(model));
    }

    /**
     * Deletes a career instance by its ID with optional validation.
     *
     * @param validation Indicates whether to validate the deletion.
     * @param id The ID of the career instance to be deleted.
     */
    public void delete(boolean validation, int id) {
        if (validation) {
            Career model = (Career) CareerService.getById(id);
            model.delete();
            render(() -> CareerViews.delete(true, id));
        } else {
            render(() -> CareerViews.delete(false, id));
        }
    }

    /**
     * Renders the search view for careers with an option to view subjects.
     *
     * @param viewSubjects Indicates whether to include subjects in the search view.
     */
    public void search(boolean viewSubjects) {
        render(() -> CareerViews.search(viewSubjects));
    }

    /**
     * Views the subjects related to a specific career by its ID.
     *
     * @param idCareer The ID of the career whose subjects are to be viewed.
     */
    public void viewSubjects(int idCareer) {
        int idStudyPlan = ((StudyPlan) Objects.requireNonNull(StudyPlanService.getByIdCareer(idCareer))).getId();
        StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(idStudyPlan);
        render(() -> CareerViews.viewSubjects(studyPlan));
    }
}
