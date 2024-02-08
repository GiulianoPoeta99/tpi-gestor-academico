package studyplan;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import common.components.CommonComponent;

public class StudyPlanViews {
    public static List<JComponent> index() {
        List<JComponent> components = new ArrayList<>();

        JLabel heading = CommonComponent.h1("Plan de Estudios");
        components.add(heading);

        return components;
    }
}
