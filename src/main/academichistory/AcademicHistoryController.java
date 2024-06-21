package main.academichistory;

import main.career.Career;
import main.career.CareerService;
import main.common.Controller;
import main.common.Model;
import main.correlative.Correlative;
import main.correlative.CorrelativeService;
import main.student.Student;
import main.student.StudentService;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanService;
import main.subject.Subject;
import main.subject.SubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The AcademicHistoryController class is responsible for handling
 * operations related to the AcademicHistory model, including creating,
 * updating, viewing, and deleting academic history records, as well as
 * managing subject enrollment and verifying student graduation status.
 * It implements the Controller interface for standardized operation handling.
 *
 * <p><b>Methods:</b></p>
 * <ul>
 *   <li>index() - Renders the index view of academic histories.</li>
 *   <li>create(boolean save, AcademicHistory model) - Creates a new academic history record.</li>
 *   <li>update(boolean save, int id) - Updates an existing academic history record.</li>
 *   <li>view(int id) - Displays the details of a specific academic history record.</li>
 *   <li>delete(boolean validation, int id) - Deletes an academic history record.</li>
 *   <li>search() - Renders the search view for academic histories.</li>
 *   <li>searchStudent(boolean isVerifyGraduate, boolean isVerifyStudent) - Renders the search view for students based on graduation and enrollment status.</li>
 *   <li>enrollSubject(boolean save, AcademicHistory model, int idStudent) - Enrolls a student in a subject following specific criteria.</li>
 *   <li>viewPerStudent(int idStudent) - Displays the academic history of a specific student.</li>
 *   <li>verifyGraduate(int idStudent) - Verifies if a student meets the graduation requirements.</li>
 * </ul>
 *
 * @see Career
 * @see CareerService
 * @see Controller
 * @see Model
 * @see Correlative
 * @see CorrelativeService
 * @see Student
 * @see StudentService
 * @see StudyPlan
 * @see StudyPlanService
 * @see Subject
 * @see SubjectService
 * @see List
 * @see Map
 * @see Objects
 *
 * @version 1.0.0
 * @since 2024.04.03
 * @autor Giuliano Ignacio Poeta
 */
public class AcademicHistoryController implements Controller {
    private static final AcademicHistoryController instance = new AcademicHistoryController();

    private AcademicHistoryController() {
    }

    /**
     * Gets the singleton instance of the AcademicHistoryController.
     *
     * @return The singleton instance.
     */
    public static AcademicHistoryController getInstance() {
        return instance;
    }

    /**
     * Renders the index view of academic histories.
     */
    public void index() {
        render(AcademicHistoryViews::index);
    }

    /**
     * Creates a new academic history record.
     *
     * @param save  Whether to save the new record.
     * @param model The academic history model to create.
     */
    public void create(boolean save, AcademicHistory model) {
        if (model == null) {
            model = new AcademicHistory();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            AcademicHistory finalModel = model;
            render(() -> AcademicHistoryViews.create(finalModel));
        }
    }

    /**
     * Updates an existing academic history record.
     *
     * @param save Whether to save the updates.
     * @param id   The ID of the academic history record to update.
     */
    public void update(boolean save, int id) {
        AcademicHistory model = (AcademicHistory) AcademicHistoryService.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> AcademicHistoryViews.update(model));
        }
    }

    /**
     * Displays the details of a specific academic history record.
     *
     * @param id The ID of the academic history record to view.
     */
    public void view(int id) {
        AcademicHistory model = (AcademicHistory) AcademicHistoryService.getById(id);
        render(() -> AcademicHistoryViews.view(model));
    }

    /**
     * Deletes an academic history record.
     *
     * @param validation Whether the deletion is validated.
     * @param id         The ID of the academic history record to delete.
     */
    public void delete(boolean validation, int id) {
        if (validation) {
            AcademicHistory model = (AcademicHistory) AcademicHistoryService.getById(id);
            model.delete();
            render(() -> AcademicHistoryViews.delete(true, id));
        } else {
            render(() -> AcademicHistoryViews.delete(false, id));
        }
    }

    /**
     * Renders the search view for academic histories.
     */
    public void search() {
        render(AcademicHistoryViews::search);
    }

    /**
     * Renders the search view for students based on graduation and enrollment status.
     *
     * @param isVerifyGraduate Whether to verify if the student is eligible for graduation.
     * @param isVerifyStudent  Whether to verify if the student is currently enrolled.
     */
    public void searchStudent(boolean isVerifyGraduate, boolean isVerifyStudent) {
        render(() -> AcademicHistoryViews.searchStudent(isVerifyGraduate, isVerifyStudent));
    }

    /**
     * Enrolls a student in a subject following specific criteria.
     *
     * @param save      Whether to save the enrollment.
     * @param model     The academic history model for the enrollment.
     * @param idStudent The ID of the student to enroll.
     */
    public void enrollSubject(boolean save, AcademicHistory model, int idStudent) {
        if (model == null) {
            model = new AcademicHistory();
        }

        model.setIdStudent(idStudent);
        model.setState("Cursando");

        if (save) {
            Subject subject = (Subject) SubjectService.getById(model.getIdSubject());
            StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(subject.getIdStudyPlan());

            boolean canEnroll = true;
            String type = studyPlan.getType();
            if (Objects.equals(type, "A")) {
                // Plan A: aprobó las cursadas de las correlativas
                List<Correlative> correlatives = CorrelativeService.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || Objects.equals(academicHistory.getState(), "Desaprobado")
                            || Objects.equals(academicHistory.getState(), "Cursando")) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type, "B")) {
                // Plan B: aprobó los finales de las correlativas
                List<Correlative> correlatives = CorrelativeService.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado")
                            && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type, "C")) {
                // Plan C: aprobó las cursadas de las correlativas y los finales de todas las
                // materias de 5 cuatrimestres previos al que se quiere anotar
                List<Correlative> correlatives = CorrelativeService.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || Objects.equals(academicHistory.getState(), "Desaprobado")
                            || Objects.equals(academicHistory.getState(), "Cursando")) {
                        canEnroll = false;
                        break;
                    }
                }
                Map<Integer, Subject> allPreviousFourMonthsSubjects = SubjectService
                        .getAllSubjectsFromPreviousFourMonths(model.getIdSubject(), 5);
                for (Subject previousSubject : allPreviousFourMonthsSubjects.values()) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(previousSubject.getId(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado")
                            && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type, "D")) {
                // Plan D: aprobó las cursadas de las correlativas y los finales de todas las
                // materias de 3 cuatrimestres previos al que se quiere anotar
                List<Correlative> correlatives = CorrelativeService.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || Objects.equals(academicHistory.getState(), "Desaprobado")
                            || Objects.equals(academicHistory.getState(), "Cursando")) {
                        canEnroll = false;
                        break;
                    }
                }
                Map<Integer, Subject> allPreviousFourMonthsSubjects = SubjectService
                        .getAllSubjectsFromPreviousFourMonths(model.getIdSubject(), 3);
                for (Subject previousSubject : allPreviousFourMonthsSubjects.values()) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(previousSubject.getId(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado")
                            && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type, "E")) {
                // Plan E: aprobó los finales de las correlativas y los finales de todas las
                // materias de 3 cuatrimestres previos.
                List<Correlative> correlatives = CorrelativeService.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado")
                            && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
                Map<Integer, Subject> allPreviousFourMonthsSubjects = SubjectService
                        .getAllSubjectsFromPreviousFourMonths(model.getIdSubject(), 3);
                for (Subject previousSubject : allPreviousFourMonthsSubjects.values()) {
                    AcademicHistory academicHistory = AcademicHistoryService
                            .getAcademicHistoryFromSubjectStudent(previousSubject.getId(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado")
                            && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            }

            if (canEnroll) {
                if (model.save()) {
                    view(model.getId());
                }
            }
        } else {
            AcademicHistory finalModel = model;
            render(() -> AcademicHistoryViews.enrollSubject(finalModel));
        }
    }

    /**
     * Displays the academic history of a specific student.
     *
     * @param idStudent The ID of the student whose academic history is to be displayed.
     */
    public void viewPerStudent(int idStudent) {
        render(() -> AcademicHistoryViews.historyPerStudent(idStudent));
    }

    /**
     * Verifies if a student meets the graduation requirements.
     *
     * @param idStudent The ID of the student to verify.
     */
    public void verifyGraduate(int idStudent) {
        Student student = (Student) StudentService.getById(idStudent);
        Career career = (Career) CareerService.getById(student.getIdCareer());

        Map<Integer, Model> allSubjects = SubjectService.getAllSubjectsForCareer(career.getId());
        Map<Integer, Model> allAcademicHistory = AcademicHistoryService.getAllAcademicHistoryFromStudent(idStudent);

        List<Subject> subjectsNotApproved = new ArrayList<>();

        for (Model model : allSubjects.values()) {
            if (model instanceof Subject subject) {
                boolean approved = false;
                if (!subject.getIsOptional()) {
                    for (Model modelAH : allAcademicHistory.values()) {
                        if (modelAH instanceof AcademicHistory academicHistory) {
                            if (subject.getId() == academicHistory.getIdSubject() &&
                                    (Objects.equals(academicHistory.getState(), "Aprobado") ||
                                            Objects.equals(academicHistory.getState(), "Promocionado"))) {
                                approved = true;
                                break;
                            }
                        }
                    }
                    if (!approved) {
                        subjectsNotApproved.add(subject);
                    }
                }
            }
        }

        boolean isGraduated = subjectsNotApproved.isEmpty();
        render(() -> AcademicHistoryViews.verifyGraduate(isGraduated, subjectsNotApproved));
    }
}
