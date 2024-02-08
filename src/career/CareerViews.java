package career;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import common.components.CommonComponent;

public class CareerViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel heading = CommonComponent.h1("Carreras");
        components.add(heading);

        return components;
    }
}
