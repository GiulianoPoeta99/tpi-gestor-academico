package main.student;

import main.career.Career;
import main.career.CareerService;
import main.common.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentService extends Student {
    public static String[] getCustomColumns() {
        return new String[] { "Legajo", "Nombre completo", "Fecha de nacimiento", "Carrera" };
    }

    public static List<Object[]> getCustomData() {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                Model careerModel = CareerService.getById(student.getIdCareer());
                if (careerModel != null) {
                    if (careerModel instanceof Career career) {

                        LocalDate birthDate = student.getBirthDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String formattedDate = birthDate.format(formatter);
                        Object[] rowData = new Object[] {
                                student.getDossierNumber(),
                                String.format("%s %s", student.getLastName(), student.getFirstName()),
                                formattedDate,
                                career.getName()
                        };
                        customData.add(rowData);
                    }
                } else {
                    Object[] rowData = new Object[] {
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

    public static Map<Integer, String> getIDNameForSelect2() {
        Map<Integer, String> studentMap = new LinkedHashMap<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                String name = String.format("%s - %s %s", student.getDossierNumber(), student.getLastName(),
                        student.getFirstName());
                studentMap.put(student.getId(), name);
            }
        }
        return studentMap;
    }

    public static List<Object[]> getCustomDataForCareer(int idCareer) {
        List<Object[]> customData = new ArrayList<>();
        for (Model model : Student.getAll().values()) {
            if (model instanceof Student student) {
                if (idCareer == student.getIdCareer()) {
                    Model careerModel = CareerService.getById(student.getIdCareer());
                    if (careerModel != null) {
                        if (careerModel instanceof Career career) {

                            LocalDate birthDate = student.getBirthDate();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            String formattedDate = birthDate.format(formatter);
                            Object[] rowData = new Object[] {
                                    student.getDossierNumber(),
                                    String.format("%s %s", student.getLastName(), student.getFirstName()),
                                    formattedDate,
                                    career.getName()
                            };
                            customData.add(rowData);
                        }
                    }
                }
            }
        }
        return customData;
    }
}
