package main.academichistory;

import main.common.Model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AcademicHistory implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Historia academica";
    public static final List<String> TYPES_STATE = Arrays.asList("Aprobado", "Desaprobado", "Cursando", "Promocionado");

    // Attributes
    private int id;
    private int idStudent;
    private int idSubject;
    private String state;
    private int partial1;
    private int partial2;
    private boolean isPromoted;
    private int finalExam;
    private int grade;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Constructors ==========================================================

    public AcademicHistory() {}

    protected AcademicHistory(int idStudent, int idSubject, String state, int partial1, int partial2, boolean isPromoted, int finalExam, int grade) {
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

    // Setters & Getters ======================================================

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getIdSubject() {
        return this.idSubject;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdStudent() {
        return this.idStudent;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setPartial1(int partial1) {
        this.partial1 = partial1;
    }

    public int getPartial1() {
        return partial1;
    }
    public void setPartial2(int partial2) {
        this.partial2 = partial2;
    }

    public int getPartial2() {
        return partial2;
    }

    public void setIsPromoted(boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    public boolean getIsPromoted() {
        return isPromoted;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public static Map<Integer, Model> getAll() {
        return all;
    }

    // Methods ================================================================

    protected static void addSerial() {
        serial++;
    }

    public static void loadData() {
        new AcademicHistory();
    }

    // Model interface methods =================================================

    @Override
    public boolean validate() {
        return (
            idStudent != 0
            && idSubject != 0
            && state != null
        );
    }

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

    @Override
    public boolean update() {
        if (validate()) {
            all.put(id, this);
            return true;
        }
        return false;
    }

    @Override
    public void delete() {
        all.remove(id, this);
    }

    @Override
    public Object[] getAttributeValues() {
        return new Object[] { idStudent, idSubject, state, partial1, partial2, isPromoted, finalExam, grade };
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "ID estudiante", "ID materia", "Estado", "Parcial 1", "Parcial 2", "Promoción", "Final", "Nota" };
    }

    // Overrides ===============================================================

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
            grade
        );
    }
}
