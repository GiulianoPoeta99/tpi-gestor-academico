package main.academichistory;

import main.common.Model;
import main.student.Student;
import main.student.StudentService;
import main.subject.Subject;
import main.subject.SubjectService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AcademicHistoryService extends AcademicHistory{
    public static String[] getCustomColumns() {
        return new String[] { "Estudiante", "Materia", "Estado", "Parcial 1", "Parcial 2", "Promoción", "Final", "Nota" };
    }

    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                Student student = (Student) StudentService.getById(academicHistory.getIdStudent());
                Subject subject = (Subject) SubjectService.getById(academicHistory.getIdSubject());
                Object[] rowData = new Object[] {
                    String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(), student.getFirstName()),
                    String.format("%s - %s", subject.getId(), subject.getName()),
                    academicHistory.getState(),
                    academicHistory.getPartial1(),
                    academicHistory.getPartial2(),
                    academicHistory.getIsPromoted() ? "Si" : "No",
                    academicHistory.getFinalExam(),
                    academicHistory.getGrade()
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
        Map<Integer, String> academicHistoryMap = new LinkedHashMap<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                Student student = (Student) StudentService.getById(academicHistory.getIdStudent());
                Subject subject = (Subject) SubjectService.getById(academicHistory.getIdSubject());
                academicHistoryMap.put(
                    academicHistory.getId(),
                    String.format(
                        "%d - %s/%s (%s)",
                        academicHistory.getId(),
                        String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(), student.getFirstName()),
                        subject.getName(),
                        academicHistory.getState()
                    )
                );
            }
        }
        return academicHistoryMap;
    }

    public static Map<String, String> getStateForSelect2() {
        Map<String, String> typeMap = new LinkedHashMap<>();
        for (String type : AcademicHistory.TYPES_STATE) {
            typeMap.put(type,type);
        }
        return typeMap;
    }
    public static Map<Integer, Model> getAllAcademicHistoryFromStudent(int idStudent) {
        Map<Integer, Model> academicHistoryMap = new LinkedHashMap<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                if (idStudent == academicHistory.getIdStudent()) {
                    academicHistoryMap.put(academicHistory.getId(), academicHistory);
                }
            }
        }
        return academicHistoryMap;
    }

    public static List<Object[]> getCustomDataForStudent(int idStudent) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : AcademicHistory.getAll().values()) {
            if (model instanceof AcademicHistory academicHistory) {
                if (idStudent == academicHistory.getIdStudent()) {
                    Student student = (Student) StudentService.getById(academicHistory.getIdStudent());
                    Subject subject = (Subject) SubjectService.getById(academicHistory.getIdSubject());
                    Object[] rowData = new Object[] {
                            String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(), student.getFirstName()),
                            String.format("%s - %s", subject.getId(), subject.getName()),
                            academicHistory.getState(),
                            academicHistory.getPartial1(),
                            academicHistory.getPartial2(),
                            academicHistory.getIsPromoted() ? "Si" : "No",
                            academicHistory.getFinalExam(),
                            academicHistory.getGrade()
                    };
                    customData.add(rowData);
                }
            }
        }
        return customData;
    }

    public static AcademicHistory getAcademicHistoryFromSubjectStudent(int idSubject, int idStudent) {
        Map<Integer, Model> allAcademicHistory = AcademicHistoryService.getAllAcademicHistoryFromStudent(idStudent);
        AcademicHistory finalAcademicHistory = null;
        for (Model model : allAcademicHistory.values()) {
            if (model instanceof AcademicHistory academicHistory) {
                if (academicHistory.getIdSubject() == idSubject) {
                    finalAcademicHistory = academicHistory;
                    break;
                }
            }
        }
        return finalAcademicHistory;
    }
}
