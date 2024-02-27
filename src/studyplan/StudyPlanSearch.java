package studyplan;

import career.Career;
import common.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class StudyPlanSearch extends StudyPlan{
    public static Map<String, String> getTypeForSelect2() {
        Map<String, String> typeMap = new LinkedHashMap<>();
        for (String type : StudyPlan.TYPES_STUDY_PLAN) {
            typeMap.put(type,type);
        }
        return typeMap;
    }
}


