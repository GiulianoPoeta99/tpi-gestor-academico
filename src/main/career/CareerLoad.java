package main.career;

/**
 * The CareerLoad class extends the Career class to provide a method for loading
 * predefined career data into the system. It creates instances of Career with
 * specific names.
 *
 * <p>Methods:</p>
 * <ul>
 *   <li>data() - Loads predefined career data by creating Career instances.</li>
 * </ul>
 *
 * @see Career
 *
 * @version 1.0.0
 * @author Giuliano Ignacio Poeta
 * @since 2024.04.05
 */
public class CareerLoad extends Career {

    /**
     * Loads predefined career data by creating Career instances with specific names.
     */
    public static void data() {
        new Career("Licenciatura en ciencias ambientales");
        new Career("Licenciatura en geología");
        new Career("Ingeniería industrial");
        new Career("Licenciatura en sistemas");
        new Career("Licenciatura en economía");
    }
}
