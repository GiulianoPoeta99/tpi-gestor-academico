package main.student;

import java.util.LinkedHashMap;
import java.util.Map;
import java.time.LocalDate;

import main.common.Model;

public class Student implements Model {

    public static final String TRANSLATE_NAME = "Estudiante";

    private int id;
    private String dossierNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int idCareer;

    protected static int serial = 0;
    protected static Map<Integer, Model> all = new LinkedHashMap<>();

    public Student() {
    }

    protected Student(String firstName, String lastName, LocalDate birthDate, int idCareer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.idCareer = idCareer;
        this.save();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDossierNumber(String dossierNumber) {
        this.dossierNumber = dossierNumber;
    }

    public String getDossierNumber() {
        return this.dossierNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }

    public int getIdCareer() {
        return this.idCareer;
    }

    public static Map<Integer, Model> getAll() {
        return all;
    }

    protected static void addSerial() {
        serial++;
    }

    @Override
    public boolean validate() {
        return (this.firstName != null &&
                this.lastName != null &&
                this.birthDate != null);
    }

    @Override
    public boolean save() {
        if (this.validate()) {
            addSerial();
            id = serial;
            dossierNumber = String.format("%04d", serial);
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
        return new Object[] { dossierNumber, firstName, lastName, birthDate, idCareer };
    }

    @Override
    public String[] getAttributeNames() {
        return new String[] { "Legajo", "Nombre", "Apellido", "Fecha de nacimiento", "ID Carrera" };
    }

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
                this.getDossierNumber(),
                this.getFirstName(),
                this.getLastName(),
                this.getBirthDate().toString());
    }
}
