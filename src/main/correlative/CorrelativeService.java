package main.correlative;

import main.common.Model;
import main.subject.Subject;
import main.subject.SubjectService;

import java.util.*;

/**
 * The CorrelativeService class provides services for handling correlative relationships
 * between subjects. It includes methods to retrieve custom columns and data, fetch
 * correlatives by ID, and obtain data specific to subjects.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #getCustomColumns()} - Retrieves custom column names for correlative data.</li>
 *   <li>{@link #getCustomData()} - Retrieves custom data for all correlatives.</li>
 *   <li>{@link #getById(int)} - Retrieves a correlative by its ID.</li>
 *   <li>{@link #getIDNameForSelect2()} - Retrieves a map of correlative IDs and names formatted for select2.</li>
 *   <li>{@link #getCustomDataForSubject(int)} - Retrieves custom data for a specific subject.</li>
 *   <li>{@link #getAllCorrelativesForSubject(int)} - Retrieves all correlatives for a specific subject.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2024.04.04
 * @see Correlative
 * @see Model
 * @see Subject
 * @see SubjectService
 *
 * @author Giuliano Ignacio Poeta
 */
public class CorrelativeService extends Correlative {
    /**
     * Retrieves custom column names for correlative data.
     *
     * @return An array of custom column names.
     */
    public static String[] getCustomColumns() {
        return new String[] { "Materia", "Materia correlativa" };
    }

    /**
     * Retrieves custom data for all correlatives.
     *
     * @return A list of custom data arrays.
     */
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                Subject subject = (Subject) SubjectService.getById(correlative.getIdSubject());
                Subject subjectCorrelative = (Subject) SubjectService.getById(correlative.getIdSubjectCorrelative());
                Object[] rowData = new Object[] {
                        subject.getName(),
                        subjectCorrelative.getName()
                };
                customData.add(rowData);
            }
        }
        return customData;
    }

    /**
     * Retrieves a correlative by its ID.
     *
     * @param id The ID of the correlative.
     * @return The correlative model.
     */
    public static Model getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a map of correlative IDs and names formatted for select2.
     *
     * @return A map of correlative IDs and names.
     */
    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> correlativeMap = new LinkedHashMap<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                Subject subject = (Subject) SubjectService.getById(correlative.getIdSubject());
                Subject subjectCorrelative = (Subject) SubjectService.getById(correlative.getIdSubject());
                String name = String.format("%d - %s -> %s", correlative.getId(), subjectCorrelative.getName(),
                        subject.getName());
                correlativeMap.put(correlative.getId(), name);
            }
        }
        return correlativeMap;
    }
    /**
     * Retrieves custom data for a specific subject.
     *
     * @param idSubject The ID of the subject.
     * @return A list of custom data arrays for the subject.
     */
    public static List<Object[]> getCustomDataForSubject(int idSubject) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                if (idSubject == correlative.getIdSubject()) {
                    Subject subject = (Subject) SubjectService.getById(correlative.getIdSubject());
                    Subject subjectCorrelative = (Subject) SubjectService
                            .getById(correlative.getIdSubjectCorrelative());
                    Object[] rowData = new Object[] {
                            subject.getName(),
                            subjectCorrelative.getName()
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    /**
     * Retrieves all correlatives for a specific subject.
     *
     * @param idSubject The ID of the subject.
     * @return A list of correlatives for the subject.
     */
    public static List<Correlative> getAllCorrelativesForSubject(int idSubject) {
        List<Correlative> allCorrelatives = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                if (idSubject == correlative.getIdSubject()) {
                    allCorrelatives.add(correlative);
                }
            }
        }
        return allCorrelatives;
    }
}
