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

    // Builders ============================================================

    public Subject() {}

    protected Subject(
        String name,
        boolean isOptional,
        int fourMonths,
        int idStudyPlan
    ) {
        this.setName(name);
        this.setIsOptional(isOptional);
        this.setFourMonths(fourMonths);
        this.setIdStudyPlan(idStudyPlan);
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

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Subject setIsOptional(boolean isOptional) {
        this.isOptional = isOptional;
        return this;
    }

    public boolean getIsOptional() {
        return this.isOptional;
    }

    public Subject setFourMonths(int fourMonths) {
        this.fourMonths = fourMonths;
        return this;
    }

    public int getFourMonths() {
        return this.fourMonths;
    }

    public Subject setIdStudyPlan(int idStudyPlan) {
        this.idStudyPlan = idStudyPlan;
        return this;
    }

    public int getIdStudyPlan() {
        return this.idStudyPlan;
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
        new Subject();
    }

    // Implements ==============================================================

    @Override
    public boolean validate() {
        return (
            this.getName() != null &&
            this.getFourMonths() != 0 &&
            this.getIdStudyPlan() != 0
        );
    }

    @Override
    public void save() {
        if (this.validate()) {
            addSerial();
            this.setId(serial);
            all.put(this.getId(), this);
        }
    }

    @Override
    public Object[] getAttributeValues() {
        return new Object[] { this.getName(), this.getIsOptional(), this.getFourMonths(), this.getIdStudyPlan() };
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
              * Name: %s
              * Four Months: %s
            """,
            TRANSLATE_NAME,
            this.getName(), "N/A",
            this.getFourMonths(), "N/A"
        );
    }
}
