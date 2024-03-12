package subject;

import career.Career;
import career.CareerSearch;
import common.Model;
import studyplan.StudyPlan;
import studyplan.StudyPlanSearch;

import java.util.ArrayList;
import java.util.List;

public class SubjectSearch extends Subject {
    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                Model studyPlanModel = StudyPlanSearch.getById(subject.getIdStudyPlan());
                if (studyPlanModel instanceof StudyPlan studyPlan) {
                    Model careerModel = CareerSearch.getById(studyPlan.getIdCareer());
                    if (careerModel instanceof Career career) {
                        Object[] rowData = new Object[]{
                                subject.getName(),
                                subject.getIsOptional() ? "Si" : "No",
                                subject.getFourMonths(),
                                career.getName()
                        };
                        customData.add(rowData);
                    }
                }
            }
        }
        return customData;
    }

    public static String[] getCustomColumns() {
        return new String[] { "Nombre", "Opcional", "Cuatrimestre", "Carrera" };
    }

    public static Model getById(int id) {
        return all.get(id);
    }
}
