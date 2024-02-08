package subject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import common.components.CommonComponent;

public class SubjectViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel heading = CommonComponent.heading(24, "Materias");
        components.add(heading);

        return components;
    }
}
