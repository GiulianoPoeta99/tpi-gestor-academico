package main.academichistory;

import main.common.Model;
import main.student.Student;
import main.student.StudentService;
import main.subject.Subject;
import main.subject.SubjectService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The AcademicHistoryService class provides various services related to AcademicHistory records,
 * including retrieving custom data, finding specific academic history records, and generating data
 * for select options in a UI context.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>{@link #getCustomColumns()} - Returns an array of custom column names for academic history data.</li>
 *   <li>{@link #getCustomData()} - Retrieves a list of custom data arrays for all academic history records.</li>
 *   <li>{@link #getById(int)} - Retrieves an academic history record by its ID.</li>
 *   <li>{@link #getIDNameForSelect2()} - Generates a map of academic history records formatted for Select2.</li>
 *   <li>{@link #getStateForSelect2()} - Generates a map of possible states for academic history records formatted for Select2.</li>
 *   <li>{@link #getAllAcademicHistoryFromStudent(int)} - Retrieves all academic history records for a specific student.</li>
 *   <li>{@link #getCustomDataForStudent(int)} - Retrieves custom data arrays for a specific student.</li>
 *   <li>{@link #getAcademicHistoryFromSubjectStudent(int, int)} - Retrieves an academic history record for a specific subject and student.</li>
 * </ul>
 *
 * @version 1.0.0
 * @since 2024.04.03
 * @author Giuliano Ignacio Poeta
 */
public class AcademicHistoryService extends AcademicHistory {
    /**
     * Returns an array of custom column names for academic history data.
     *
     * @return an array of column names.
     */
    public static String[] getCustomColumns() {
        return new String[] { "Estudiante", "Materia", "Estado", "Parcial 1", "Parcial 2", "Promoción", "Final",
                "Nota" };
    }

    /**
     * Retrieves a list of custom data arrays for all academic history records.
     *
     * @return a list of custom data arrays.
     */
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                Student student = (Student) StudentService.getById(academicHistory.getIdStudent());
                Subject subject = (Subject) SubjectService.getById(academicHistory.getIdSubject());
                Object[] rowData = new Object[] {
                        String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(),
                                student.getFirstName()),
                        String.format("%s - %s", subject.getId(), subject.getName()),
                        academicHistory.getState(),
                        academicHistory.getPartial1(),
                        academicHistory.getPartial2(),
                        academicHistory.getIsPromoted() ? "Si" : "No",
                        academicHistory.getFinalExam(),
                        academicHistory.getGrade()
                };
                customData.add(rowData);
            }
        }
        return customData;
    }

    /**
     * Retrieves an academic history record by its ID.
     *
     * @param id the ID of the academic history record.
     * @return the academic history record with the specified ID.
     */
    public static Model getById(int id) {
        return all.get(id);
    }

    /**
     * Generates a map of academic history records formatted for Select2.
     *
     * @return a map where the key is the academic history ID and the value is a formatted string.
     */
    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> academicHistoryMap = new LinkedHashMap<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                Student student = (Student) StudentService.getById(academicHistory.getIdStudent());
                Subject subject = (Subject) SubjectService.getById(academicHistory.getIdSubject());
                academicHistoryMap.put(
                        academicHistory.getId(),
                        String.format(
                                "%d - %s/%s (%s)",
                                academicHistory.getId(),
                                String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(),
                                        student.getFirstName()),
                                subject.getName(),
                                academicHistory.getState()));
            }
        }
        return academicHistoryMap;
    }

    /**
     * Generates a map of possible states for academic history records formatted for Select2.
     *
     * @return a map where the key and value are both the state string.
     */
    public static Map<String, String> getStateForSelect2() {
        Map<String, String> typeMap = new LinkedHashMap<>();
        for (String type : AcademicHistory.TYPES_STATE) {
            typeMap.put(type, type);
        }
        return typeMap;
    }

    /**
     * Retrieves all academic history records for a specific student.
     *
     * @param idStudent the ID of the student.
     * @return a map where the key is the academic history ID and the value is the academic history record.
     */
    public static Map<Integer, Model> getAllAcademicHistoryFromStudent(int idStudent) {
        Map<Integer, Model> academicHistoryMap = new LinkedHashMap<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                if (idStudent == academicHistory.getIdStudent()) {
                    academicHistoryMap.put(academicHistory.getId(), academicHistory);
                }
            }
        }
        return academicHistoryMap;
    }

    /**
     * Retrieves custom data arrays for a specific student.
     *
     * @param idStudent the ID of the student.
     * @return a list of custom data arrays for the specified student.
     */
    public static List<Object[]> getCustomDataForStudent(int idStudent) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                if (idStudent == academicHistory.getIdStudent()) {
                    Student student = (Student) StudentService.getById(academicHistory.getIdStudent());
                    Subject subject = (Subject) SubjectService.getById(academicHistory.getIdSubject());
                    Object[] rowData = new Object[] {
                            String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(),
                                    student.getFirstName()),
                            String.format("%s - %s", subject.getId(), subject.getName()),
                            academicHistory.getState(),
                            academicHistory.getPartial1(),
                            academicHistory.getPartial2(),
                            academicHistory.getIsPromoted() ? "Si" : "No",
                            academicHistory.getFinalExam(),
                            academicHistory.getGrade()
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    /**
     * Retrieves an academic history record for a specific subject and student.
     *
     * @param idSubject the ID of the subject.
     * @param idStudent the ID of the student.
     * @return the academic history record for the specified subject and student.
     */
    public static AcademicHistory getAcademicHistoryFromSubjectStudent(int idSubject, int idStudent) {
        Map<Integer, Model> allAcademicHistory = AcademicHistoryService.getAllAcademicHistoryFromStudent(idStudent);
        AcademicHistory finalAcademicHistory = null;
        for (Model model : allAcademicHistory.values()) {
            if (model instanceof AcademicHistory academicHistory) {
                if (academicHistory.getIdSubject() == idSubject) {
                    finalAcademicHistory = academicHistory;
                    break;
                }
            }
        }
        return finalAcademicHistory;
    }
}
