package studyplan;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import common.Model;

public class StudyPlan implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Plan de Estudio";
    private static final List<String> TYPES_STUDY_PLAN = Arrays.asList("A", "B", "C", "D", "E");

    // Attributes
    private int id;
    private String type;
    private int idCareer;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Builders ============================================================

    public StudyPlan() {}

    protected StudyPlan(String type) {
        this.setType(type);
        this.save();
    }

    protected StudyPlan(StudyPlan studyPlan) {
        addSerial();
        studyPlan.setId(serial);
        all.put(studyPlan.getId(), studyPlan);
    }

    // Setters & Getters =======================================================

    public StudyPlan setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public StudyPlan setType(String type) {
        // Check if the new type is in the list before assigning it
        if (TYPES_STUDY_PLAN.contains(type)) {
            this.type = type;
        } else {
            this.type = "ERROR";
        }
        return this;
    }

    public String getType() {
        return this.type;
    }

    public StudyPlan setIdCareer(int idCareer) {
        this.idCareer = idCareer;
        return this;
    }

    public int getIdCareer() {
        return this.idCareer;
    }

    // Methods ================================================================

    public static Model getById(int id) {
        return all.get(id);
    }

    public static Map<Integer, Model> getAll() {
        return all;
    }

    protected static void addSerial() {
        serial++;
    }

    public static void loadData() {
        new StudyPlan();
    }

    // Implements ==============================================================

    @Override
    public boolean validate() {
        // Validation logic goes here
        return (
            this.getType() != null &&
            this.getIdCareer() != 0
        );
    }

    @Override
    public void save() {
        if (this.validate()) {
            new StudyPlan(this);
        }
    }

    @Override
    public Object[] getAttributeValues() {
        return new Object[] { this.getType(), this.getIdCareer() }; // Devuelve los valores de los atributos como un arreglo de objetos
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Tipo", "ID Carrera" }; // Devuelve los nombres de los atributos como un arreglo de cadenas
    }

    // Overrides ===============================================================

    @Override
    public String toString() {
        return String.format("""
            %s:
              * Tipo: %s
            """,
            TRANSLATE_NAME,
            this.getType(), "N/A"
        );
    }
}
