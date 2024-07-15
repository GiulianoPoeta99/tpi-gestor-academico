package main.subject;

import main.career.Career;
import main.career.CareerService;
import main.common.Model;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The SubjectService class provides various utility methods to manage subjects,
 * including retrieving custom data, fetching subjects by ID, and retrieving subjects
 * associated with specific study plans and careers.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getCustomData() - Retrieves custom data for all subjects.</li>
 *   <li>getCustomColumns() - Retrieves custom column names for subjects.</li>
 *   <li>getById(int id) - Fetches a subject by its ID.</li>
 *   <li>getIDNameForSelect2() - Retrieves a map of subject IDs and names for Select2.</li>
 *   <li>getCustomDataForStudyPlan(int idStudyPlan) - Retrieves custom data for subjects in a specific study plan.</li>
 *   <li>getCustomColumnsForStudyPlan() - Retrieves custom column names for subjects in a study plan.</li>
 *   <li>getAllSubjectsForCareer(int idCareer) - Retrieves all subjects for a specific career.</li>
 *   <li>getAllSubjectsForCareerForSelect2(int idCareer) - Retrieves a map of subject IDs and names for a specific career for Select2.</li>
 *   <li>getAllSubjectsFromPreviousFourMonths(int idSubject, int countFourMonths) - Retrieves subjects from previous four months.</li>
 * </ul>
 *
 * @see Subject
 * @see StudyPlan
 * @see StudyPlanService
 * @see Career
 * @see CareerService
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.03.12
 */
public class SubjectService extends Subject {
    /**
     * Retrieves custom data for all subjects.
     *
     * @return A list of custom data arrays for subjects.
     */
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                Model studyPlanModel = StudyPlanService.getById(subject.getIdStudyPlan());
                if (studyPlanModel instanceof StudyPlan studyPlan) {
                    Model careerModel = CareerService.getById(studyPlan.getIdCareer());
                    if (careerModel instanceof Career career) {
                        Object[] rowData = new Object[] {
                                subject.getName(),
                                subject.getIsOptional() ? "Si" : "No",
                                subject.getFourMonths(),
                                career.getName()
                        };
                        customData.add(rowData);
                    }
                }
            }
        }
        return customData;
    }

    /**
     * Retrieves custom column names for subjects.
     *
     * @return An array of custom column names.
     */
    public static String[] getCustomColumns() {
        return new String[] { "Nombre", "Opcional", "Cuatrimestre", "Carrera" };
    }

    /**
     * Fetches a subject by its ID.
     *
     * @param id The ID of the subject.
     * @return The subject model.
     */
    public static Model getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a map of subject IDs and names for Select2.
     *
     * @return A map of subject IDs and names.
     */
    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> subjectMap = new LinkedHashMap<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(subject.getIdStudyPlan());
                Career career = (Career) CareerService.getById(studyPlan.getIdCareer());

                String name = String.format("%s - %s", career.getName(), subject.getName());

                subjectMap.put(subject.getId(), name);
            }
        }
        return subjectMap;
    }

    /**
     * Retrieves custom data for subjects in a specific study plan.
     *
     * @param idStudyPlan The ID of the study plan.
     * @return A list of custom data arrays for subjects.
     */
    public static List<Object[]> getCustomDataForStudyPlan(int idStudyPLan) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                if (subject.getIdStudyPlan() == idStudyPLan) {
                    Object[] rowData = new Object[] {
                            subject.getName(),
                            subject.getIsOptional() ? "Si" : "No",
                            subject.getFourMonths()
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    /**
     * Retrieves custom column names for subjects in a study plan.
     *
     * @return An array of custom column names.
     */
    public static String[] getCustomColumnsForStudyPlan() {
        return new String[] { "Nombre", "Opcional", "Cuatrimestre" };
    }

    /**
     * Retrieves all subjects for a specific career.
     *
     * @param idCareer The ID of the career.
     * @return A map of subject IDs and models.
     */
    public static Map<Integer, Model> getAllSubjectsForCareer(int idCareer) {
        Map<Integer, Model> subjectsMap = new LinkedHashMap<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(subject.getIdStudyPlan());
                if (idCareer == studyPlan.getId()) {
                    subjectsMap.put(subject.getId(), subject);
                }
            }
        }
        return subjectsMap;
    }

    /**
     * Retrieves a map of subject IDs and names for a specific career for Select2.
     *
     * @param idCareer The ID of the career.
     * @return A map of subject IDs and names.
     */
    public static Map<Integer, String> getAllSubjectsForCareerForSelect2(int idCareer) {
        Map<Integer, String> subjectsMap = new LinkedHashMap<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanService.getById(subject.getIdStudyPlan());
                if (idCareer == studyPlan.getId()) {
                    Career career = (Career) CareerService.getById(studyPlan.getIdCareer());

                    String name = String.format("%s - %s", career.getName(), subject.getName());
                    subjectsMap.put(subject.getId(), name);
                }
            }
        }
        return subjectsMap;
    }

    /**
     * Retrieves subjects from previous four months.
     *
     * @param idSubject The ID of the subject.
     * @param countFourMonths The number of previous four months.
     * @return A map of subject IDs and models.
     */
    public static Map<Integer, Subject> getAllSubjectsFromPreviousFourMonths(int idSubject, int countFourMonths) {
        Map<Integer, Subject> subjectsMap = new LinkedHashMap<>();
        Subject selectSubject = (Subject) SubjectService.getById(idSubject);

        int minFourMonths = selectSubject.getFourMonths() - countFourMonths;

        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                if ((subject.getFourMonths() >= minFourMonths)
                        && (subject.getFourMonths() <= selectSubject.getFourMonths())) {
                    subjectsMap.put(subject.getId(), subject);
                }
            }
        }
        return subjectsMap;
    }
}
