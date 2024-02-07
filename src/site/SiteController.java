package site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import common.Controller;
import site.SiteViews;

/**
 * Controller for site management.
 * This controller implements the Controller interface.
 * It provides methods to manage site information such as creating, updating, viewing, and deleting.
 *
 * @author Giuliano Ignacio Poeta
 */
public class SiteController implements Controller {

    /**
     * Main method of the site controller.
     * This method is the main entry point for site management.
     */
    public void index() {
        ArrayList<String> redirections = new ArrayList<>();
        redirections.add("Carreras");
        redirections.add("Planes de Estudio");
        redirections.add("Materias");
        redirections.add("Alumnos");
        SiteViews.index(redirections);
    }

    /**
     * Method to create a new site.
     */
    public void create() {
        // Implementation of the create method
    }

    /**
     * Method to update an existing site.
     */
    public void update() {
        // Implementation of the update method
    }

    /**
     * Method to view site information.
     */
    public void view() {
        // Implementation of the view method
    }

    /**
     * Method to delete a site.
     */
    public void delete() {
        // Implementation of the delete method
    }
}
