package main.subject;

import main.common.Controller;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanService;

/**
 * The SubjectController class manages the operations related to Subject entities,
 * including creating, updating, viewing, deleting, and searching subjects.
 * It follows the singleton pattern to ensure a single instance.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getInstance() - Retrieves the single instance of the SubjectController.</li>
 *   <li>index() - Displays the index view of subjects.</li>
 *   <li>create(boolean save, Subject model, int idCareer) - Creates a new subject or renders the creation view.</li>
 *   <li>update(boolean save, int id) - Updates an existing subject or renders the update view.</li>
 *   <li>view(int id) - Displays the details of a specific subject.</li>
 *   <li>delete(boolean validation, int id) - Deletes a subject or renders the delete confirmation view.</li>
 *   <li>search() - Displays the search view for subjects.</li>
 * </ul>
 *
 * @see Controller
 * @see Subject
 * @see StudyPlan
 * @see StudyPlanService
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.06
 */
public class SubjectController implements Controller {
    private static final SubjectController instance = new SubjectController();

    /**
     * Private constructor to prevent instantiation.
     */
    private SubjectController() {
    }

    /**
     * Retrieves the single instance of the SubjectController.
     *
     * @return The single instance of SubjectController.
     */
    public static SubjectController getInstance() {
        return instance;
    }

    /**
     * Displays the index view of subjects.
     */
    public void index() {
        render(SubjectViews::index);
    }

    /**
     * Creates a new subject or renders the creation view.
     *
     * @param save Indicates whether to save the subject.
     * @param model The subject model to create or save.
     * @param idCareer The ID of the career associated with the subject.
     */
    public void create(boolean save, Subject model, int idCareer) {
        if (model == null) {
            model = new Subject();
        }

        if (save) {
            if (idCareer != 0) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanService.getByIdCareer(idCareer);

                if ((studyPlan != null) && (studyPlan.getId() != model.getIdStudyPlan())) {
                    model.setIdStudyPlan(studyPlan.getId());
                }

                if (model.save()) {
                    view(model.getId());
                }
            }

        } else {
            Subject finalModel = model;
            render(() -> SubjectViews.create(finalModel));
        }
    }

    /**
     * Updates an existing subject or renders the update view.
     *
     * @param save Indicates whether to save the updated subject.
     * @param id The ID of the subject to update.
     */
    public void update(boolean save, int id) {
        Subject model = (Subject) SubjectService.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> SubjectViews.update(model));
        }
    }

    /**
     * Displays the details of a specific subject.
     *
     * @param id The ID of the subject to view.
     */
    public void view(int id) {
        Subject model = (Subject) SubjectService.getById(id);
        render(() -> SubjectViews.view(model));
    }

    /**
     * Deletes a subject or renders the delete confirmation view.
     *
     * @param validation Indicates whether to validate before deletion.
     * @param id The ID of the subject to delete.
     */
    public void delete(boolean validation, int id) {
        if (validation) {
            Subject model = (Subject) SubjectService.getById(id);
            model.delete();
            render(() -> SubjectViews.delete(true, id));
        } else {
            render(() -> SubjectViews.delete(false, id));
        }
    }

    /**
     * Displays the search view for subjects.
     */
    public void search() {
        render(SubjectViews::search);
    }
}
