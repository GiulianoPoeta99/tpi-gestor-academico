package student;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

import common.Model;

/**
 * Represents a student entity.
 * This class implements the Model interface.
 * It provides methods to manage student information.
 *
 * @author Giuliano Ignacio Poeta
 */
public class Student implements Model {
    // Constants
    public static final String TRANSLATE_NAME = "Estudiante";

    // Atributes
    private int id;
    private String dossierNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int idCareer;

    // Static attributes
    protected static int serial = 0;
    protected static Map<Integer, Student> all = new HashMap<Integer, Student>();

    // Constructors ============================================================

    /**
     * Default constructor for the Student class.
     */
    public Student() {}

    /**
     * Parameterized constructor for the Student class.
     * Initializes a new student with the provided attributes and saves it.
     *
     * @param dossierNumber The dossier number of the student.
     * @param firstName     The first name of the student.
     * @param lastName      The last name of the student.
     * @param birthDate      The birth date of the student.
     * @param idCareer       The career ID of the student.
     */
    protected Student(
            String dossierNumber,
            String firstName,
            String lastName,
            LocalDate birthDate,
            int idCareer
    ) {
        this.setDossierNumber(dossierNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDate(birthDate);
        this.setIdCareer(idCareer);
        this.save();
    }

    /**
     * Copy constructor for the Student class.
     * Initializes a new student with the same attributes as the given student.
     *
     * @param student The student to copy.
     */
    protected Student(Student student) {
        addSerial();
        student.setId(serial);
        all.put(student.getId(), student);
    }

    // Setters & Getters =======================================================

    /**
     * Sets the ID of the student.
     *
     * @param id The ID to set.
     * @return This student instance.
     */
    public Student setId(int id) {
        this.id = id;
        return this;
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
     * @return This student instance.
     */
    public Student setDossierNumber(String dossierNumber) {
        this.dossierNumber = dossierNumber;
        return this;
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
     * @return This student instance.
     */
    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
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
     * @return This student instance.
     */
    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
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
     * @return This student instance.
     */
    public Student setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
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
     * Sets the career ID for the student.
     * 
     * @param idCareer The career ID.
     * @return The updated Student object.
     */
    public Student setIdCareer(int idCareer) {
        this.idCareer = idCareer;
        return this;
    }

    /**
     * Gets the career ID of the student.
     * 
     * @return The career ID.
     */
    public int getIdCareer() {
        return this.idCareer;
    }

    // Methods ================================================================

    /**
     * Retrieves a student by ID from the collection of all students.
     *
     * @param id The ID of the student to retrieve.
     * @return The student with the specified ID, or null if not found.
     */
    public static Student getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a mapping of all students where the key is the student ID.
     *
     * @return A mapping of all students.
     */
    public static Map<Integer, Student> getAll() {
        return all;
    }

    /**
     * Increments the serial number for student instances.
     * This method is used internally.
     */
    protected static void addSerial() {
        serial++;
    }

    /**
     * Loads initial data for testing purposes.
     * This method initializes student instances with sample data.
     * The students are then added to the collection of all students.
     */
    public static void loadData() {
        new Student("0001", "Giuliano", "Poeta", LocalDate.of(1999, 9, 14), 1);
    }

    // Implements ==============================================================
    
    /**
     * Validates the student's information.
     * This method is part of the Model interface.
     *
     * @return true if the student is valid, false otherwise.
     */
    @Override
    public boolean validate() {
        return (
            this.getDossierNumber() != null &&
            this.getFirstName() != null &&
            this.getLastName() != null &&
            this.getBirthDate() != null
        );
    }

    /**
     * Saves the student if it passes validation.
     * This method is part of the Model interface.
     */
    @Override
    public void save() {
        if (this.validate()) {
            new Student(this);
        }
    }

    // Overrides ===============================================================

    /**
     * Generates a string representation of the student.
     *
     * @return A formatted string with student information.
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
            this.getDossierNumber(), "N/A",
            this.getFirstName(), "N/A",
            this.getLastName(), "N/A",
            this.getBirthDate(), "N/A"
        );
    }
}
