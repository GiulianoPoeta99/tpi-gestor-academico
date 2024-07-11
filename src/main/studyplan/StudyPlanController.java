package main.studyplan;

import main.common.Controller;

/**
 * The StudyPlanController class is responsible for handling the study plan operations
 * such as creating, updating, viewing, deleting, and searching study plans.
 * It implements the Singleton pattern to ensure only one instance of the controller exists.
 *
 * <p>Singleton Instance:</p>
 * <ul>
 *   <li>instance - The single instance of the StudyPlanController.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getInstance() - Returns the single instance of the StudyPlanController.</li>
 *   <li>index() - Renders the index view for study plans.</li>
 *   <li>create(boolean save, StudyPlan model) - Creates a new study plan, saving it if specified.</li>
 *   <li>update(boolean save, int id) - Updates an existing study plan, saving it if specified.</li>
 *   <li>view(int id) - Views a specific study plan by ID.</li>
 *   <li>delete(boolean validation, int id) - Deletes a study plan with optional validation.</li>
 *   <li>search(boolean viewSubjects) - Searches for study plans, optionally viewing subjects.</li>
 *   <li>viewSubjects(int idStudyPlan) - Views the subjects of a specific study plan by ID.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.06
 */
public class StudyPlanController implements Controller {
    private static final StudyPlanController instance = new StudyPlanController();

    /**
     * Private constructor to prevent instantiation.
     */
    private StudyPlanController() {
    }

    /**
     * Returns the single instance of the StudyPlanController.
     *
     * @return The instance of StudyPlanController.
     */
    public static StudyPlanController getInstance() {
        return instance;
    }

    /**
     * Renders the index view for study plans.
     */
    public void index() {
        render(StudyPlanViews::index);
    }

    /**
     * Creates a new study plan, saving it if specified.
     *
     * @param save  Whether to save the new study plan.
     * @param model The study plan model to create.
     */
    public void create(boolean save, StudyPlan model) {
        if (model == null) {
            model = new StudyPlan();
        }

        if (save) {
            model.setIsActive(true);
            StudyPlan studyPlanActive = (StudyPlan) StudyPlanService.getByIdCareer(model.getIdCareer());
            if (studyPlanActive != null) {
                studyPlanActive.setIsActive(false);
                if (studyPlanActive.update()) {
                    if (model.save()) {
                        view(model.getId());
                    }
                }
            } else {
                if (model.save()) {
                    view(model.getId());
                }
            }
        } else {
            StudyPlan finalModel = model;
            render(() -> StudyPlanViews.create(finalModel));
        }
    }

    /**
     * Updates an existing study plan, saving it if specified.
     *
     * @param save Whether to save the updated study plan.
     * @param id   The ID of the study plan to update.
     */
    public void update(boolean save, int id) {
        StudyPlan model = (StudyPlan) StudyPlanService.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> StudyPlanViews.update(model));
        }
    }

    /**
     * Views a specific study plan by ID.
     *
     * @param id The ID of the study plan to view.
     */
    public void view(int id) {
        StudyPlan model = (StudyPlan) StudyPlanService.getById(id);
        render(() -> StudyPlanViews.view(model));
    }

    /**
     * Deletes a study plan with optional validation.
     *
     * @param validation Whether to validate before deleting.
     * @param id         The ID of the study plan to delete.
     */
    public void delete(boolean validation, int id) {
        if (validation) {
            StudyPlan model = (StudyPlan) StudyPlanService.getById(id);
            model.delete();
            render(() -> StudyPlanViews.delete(true, id));
        } else {
            render(() -> StudyPlanViews.delete(false, id));
        }
    }

    /**
     * Searches for study plans, optionally viewing subjects.
     *
     * @param viewSubjects Whether to view subjects of the study plans.
     */
    public void search(boolean viewSubjects) {
        render(() -> StudyPlanViews.search(viewSubjects));
    }

    /**
     * Views the subjects of a specific study plan by ID.
     *
     * @param idStudyPlan The ID of the study plan to view subjects for.
     */
    public void viewSubjects(int idStudyPlan) {
        StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(idStudyPlan);
        render(() -> StudyPlanViews.viewSubjects(studyPlan));
    }
}
