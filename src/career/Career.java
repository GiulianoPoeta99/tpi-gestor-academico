package career;

import java.util.LinkedHashMap;
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
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Builders ============================================================

    public Career() {}

    protected Career(String name) {
        this.setName(name);
        this.save();
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

    public static Model getById(int id) {
        return all.get(id);
    }

    public static Map<Integer, Model> getAll() {
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
    public boolean save() {
        if (this.validate()) {
            addSerial();
            this.setId(serial);
            all.put(this.getId(), this);
            return true;
        }
        return false;
    }

    @Override
    public boolean update() {
        if (this.validate()) {
            all.put(this.getId(), this);
            return true;
        }
        return false;
    }

    @Override
    public void delete() {
        all.remove(this.getId(), this);
    }

    @Override
    public Object[] getAttributeValues() {
        return new Object[] { this.getName() }; // Devuelve los valores de los atributos como un arreglo de objetos
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Nombre" }; // Devuelve los nombres de los atributos como un arreglo de cadenas
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
