package main.student;

import java.time.LocalDate;

public class StudentLoad extends Student {
    public static void data() {
        new Student("Carina", "Ballan", LocalDate.of(2001, 6, 10), 1);
        new Student("Rocio", "Olivero Jofre", LocalDate.of(1999, 12, 22), 2);
        new Student("Leonel", "Capriata", LocalDate.of(2000, 4, 28), 3);
        new Student("Giuliano Ignacio", "Poeta", LocalDate.of(1999, 9, 14), 4);
        new Student("Celestina", "Oreste", LocalDate.of(2001, 8, 5), 5);
    }
}
