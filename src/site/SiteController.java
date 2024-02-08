package site;

import javax.swing.*;
import java.util.ArrayList;

import common.Controller;

/**
 * Controller for site management.
 * This controller implements the Controller interface.
 * It provides methods to manage site information such as creating, updating, viewing, and deleting.
 *
 * @author Giuliano Ignacio Poeta
 */
public class SiteController implements Controller {

    private static final SiteController instance = new SiteController(); // Instancia única del controlador

    // Constructor privado para evitar la creación de instancias externas
    private SiteController() {
    }

    /**
     * Método estático para obtener la instancia única del controlador.
     *
     * @return La instancia única del controlador.
     */
    public static SiteController getInstance() {
        return instance;
    }

    /**
     * Main method of the site controller.
     * This method is the main entry point for site management.
     */
    public void principal() {
        // Crear un array list de redirecciones
        ArrayList<String> redirections = new ArrayList<>();
        redirections.add("Inicio");
        redirections.add("Carreras");
        redirections.add("Planes de Estudio");
        redirections.add("Materias");
        redirections.add("Alumnos");

        // Inicializar la GUI utilizando SwingUtilities.invokeLater()
        SwingUtilities.invokeLater(() -> {
            // Invocar el método layout de SiteViews para configurar la interfaz gráfica
            SiteViews.layout(redirections);

            // Mostrar la vista de inicio (index)
            index();
        });
    }

    public void index() {
        render(SiteViews::index);
    }

    public void create() {
        index();
    }

    public void update() {
        index();
    }

    public void view() {
        index();
    }

    public void delete() {
        index();
    }
}
