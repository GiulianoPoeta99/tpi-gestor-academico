package main.correlative;

import main.common.Model;
import main.subject.Subject;
import main.subject.SubjectService;

import java.util.*;

public class CorrelativeService extends Correlative {
    public static String[] getCustomColumns() {
        return new String[] { "Materia", "Materia correlativa" };
    }

    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                Subject subject = (Subject) SubjectService.getById(correlative.getIdSubject());
                Subject subjectCorrelative = (Subject) SubjectService.getById(correlative.getIdSubjectCorrelative());
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
                Subject subject = (Subject) SubjectService.getById(correlative.getIdSubject());
                Subject subjectCorrelative = (Subject) SubjectService.getById(correlative.getIdSubject());
                String name = String.format("%d - %s -> %s", correlative.getId(), subjectCorrelative.getName(), subject.getName());
                correlativeMap.put(correlative.getId(), name);
            }
        }
        return correlativeMap;
    }

    public static List<Object[]> getCustomDataForSubject(int idSubject) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                if (idSubject == correlative.getIdSubject()) {
                    Subject subject = (Subject) SubjectService.getById(correlative.getIdSubject());
                    Subject subjectCorrelative = (Subject) SubjectService.getById(correlative.getIdSubjectCorrelative());
                    Object[] rowData = new Object[] {
                            subject.getName(),
                            subjectCorrelative.getName()
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    public static List<Correlative> getAllCorrelativesForSubject(int idSubject) {
        List<Correlative> allCorrelatives = new ArrayList<>();
        for (Model model : Correlative.getAll().values()) {
            if (model instanceof Correlative correlative) {
                if (idSubject == correlative.getIdSubject()) {
                    allCorrelatives.add(correlative);
                }
            }
        }
        return allCorrelatives;
    }
}
