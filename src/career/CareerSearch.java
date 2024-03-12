package career;

import common.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CareerSearch extends Career {
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Career.getAll().values()) {
            if (model instanceof Career career) {
                Object[] rowData = new Object[] { career.getName() };
                customData.add(rowData);
            }
        }
        return customData;
    }

    public static String[] getCustomColumns() {
        return new String[] { "Nombre" };
    }

    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> careerMap = new LinkedHashMap<>();
        for (Model model : Career.getAll().values()) {
            if (model instanceof Career career) {
                careerMap.put(career.getId(), career.getName());
            }
        }
        return careerMap;
    }
}