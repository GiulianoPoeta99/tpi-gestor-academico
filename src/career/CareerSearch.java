package career;

import common.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class CareerSearch extends Career {
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