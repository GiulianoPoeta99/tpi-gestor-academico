package main.student;

import main.career.Career;
import main.career.CareerService;
import main.common.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The StudentService class provides various methods to handle student-related operations.
 * It includes methods for retrieving custom data and student details, as well as
 * formatting student information for display.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>getCustomColumns() - Returns an array of custom column names for students.</li>
 *   <li>getCustomData() - Retrieves a list of custom student data for display.</li>
 *   <li>getById(int id) - Retrieves a student by their ID.</li>
 *   <li>getIDNameForSelect2() - Retrieves a map of student IDs and names for selection purposes.</li>
 *   <li>getCustomDataForCareer(int idCareer) - Retrieves custom student data filtered by career ID.</li>
 * </ul>
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.03.12
 */
public class StudentService extends Student {
    /**
     * Returns an array of custom column names for students.
     *
     * @return An array of column names.
     */
    public static String[] getCustomColumns() {
        return new String[] { "Legajo", "Nombre completo", "Fecha de nacimiento", "Carrera" };
    }

    /**
     * Retrieves a list of custom student data for display.
     *
     * @return A list of custom student data arrays.
     */
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                Model careerModel = CareerService.getById(student.getIdCareer());
                if (careerModel != null) {
                    if (careerModel instanceof Career career) {

                        LocalDate birthDate = student.getBirthDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String formattedDate = birthDate.format(formatter);
                        Object[] rowData = new Object[] {
                                student.getDossierNumber(),
                                String.format("%s %s", student.getLastName(), student.getFirstName()),
                                formattedDate,
                                career.getName()
                        };
                        customData.add(rowData);
                    }
                } else {
                    Object[] rowData = new Object[] {
                            student.getDossierNumber(),
                            String.format("%s %s", student.getLastName(), student.getFirstName()),
                            student.getBirthDate(),
                            "-"
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The student model with the specified ID, or null if not found.
     */
    public static Model getById(int id) {
        return all.get(id);
    }

    /**
     * Retrieves a map of student IDs and names for selection purposes.
     *
     * @return A map where the key is the student ID and the value is their name.
     */
    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> studentMap = new LinkedHashMap<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                String name = String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(),
                        student.getFirstName());
                studentMap.put(student.getId(), name);
            }
        }
        return studentMap;
    }

    /**
     * Retrieves custom student data filtered by career ID.
     *
     * @param idCareer The ID of the career to filter students by.
     * @return A list of custom student data arrays filtered by career.
     */
    public static List<Object[]> getCustomDataForCareer(int idCareer) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                if (idCareer == student.getIdCareer()) {
                    Model careerModel = CareerService.getById(student.getIdCareer());
                    if (careerModel != null) {
                        if (careerModel instanceof Career career) {

                            LocalDate birthDate = student.getBirthDate();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String formattedDate = birthDate.format(formatter);
                            Object[] rowData = new Object[] {
                                    student.getDossierNumber(),
                                    String.format("%s %s", student.getLastName(), student.getFirstName()),
                                    formattedDate,
                                    career.getName()
                            };
                            customData.add(rowData);
                        }
                    }
                }
            }
        }
        return customData;
    }
}
