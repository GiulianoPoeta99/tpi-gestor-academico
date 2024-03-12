package subject;

import java.util.LinkedHashMap;
import java.util.Map;

import common.Model;

public class Subject implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Materia";

    // Attributes
    private int id;
    private String name;
    private boolean isOptional;
    private int fourMonths;
    private int idStudyPlan;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Constructors ==========================================================

    public Subject() {}

    protected Subject(
        String name,
        boolean isOptional,
        int fourMonths,
        int idStudyPlan
    ) {
        this.name = name;
        this.isOptional = isOptional;
        this.fourMonths = fourMonths;
        this.idStudyPlan = idStudyPlan;
        this.save();
    }

    // Setters & Getters =======================================================

    public Subject setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIsOptional(boolean isOptional) {
        this.isOptional = isOptional;
    }

    public boolean getIsOptional() {
        return this.isOptional;
    }

    public void setFourMonths(int fourMonths) {
        this.fourMonths = fourMonths;
    }

    public int getFourMonths() {
        return this.fourMonths;
    }

    public void setIdStudyPlan(int idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
    }

    public int getIdStudyPlan() {
        return this.idStudyPlan;
    }

    public static Map<Integer, Model> getAll() {
        return all;
    }

    // Methods ================================================================

    protected static void addSerial() {
        serial++;
    }

    public static void loadData() {
        new Subject("Expresion de problemas y algoritmos", true,1,1);
        new Subject("Elementos de informatica", true,1,1);
        new Subject("Analisis matematico", true,1,1);
        new Subject("Expresion de problemas y algoritmos", true,1,2);
        new Subject("Elementos de informatica", true,1,2);
        new Subject("Analisis matematico", true,1,2);
    }

    // Model interface methods =================================================

    @Override
    public boolean validate() {
        return (
            name != null &&
            fourMonths != 0 &&
            idStudyPlan != 0
        );
    }

    @Override
    public boolean save() {
        if (this.validate()) {
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
        return new Object[] { name, isOptional, fourMonths, idStudyPlan };
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Nombre", "Opcional", "Cuatrimestre", "ID Plan de studio" };
    }

    // Overrides ===============================================================

    @Override
    public String toString() {
        return String.format("""
            %s:
              * Nombre: %s
              * Cuatrimestre: %d
              * ID plan de estudio: %s
            """,
            TRANSLATE_NAME,
            name,
            fourMonths,
            idStudyPlan
        );
    }
}
