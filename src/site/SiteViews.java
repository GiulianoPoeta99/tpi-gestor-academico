package site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import common.components.LayOutComponent;

/**
 * Class responsible for managing the site views.
 * This class handles the creation and configuration of GUI components.
 */
public class SiteViews {

    public static void index(ArrayList<String> redirections) {
        JFrame frame = LayOutComponent.mainFrame();
        JPanel topPanel = LayOutComponent.topPanel();
        JPanel sidePanel = LayOutComponent.sidePanel(redirections);
        JPanel contentPanel = LayOutComponent.contentPanel();

        frame.setLayout(new BorderLayout());
        frame.add(sidePanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
