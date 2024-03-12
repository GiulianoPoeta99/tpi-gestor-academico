package studyplan;

import career.Career;
import career.CareerSearch;
import studyplan.StudyPlan;
import common.Model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudyPlanSearch extends StudyPlan{
    public static String[] getCustomColumns() {
        return new String[] { "Tipo", "Carrera", "Vigente" };
    }

    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : StudyPlan.getAll().values()) {
            if (model instanceof StudyPlan studyPlan) {
                Model career = CareerSearch.getById(studyPlan.getIdCareer());
                if (career instanceof Career) {
                    Object[] rowData = new Object[] {
                            studyPlan.getType(),
                            ((Career) career).getName(),
                            studyPlan.getIsActive() ? "Si" : "No"
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    public static Model getById(int id) {
        return all.get(id);
    }

    public static Model getByIdCareer (int idCareer) {
        for (Model model : all.values()) {
            if (model instanceof StudyPlan studyPlan) {
                if (studyPlan.getIdCareer() == idCareer && studyPlan.getIsActive()) {
                    return studyPlan;
                }
            }
        }
        return null;
    }

    public static Map<String, String> getTypeForSelect2() {
        Map<String, String> typeMap = new LinkedHashMap<>();
        for (String type : StudyPlan.TYPES_STUDY_PLAN) {
            typeMap.put(type,type);
        }
        return typeMap;
    }
}


