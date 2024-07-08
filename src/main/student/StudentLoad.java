package main.student;

import main.career.Career;

import java.time.LocalDate;

/**
 * The StudentLoad class extends the Student class to provide a method for loading
 * predefined Student data into the system. It creates instances of Student with
 * specific names nad more data.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>data() - Loads predefined student data by creating Student instances.</li>
 * </ul>
 *
 * @see Student
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.04.05
 */
public class StudentLoad extends Student {
    /**
     * Loads predefined student data by creating Student instances with specific names and more data.
     */
    public static void data() {
        new Student("Carina", "Ballan", LocalDate.of(2001, 6, 10), 1);
        new Student("Rocio", "Olivero Jofre", LocalDate.of(1999, 12, 22), 2);
        new Student("Leonel", "Capriata", LocalDate.of(2000, 4, 28), 3);
        new Student("Giuliano Ignacio", "Poeta", LocalDate.of(1999, 9, 14), 4);
        new Student("Celestina", "Oreste", LocalDate.of(2001, 8, 5), 5);
    }
}
