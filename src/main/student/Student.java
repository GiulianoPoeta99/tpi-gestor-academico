package main.student;

import java.util.LinkedHashMap;
import java.util.Map;
import java.time.LocalDate;

import main.common.Model;

/**
 * The Student class represents a student within the system.
 * It includes attributes such as ID, dossier number, first name,
 * last name, birth date, and career ID, and provides methods to
 * manage student data, including saving, updating, and deleting instances.
 * Implements the Model interface for consistent data handling.
 *
 * <p>Constants:</p>
 * <ul>
 *   <li>TRANSLATE_NAME - A constant for the translated name of the student.</li>
 * </ul>
 *
 * <p>Static Attributes:</p>
 * <ul>
 *   <li>serial - A counter for generating unique IDs.</li>
 *   <li>all - A map to store all student instances by their ID.</li>
 * </ul>
 *
 * <p>Attributes:</p>
 * <ul>
 *   <li>id - The unique identifier for the student.</li>
 *   <li>dossierNumber - The dossier number of the student.</li>
 *   <li>firstName - The first name of the student.</li>
 *   <li>lastName - The last name of the student.</li>
 *   <li>birthDate - The birth date of the student.</li>
 *   <li>idCareer - The ID of the student's career.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *   <li>Student() - Default constructor.</li>
 *   <li>Student(String firstName, String lastName, LocalDate birthDate, int idCareer) - Protected constructor to create a student with specified details and save it.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>setId(int id) - Sets the ID of the student.</li>
 *   <li>getId() - Gets the ID of the student.</li>
 *   <li>setDossierNumber(String dossierNumber) - Sets the dossier number of the student.</li>
 *   <li>getDossierNumber() - Gets the dossier number of the student.</li>
 *   <li>setFirstName(String firstName) - Sets the first name of the student.</li>
 *   <li>getFirstName() - Gets the first name of the student.</li>
 *   <li>setLastName(String lastName) - Sets the last name of the student.</li>
 *   <li>getLastName() - Gets the last name of the student.</li>
 *   <li>setBirthDate(LocalDate birthDate) - Sets the birth date of the student.</li>
 *   <li>getBirthDate() - Gets the birth date of the student.</li>
 *   <li>setIdCareer(int idCareer) - Sets the ID of the student's career.</li>
 *   <li>getIdCareer() - Gets the ID of the student's career.</li>
 *   <li>getAll() - Retrieves all student instances.</li>
 *   <li>addSerial() - Increments the serial counter.</li>
 *   <li>validate() - Validates the student instance.</li>
 *   <li>save() - Saves the student instance if valid.</li>
 *   <li>update() - Updates the student instance if valid.</li>
 *   <li>delete() - Deletes the student instance.</li>
 *   <li>getAttributeValues() - Gets the attribute values of the student.</li>
 *   <li>getAttributeNames() - Gets the attribute names of the student.</li>
 *   <li>toString() - Returns a string representation of the student.</li>
 * </ul>
 *
 * @see Model
 * @see LinkedHashMap
 * @see Map
 * @see LocalDate
 * @see String
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2023.12.05
 */
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

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Protected constructor to create a student with specified details and save it.
     *
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @param birthDate The birth date of the student.
     * @param idCareer The ID of the student's career.
     */
    protected Student(String firstName, String lastName, LocalDate birthDate, int idCareer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.idCareer = idCareer;
        this.save();
    }

    /**
     * Sets the ID of the student.
     *
     * @param id The ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the student.
     *
     * @return The ID of the student.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the dossier number of the student.
     *
     * @param dossierNumber The dossier number to set.
     */
    public void setDossierNumber(String dossierNumber) {
        this.dossierNumber = dossierNumber;
    }

    /**
     * Gets the dossier number of the student.
     *
     * @return The dossier number of the student.
     */
    public String getDossierNumber() {
        return this.dossierNumber;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the birth date of the student.
     *
     * @param birthDate The birth date to set.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the birth date of the student.
     *
     * @return The birth date of the student.
     */
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    /**
     * Sets the ID of the student's career.
     *
     * @param idCareer The career ID to set.
     */
    public void setIdCareer(int idCareer) {
        this.idCareer = idCareer;
    }

    /**
     * Gets the ID of the student's career.
     *
     * @return The career ID of the student.
     */
    public int getIdCareer() {
        return this.idCareer;
    }

    /**
     * Retrieves all student instances.
     *
     * @return A map of all student instances.
     */
    public static Map<Integer, Model> getAll() {
        return all;
    }

    /**
     * Increments the serial counter.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Validates the student instance.
     *
     * @return True if the student details are not null, otherwise false.
     */
    @Override
    public boolean validate() {
        return (this.firstName != null &&
                this.lastName != null &&
                this.birthDate != null);
    }

    /**
     * Saves the student instance if valid.
     *
     * @return True if the student instance was successfully saved, otherwise false.
     */
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

    /**
     * Updates the student instance if valid.
     *
     * @return True if the student instance was successfully updated, otherwise false.
     */
    @Override
    public boolean update() {
        if (validate()) {
            all.put(id, this);
            return true;
        }
        return false;
    }

    /**
     * Deletes the student instance.
     */
    @Override
    public void delete() {
        all.remove(id, this);
    }

    /**
     * Gets the attribute values of the student.
     *
     * @return An array of attribute values.
     */
    @Override
    public Object[] getAttributeValues() {
        return new Object[] { dossierNumber, firstName, lastName, birthDate, idCareer };
    }

    /**
     * Gets the attribute names of the student.
     *
     * @return An array of attribute names.
     */
    @Override
    public String[] getAttributeNames() {
        return new String[] { "Legajo", "Nombre", "Apellido", "Fecha de nacimiento", "ID Carrera" };
    }

    /**
     * Returns a string representation of the student.
     *
     * @return A string representation of the student.
     */
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
