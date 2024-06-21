package main.academichistory;

import main.common.Model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The AcademicHistory class represents the academic history of a student.
 * It includes attributes such as student ID, subject ID, state, grades, and promotion status,
 * and provides methods to manage academic history data, including saving, updating, and deleting instances.
 * Implements the Model interface for consistent data handling.
 *
 * <p><b>Constants:</b></p>
 * <ul>
 *   <li>TRANSLATE_NAME - A constant for the translated name of the academic history.</li>
 *   <li>TYPES_STATE - A list of possible states for the academic history.</li>
 * </ul>
 *
 * <p><b>Static Attributes:</b></p>
 * <ul>
 *   <li>serial - A counter for generating unique IDs.</li>
 *   <li>all - A map to store all academic history instances by their ID.</li>
 * </ul>
 *
 * <p><b>Attributes:</b></p>
 * <ul>
 *   <li>id - The unique identifier for the academic history.</li>
 *   <li>idStudent - The identifier for the student.</li>
 *   <li>idSubject - The identifier for the subject.</li>
 *   <li>state - The current state of the academic history.</li>
 *   <li>partial1 - The grade of the first partial exam.</li>
 *   <li>partial2 - The grade of the second partial exam.</li>
 *   <li>isPromoted - Indicates whether the student is promoted.</li>
 *   <li>finalExam - The grade of the final exam.</li>
 *   <li>grade - The final grade.</li>
 * </ul>
 *
 * <p><b>Constructor:</b></p>
 * <ul>
 *   <li>AcademicHistory() - Default constructor.</li>
 *   <li>AcademicHistory(int idStudent, int idSubject, String state, int partial1, int partial2,
 *   boolean isPromoted, int finalExam, int grade) - Protected constructor to create an academic history with specified attributes and save it.</li>
 * </ul>
 *
 * <p><b>Methods:</b></p>
 * <ul>
 *   <li>setId(int id) - Sets the ID of the academic history.</li>
 *   <li>getId() - Gets the ID of the academic history.</li>
 *   <li>setIdSubject(int idSubject) - Sets the subject ID of the academic history.</li>
 *   <li>getIdSubject() - Gets the subject ID of the academic history.</li>
 *   <li>setIdStudent(int idStudent) - Sets the student ID of the academic history.</li>
 *   <li>getIdStudent() - Gets the student ID of the academic history.</li>
 *   <li>setState(String state) - Sets the state of the academic history.</li>
 *   <li>getState() - Gets the state of the academic history.</li>
 *   <li>setPartial1(int partial1) - Sets the grade of the first partial exam.</li>
 *   <li>getPartial1() - Gets the grade of the first partial exam.</li>
 *   <li>setPartial2(int partial2) - Sets the grade of the second partial exam.</li>
 *   <li>getPartial2() - Gets the grade of the second partial exam.</li>
 *   <li>setIsPromoted(boolean isPromoted) - Sets the promotion status.</li>
 *   <li>getIsPromoted() - Gets the promotion status.</li>
 *   <li>setFinalExam(int finalExam) - Sets the grade of the final exam.</li>
 *   <li>getFinalExam() - Gets the grade of the final exam.</li>
 *   <li>setGrade(int grade) - Sets the final grade.</li>
 *   <li>getGrade() - Gets the final grade.</li>
 *   <li>getAll() - Retrieves all academic history instances.</li>
 *   <li>addSerial() - Increments the serial counter.</li>
 *   <li>validate() - Validates the academic history instance.</li>
 *   <li>save() - Saves the academic history instance if valid.</li>
 *   <li>update() - Updates the academic history instance if valid.</li>
 *   <li>delete() - Deletes the academic history instance.</li>
 *   <li>getAttributeValues() - Gets the attribute values of the academic history.</li>
 *   <li>getAttributeNames() - Gets the attribute names of the academic history.</li>
 *   <li>toString() - Returns a string representation of the academic history.</li>
 * </ul>
 *
 * @see Model
 * @see Arrays
 * @see LinkedHashMap
 * @see List
 * @see Map
 * @see String
 * @see Integer
 * @see Boolean
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.04.03
 */
public class AcademicHistory implements Model {
    public static final String TRANSLATE_NAME = "Historia academica";
    public static final List<String> TYPES_STATE = Arrays.asList("Aprobado", "Desaprobado", "Cursando", "Promocionado",
            "Regularizado");
    private int id;
    private int idStudent;
    private int idSubject;
    private String state;
    private int partial1;
    private int partial2;
    private boolean isPromoted;
    private int finalExam;
    private int grade;
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    /**
     * Default constructor.
     */
    public AcademicHistory() {
    }

    /**
     * Protected constructor to create an AcademicHistory with specified attributes.
     *
     * @param idStudent The ID of the student.
     * @param idSubject The ID of the subject.
     * @param state The state of the academic history.
     * @param partial1 The grade of the first partial exam.
     * @param partial2 The grade of the second partial exam.
     * @param isPromoted The promotion status.
     * @param finalExam The grade of the final exam.
     * @param grade The final grade.
     */
    protected AcademicHistory(int idStudent, int idSubject, String state, int partial1, int partial2,
                              boolean isPromoted, int finalExam, int grade) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.state = state;
        this.partial1 = partial1;
        this.partial2 = partial2;
        this.isPromoted = isPromoted;
        this.finalExam = finalExam;
        this.grade = grade;
        save();
    }

    /**
     * Sets the ID of the academic history.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the academic history.
     *
     * @return The ID of the academic history.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the subject ID of the academic history.
     *
     * @param idSubject The subject ID to set.
     */
    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    /**
     * Gets the subject ID of the academic history.
     *
     * @return The subject ID of the academic history.
     */
    public int getIdSubject() {
        return this.idSubject;
    }

    /**
     * Sets the student ID of the academic history.
     *
     * @param idStudent The student ID to set.
     */
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    /**
     * Gets the student ID of the academic history.
     *
     * @return The student ID of the academic history.
     */
    public int getIdStudent() {
        return this.idStudent;
    }

    /**
     * Sets the state of the academic history.
     *
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the state of the academic history.
     *
     * @return The state of the academic history.
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the grade of the first partial exam.
     *
     * @param partial1 The grade to set.
     */
    public void setPartial1(int partial1) {
        this.partial1 = partial1;
    }

    /**
     * Gets the grade of the first partial exam.
     *
     * @return The grade of the first partial exam.
     */
    public int getPartial1() {
        return partial1;
    }

    /**
     * Sets the grade of the second partial exam.
     *
     * @param partial2 The grade to set.
     */
    public void setPartial2(int partial2) {
        this.partial2 = partial2;
    }

    /**
     * Gets the grade of the second partial exam.
     *
     * @return The grade of the second partial exam.
     */
    public int getPartial2() {
        return partial2;
    }

    /**
     * Sets the promotion status.
     *
     * @param isPromoted The promotion status to set.
     */
    public void setIsPromoted(boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    /**
     * Gets the promotion status.
     *
     * @return The promotion status.
     */
    public boolean getIsPromoted() {
        return isPromoted;
    }

    /**
     * Sets the grade of the final exam.
     *
     * @param finalExam The grade to set.
     */
    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    /**
     * Gets the grade of the final exam.
     *
     * @return The grade of the final exam.
     */
    public int getFinalExam() {
        return finalExam;
    }

    /**
     * Sets the final grade.
     *
     * @param grade The final grade to set.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Gets the final grade.
     *
     * @return The final grade.
     */
    public int getGrade() {
        return this.grade;
    }

    /**
     * Retrieves all academic history instances.
     *
     * @return A map of all academic history instances.
     */
    public static Map<Integer, Model> getAll() {
        return all;
    }

    /**
     * Increments the serial counter.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Validates the academic history instance.
     *
     * @return true if the instance is valid, false otherwise.
     */
    @Override
    public boolean validate() {
        return (idStudent != 0
                && idSubject != 0
                && state != null);
    }

    /**
     * Saves the academic history instance if valid.
     *
     * @return true if the instance is saved successfully, false otherwise.
     */
    @Override
    public boolean save() {
        if (validate()) {
            addSerial();
            id = serial;
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Updates the academic history instance if valid.
     *
     * @return true if the instance is updated successfully, false otherwise.
     */
    @Override
    public boolean update() {
        if (validate()) {
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Deletes the academic history instance.
     */
    @Override
    public void delete() {
        all.remove(id, this);
    }

    /**
     * Gets the attribute values of the academic history.
     *
     * @return An array of attribute values.
     */
    @Override
    public Object[] getAttributeValues() {
        return new Object[] { idStudent, idSubject, state, partial1, partial2, isPromoted, finalExam, grade };
    }

    /**
     * Gets the attribute names of the academic history.
     *
     * @return An array of attribute names.
     */
    @Override
    public String[] getAttributeNames() {
        return new String[] { "ID estudiante", "ID materia", "Estado", "Parcial 1", "Parcial 2", "Promoción", "Final",
                "Nota" };
    }

    /**
     * Returns a string representation of the academic history.
     *
     * @return A string representing the academic history.
     */
    @Override
    public String toString() {
        return String.format("""
                %s
                  * Estudiante: %d
                  * Materia: %d
                  * Estado: %s
                  * Parcial 1: %d
                  * Parcial 2: %d
                  * Promoción: %s
                  * Final: %d
                  * Nota: %d
                """,
                TRANSLATE_NAME,
                idStudent,
                idSubject,
                state != null ? state : "-",
                partial1,
                partial2,
                isPromoted,
                finalExam,
                grade);
    }
}
