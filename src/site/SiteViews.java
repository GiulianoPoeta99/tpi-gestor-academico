package site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.components.LayOut;
import common.components.Text;

/**
 * Class responsible for managing the site views.
 * This class handles the creation and configuration of GUI components.
 */
public class SiteViews {

    public static void layout(Map<String, Runnable> redirections) {
        JFrame frame = LayOut.mainFrame();
        JPanel topPanel = LayOut.topPanel();
        JPanel sidePanel = LayOut.sidePanel(redirections);
        JPanel contentPanel = LayOut.contentPanel();

        frame.setLayout(new BorderLayout());
        frame.add(sidePanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel title = Text.h1("Inicio");
        components.add(title);

        return components;
    }
}
