package student;

import java.util.LinkedHashMap;
import java.util.Map;
import java.time.LocalDate;

import common.Model;

public class Student implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Estudiante";

    // Attributes
    private int id;
    private String dossierNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int idCareer;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    // Builders ============================================================

    public Student() {}

    protected Student(
            String firstName,
            String lastName,
            LocalDate birthDate,
            int idCareer
    ) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDate(birthDate);
        this.setIdCareer(idCareer);
        this.save();
    }

    // Setters & Getters =======================================================

    public Student setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return this.id;
    }

    public Student setDossierNumber(String dossierNumber) {
        this.dossierNumber = dossierNumber;
        return this;
    }

    public String getDossierNumber() {
        return this.dossierNumber;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Student setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Student setIdCareer(int idCareer) {
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
        new Student("Giuliano", "Poeta", LocalDate.of(1999, 9, 14), 1);
    }

    // Implements ==============================================================

    @Override
    public boolean validate() {
        return (
            this.getFirstName() != null &&
            this.getLastName() != null &&
            this.getBirthDate() != null
        );
    }

    @Override
    public boolean save() {
        if (this.validate()) {
            addSerial();
            this.setId(serial);
            this.setDossierNumber(String.format("%04d", serial));
            all.put(this.getId(), this);
            return true;
        }
        return false;
    }

    @Override
    public Object[] getAttributeValues() {
        return new Object[] { this.getDossierNumber(), this.getFirstName(), this.getLastName(), this.getBirthDate(), this.getIdCareer()}; // Devuelve los valores de los atributos como un arreglo de objetos
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Legajo", "Nombre", "Apellido", "Fecha de nacimiento", "ID Carrera" }; // Devuelve los nombres de los atributos como un arreglo de cadenas
    }

    // Overrides ===============================================================

    @Override
    public String toString() {
        return String.format("""
            %s:
              * Legajo: %s
              * Nombre: %s
              * Apellido: %s
              * Fecha de Nacimiento: %s
            """,
            TRANSLATE_NAME,
            this.getDossierNumber(), "N/A",
            this.getFirstName(), "N/A",
            this.getLastName(), "N/A",
            this.getBirthDate(), "N/A"
        );
    }
}
