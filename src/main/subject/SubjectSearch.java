package main.subject;

import main.career.Career;
import main.career.CareerSearch;
import main.common.Model;
import main.student.Student;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanSearch;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> subjectMap = new LinkedHashMap<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(subject.getIdStudyPlan());
                Career career = (Career) CareerSearch.getById(studyPlan.getIdCareer());

                String name = String.format("%s - %s", career.getName(), subject.getName());

                subjectMap.put(subject.getId(), name);
            }
        }
        return subjectMap;
    }

    public static List<Object[]> getCustomDataForStudyPlan(int idStudyPLan) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                if (subject.getIdStudyPlan() == idStudyPLan) {
                    Object[] rowData = new Object[]{
                            subject.getName(),
                            subject.getIsOptional() ? "Si" : "No",
                            subject.getFourMonths()
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    public static String[] getCustomColumnsForStudyPlan() {
        return new String[] { "Nombre", "Opcional", "Cuatrimestre" };
    }

    public static Map<Integer, Model> getAllSubjectsForCareer(int idCareer) {
        Map<Integer, Model> subjectsMap = new LinkedHashMap<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(subject.getIdStudyPlan());
                if (idCareer == studyPlan.getId()) {
                    subjectsMap.put(subject.getId(), subject);
                }
            }
        }
        return subjectsMap;
    }

    public static Map<Integer, String> getAllSubjectsForCareerForSelect2(int idCareer) {
        Map<Integer, String> subjectsMap = new LinkedHashMap<>();
        for (Model model : Subject.getAll().values()) {
            if (model instanceof Subject subject) {
                StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(subject.getIdStudyPlan());
                if (idCareer == studyPlan.getId()) {
                    Career career = (Career) CareerSearch.getById(studyPlan.getIdCareer());

                    String name = String.format("%s - %s", career.getName(), subject.getName());
                    subjectsMap.put(subject.getId(), name);
                }
            }
        }
        return subjectsMap;
    }
}
