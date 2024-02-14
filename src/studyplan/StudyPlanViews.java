package studyplan;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.Model;
import common.components.TextComponent;
import common.components.UIComponent;

public class StudyPlanViews {
    public static List<JComponent> index(Map<Integer, Model> allData) {

        List<JComponent> components = new ArrayList<>();

        JLabel title = TextComponent.h1(StudyPlan.TRANSLATE_NAME);
        components.add(title);

        JPanel boxPanel = UIComponent.bigBox();

        JScrollPane table = UIComponent.table(allData);

        boxPanel.setLayout(new BorderLayout());
        boxPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        components.add(boxPanel);

        return components;
    }
}
