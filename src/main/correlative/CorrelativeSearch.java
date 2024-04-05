package main.correlative;

import main.common.Model;
import main.subject.Subject;
import main.subject.SubjectSearch;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CorrelativeSearch extends Correlative {
    public static String[] getCustomColumns() {
        return new String[] { "Materia", "Materia correlativa" };
    }

    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                Subject subject = (Subject) SubjectSearch.getById(correlative.getIdSubject());
                Subject subjectCorrelative = (Subject) SubjectSearch.getById(correlative.getIdSubjectCorrelative());
                Object[] rowData = new Object[] {
                    subject.getName(),
                    subjectCorrelative.getName()
                };
                customData.add(rowData);
            }
        }
        return customData;
    }

    public static Model getById(int id) {
        return all.get(id);
    }

    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> correlativeMap = new LinkedHashMap<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                Subject subject = (Subject) SubjectSearch.getById(correlative.getIdSubject());
                Subject subjectCorrelative = (Subject) SubjectSearch.getById(correlative.getIdSubject());
                String name = String.format("%d - %s -> %s", correlative.getId(), subjectCorrelative.getName(), subject.getName());
                correlativeMap.put(correlative.getId(), name);
            }
        }
        return correlativeMap;
    }
}
