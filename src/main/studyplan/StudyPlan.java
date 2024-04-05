package main.studyplan;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import main.common.Model;

public class StudyPlan implements Model {

    // Constants
    public static final String TRANSLATE_NAME = "Plan de Estudio";
    public static final List<String> TYPES_STUDY_PLAN = Arrays.asList("A", "B", "C", "D", "E");

    // Attributes
    private int id;
    private String type;
    private int idCareer;
    private boolean isActive;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Constructors ============================================================

    public StudyPlan() {}

    protected StudyPlan(String type, int idCareer, boolean isActive) {
        this.type = type;
        this.idCareer = idCareer;
        this.isActive = isActive;
        this.save();
    }

    // Setters & Getters =======================================================

    public StudyPlan setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        if (TYPES_STUDY_PLAN.contains(type)) {
            this.type = type;
        } else {
            this.type = "ERROR";
        }
    }

    public String getType() {
        return type;
    }

    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }

    public int getIdCareer() {
        return idCareer;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsActive () {
        return isActive;
    }

    public static Map<Integer, Model> getAll() {
        return all;
    }

    // Methods ================================================================

    protected static void addSerial() {
        serial++;
    }

    // Model interface methods =================================================

    @Override
    public boolean validate() {
        // Validation logic goes here
        return (
            type != null &&
            idCareer != 0
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
        if (this.validate()) {
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
        return new Object[] { type, idCareer, isActive};
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Tipo", "ID Carrera", "Vigente" };
    }

    // Overrides ===============================================================

    @Override
    public String toString() {
        return String.format("""
            %s:
              * Tipo: %s
              * Carrera: %s
              * Vigente: %s
            """,
            TRANSLATE_NAME,
            type != null ? type : "N/A",
            idCareer != 0 ? idCareer : "N/A",
            isActive
        );
    }
}
