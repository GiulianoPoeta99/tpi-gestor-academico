package career;

import java.util.HashMap;
import java.util.Map;

import common.Model;

public class Career implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Carrera";

    // Attributes
    private int id;
    private String name;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Career> all = new HashMap<>();

    // Builders ============================================================

    public Career() {}

    protected Career(String name) {
        this.setName(name);
        this.save();
    }

    protected Career(Career career) {
        addSerial();
        career.setId(serial);
        this.setId(serial);
        all.put(career.getId(), career);
    }

    // Setters & Getters =======================================================

    public Career setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public Career setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    // Methods ================================================================

    public static Career getById(int id) {
        return all.get(id);
    }

    public static Map<Integer, Career> getAll() {
        return Career.all;
    }

    protected static void addSerial() {
        serial++;
    }

    public static void loadData() {
        new Career("Tecnicatura en sistemas");
        new Career("Licenciatura en sistemas");
    }

    // Implements ==============================================================

    @Override
    public boolean validate() {
        return (this.getName() != null);
    }

    @Override
    public void save() {
        if (this.validate()) {
            new Career(this);
        }
    }

    // Overrides ===============================================================

    @Override
    public String toString() {
        return String.format("""
            %s:
              * Nombre: %s
            """,
            TRANSLATE_NAME,
            this.getName(), "N/A"
        );
    }
}
