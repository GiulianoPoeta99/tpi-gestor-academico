package main.correlative;

import main.career.Career;
import main.career.CareerService;
import main.common.Controller;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanService;
import main.subject.Subject;
import main.subject.SubjectService;

/**
 * The CorrelativeController class is responsible for handling requests related to correlatives within the system.
 * It includes methods to create, update, view, delete, and search correlatives.
 * Implements the Controller interface for consistent handling of actions.
 *
 * <p>Attributes:</p>
 * <ul>
 *   <li>instance - Singleton instance of CorrelativeController.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getInstance() - Returns the singleton instance of the controller.</li>
 *   <li>index() - Renders the index view for correlatives.</li>
 *   <li>create(boolean save, Correlative model, int idCareer) - Handles the creation of a correlative.</li>
 *   <li>update(boolean save, int id) - Handles the update of a correlative.</li>
 *   <li>view(int id) - Displays a specific correlative by ID.</li>
 *   <li>delete(boolean validation, int id) - Deletes a correlative by ID with optional validation.</li>
 *   <li>search() - Renders the search view for correlatives.</li>
 *   <li>searchCreate() - Renders the search create view for correlatives.</li>
 *   <li>searchSubject() - Renders the search subject view for correlatives.</li>
 *   <li>correlativePerSubject(int idSubject) - Displays correlatives for a specific subject.</li>
 * </ul>
 *
 * @version 1.0.0
 * @autor Giuliano Ignacio Poeta
 * @since yyyy.mm.dd
 */
public class CorrelativeController implements Controller {
    private static final CorrelativeController instance = new CorrelativeController();

    /**
     * Private constructor to prevent instantiation.
     */
    private CorrelativeController() {
    }

    /**
     * Returns the singleton instance of the controller.
     *
     * @return The singleton instance of CorrelativeController.
     */
    public static CorrelativeController getInstance() {
        return instance;
    }

    /**
     * Renders the index view for correlatives.
     */
    public void index() {
        render(CorrelativeViews::index);
    }

    /**
     * Handles the creation of a correlative.
     *
     * @param save     Flag indicating whether to save the correlative.
     * @param model    The Correlative model instance.
     * @param idCareer The ID of the career.
     */
    public void create(boolean save, Correlative model, int idCareer) {
        if (model == null) {
            model = new Correlative();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Correlative finalModel = model;
            render(() -> CorrelativeViews.create(finalModel, idCareer));
        }
    }

    /**
     * Handles the update of a correlative.
     *
     * @param save Flag indicating whether to save the correlative.
     * @param id   The ID of the correlative to update.
     */
    public void update(boolean save, int id) {
        Correlative model = (Correlative) CorrelativeService.getById(id);
        Subject subject = (Subject) SubjectService.getById(model.getIdSubject());
        StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(subject.getIdStudyPlan());
        Career career = (Career) CareerService.getById(studyPlan.getIdCareer());

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> CorrelativeViews.update(model, career.getId()));
        }
    }

    /**
     * Displays a specific correlative by ID.
     *
     * @param id The ID of the correlative to view.
     */
    public void view(int id) {
        Correlative model = (Correlative) CorrelativeService.getById(id);
        render(() -> CorrelativeViews.view(model));
    }

    /**
     * Deletes a correlative by ID with optional validation.
     *
     * @param validation Flag indicating whether to validate the deletion.
     * @param id         The ID of the correlative to delete.
     */
    public void delete(boolean validation, int id) {
        if (validation) {
            Correlative model = (Correlative) CorrelativeService.getById(id);
            model.delete();
            render(() -> CorrelativeViews.delete(true, id));
        } else {
            render(() -> CorrelativeViews.delete(false, id));
        }
    }

    /**
     * Renders the search view for correlatives.
     */
    public void search() {
        render(CorrelativeViews::search);
    }

    /**
     * Renders the search create view for correlatives.
     */
    public void searchCreate() {
        render(CorrelativeViews::searchCreate);
    }

    /**
     * Renders the search subject view for correlatives.
     */
    public void searchSubject() {
        render(CorrelativeViews::searchSubject);
    }

    /**
     * Displays correlatives for a specific subject.
     *
     * @param idSubject The ID of the subject.
     */
    public void correlativePerSubject(int idSubject) {
        render(() -> CorrelativeViews.correlativePerSubject(idSubject));
    }
}
