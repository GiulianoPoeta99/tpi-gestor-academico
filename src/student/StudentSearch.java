package student;

import career.Career;
import career.CareerSearch;
import common.Model;
import studyplan.StudyPlan;
import subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentSearch extends Student {
    public static String[] getCustomColumns() {
        return new String[] { "Legajo", "Nombre completo", "Fecha de nacimiento", "Carrera" };
    }

    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                Model careerModel = CareerSearch.getById(student.getIdCareer());
                if (careerModel != null) {
                    if (careerModel instanceof Career career) {
                        Object[] rowData = new Object[]{
                                student.getDossierNumber(),
                                String.format("%s %s", student.getLastName(), student.getFirstName()),
                                student.getBirthDate(),
                                career.getName()
                        };
                        customData.add(rowData);
                    }
                } else {
                    Object[] rowData = new Object[]{
                            student.getDossierNumber(),
                            String.format("%s %s", student.getLastName(), student.getFirstName()),
                            student.getBirthDate(),
                            "-"
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
}
