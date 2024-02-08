package subject;

import java.util.HashMap;
import java.util.Map;

import common.Model;

public class Subject implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Subject";

    // Attributes
    private int id;
    private String name;
    private boolean isOptional;
    private int fourMonths;
    private int idStudyPlan;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Subject> all = new HashMap<Integer, Subject>();

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

    protected Subject(Subject subject) {
        addSerial();
        subject.setId(serial);
        this.setId(serial);
        all.put(subject.getId(), subject);
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

    public static Subject getById(int id) {
        return all.get(id);
    }

    public static Map<Integer, Subject> getAll() {
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
            new Subject(this);
        }
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
