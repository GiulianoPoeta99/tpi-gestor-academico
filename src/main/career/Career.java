package main.career;

import java.util.LinkedHashMap;
import java.util.Map;

import main.common.Model;

public class Career implements Model {

    // Constants
    public static final String TRANSLATE_NAME = "Carrera";

    // Attributes
    private int id;
    private String name;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Constructors ==========================================================
    
    public Career() {}

    protected Career(String name) {
        this.name = name;
        save();
    }

    // Setters & Getters ======================================================

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
        return name != null;
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
        return new Object[] { name };
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Nombre" };
    }

    // Overrides ===============================================================

    @Override
    public String toString() {
        return String.format("""
            %s
              * Nombre: %s
            """,
            TRANSLATE_NAME,
            name != null ? name : "N/A"
        );
    }
}
