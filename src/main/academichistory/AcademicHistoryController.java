package main.academichistory;

import main.career.Career;
import main.career.CareerSearch;
import main.common.Controller;
import main.common.Model;
import main.correlative.Correlative;
import main.correlative.CorrelativeSearch;
import main.student.Student;
import main.student.StudentSearch;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanSearch;
import main.subject.Subject;
import main.subject.SubjectSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AcademicHistoryController implements Controller {
    private static final AcademicHistoryController instance = new AcademicHistoryController();

    private AcademicHistoryController() {
    }

    public static AcademicHistoryController getInstance() {
        return instance;
    }

    public void index() {
        render(AcademicHistoryViews::index);
    }

    public void create(boolean save, AcademicHistory model) {
        if (model == null) {
            model = new AcademicHistory();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            AcademicHistory finalModel = model;
            render(() -> AcademicHistoryViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        AcademicHistory model = (AcademicHistory) AcademicHistorySearch.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> AcademicHistoryViews.update(model));
        }
    }

    public void view(int id) {
        AcademicHistory model = (AcademicHistory) AcademicHistorySearch.getById(id);
        render(() -> AcademicHistoryViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            AcademicHistory model = (AcademicHistory) AcademicHistorySearch.getById(id);
            model.delete();
            render(() -> AcademicHistoryViews.delete(true, id));
        } else {
            render(() -> AcademicHistoryViews.delete(false, id));
        }
    }

    public void search() {
        render(AcademicHistoryViews::search);
    }

    public void searchStudent(boolean isVerifyGraduate, boolean isVerifyStudent) {
        render(() -> AcademicHistoryViews.searchStudent(isVerifyGraduate, isVerifyStudent));
    }

    public void enrollSubject(boolean save, AcademicHistory model, int idStudent) {
        if (model == null) {
            model = new AcademicHistory();
        }

        model.setIdStudent(idStudent);
        model.setState("Cursando");

        if (save) {
            Subject subject = (Subject) SubjectSearch.getById(model.getIdSubject());
            StudyPlan studyPlan = (StudyPlan) StudyPlanSearch.getById(subject.getIdStudyPlan());

            boolean canEnroll = true;
            String type = studyPlan.getType();
            if (Objects.equals(type, "A")) {
                // Plan A: aprobó las cursadas de las correlativas
                List<Correlative> correlatives = CorrelativeSearch.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || Objects.equals(academicHistory.getState(), "Desaprobado") || Objects.equals(academicHistory.getState(), "Cursando")) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type,"B")) {
                // Plan B: aprobó los finales de las correlativas
                List<Correlative> correlatives = CorrelativeSearch.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado") && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type,"C")) {
                // Plan C: aprobó las cursadas de las correlativas y los finales de todas las materias de 5 cuatrimestres previos al que se quiere anotar
                List<Correlative> correlatives = CorrelativeSearch.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || Objects.equals(academicHistory.getState(), "Desaprobado") || Objects.equals(academicHistory.getState(), "Cursando")) {
                        canEnroll = false;
                        break;
                    }
                }
                Map<Integer, Subject> allPreviousFourMonthsSubjects = SubjectSearch.getAllSubjectsFromPreviousFourMonths(model.getIdSubject(),5);
                for (Subject previousSubject : allPreviousFourMonthsSubjects.values()) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(previousSubject.getId(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado") && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type,"D")) {
                // Plan D: aprobó las cursadas de las correlativas y los finales de todas las materias de 3 cuatrimestres previos al que se quiere anotar
                List<Correlative> correlatives = CorrelativeSearch.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || Objects.equals(academicHistory.getState(), "Desaprobado") || Objects.equals(academicHistory.getState(), "Cursando")) {
                        canEnroll = false;
                        break;
                    }
                }
                Map<Integer, Subject> allPreviousFourMonthsSubjects = SubjectSearch.getAllSubjectsFromPreviousFourMonths(model.getIdSubject(),3);
                for (Subject previousSubject : allPreviousFourMonthsSubjects.values()) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(previousSubject.getId(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado") && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            } else if (Objects.equals(type,"E")) {
                // Plan E: aprobó los finales de las correlativas y los finales de todas las materias de 3 cuatrimestres previos.
                List<Correlative> correlatives = CorrelativeSearch.getAllCorrelativesForSubject(model.getIdSubject());
                for (Correlative correlative : correlatives) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(correlative.getIdSubject(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado") && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
                Map<Integer, Subject> allPreviousFourMonthsSubjects = SubjectSearch.getAllSubjectsFromPreviousFourMonths(model.getIdSubject(),3);
                for (Subject previousSubject : allPreviousFourMonthsSubjects.values()) {
                    AcademicHistory academicHistory = AcademicHistorySearch.getAcademicHistoryFromSubjectStudent(previousSubject.getId(), model.getIdStudent());
                    if (academicHistory == null || (!Objects.equals(academicHistory.getState(), "Promocionado") && !Objects.equals(academicHistory.getState(), "Aprobado"))) {
                        canEnroll = false;
                        break;
                    }
                }
            }

            if (canEnroll) {
                if (model.save()) {
                    view(model.getId());
                }
            }
        } else {
            AcademicHistory finalModel = model;
            render(() -> AcademicHistoryViews.enrollSubject(finalModel));
        }
    }

    public void viewPerStudent(int idStudent) {
        render(() -> AcademicHistoryViews.historyPerStudent(idStudent));
    }

    public void verifyGraduate(int idStudent) {
        Student student = (Student) StudentSearch.getById(idStudent);
        Career career = (Career) CareerSearch.getById(student.getIdCareer());

        Map<Integer, Model> allSubjects = SubjectSearch.getAllSubjectsForCareer(career.getId());
        Map<Integer, Model> allAcademicHistory = AcademicHistorySearch.getAllAcademicHistoryFromStudent(idStudent);

        List<Subject> subjectsNotApproved = new ArrayList<>();

        for (Model model : allSubjects.values()) {
            if (model instanceof Subject subject) {
                boolean approved = false;
                if (!subject.getIsOptional()) {
                    for (Model modelAH : allAcademicHistory.values()) {
                        if (modelAH instanceof AcademicHistory academicHistory) {
                            if (subject.getId() == academicHistory.getIdSubject() &&
                                    (Objects.equals(academicHistory.getState(), "Aprobado") ||
                                            Objects.equals(academicHistory.getState(), "Promocionado"))) {
                                approved = true;
                                break;
                            }
                        }
                    }
                    if (!approved) {
                        subjectsNotApproved.add(subject);
                    }
                }
            }
        }

        boolean isGraduated = subjectsNotApproved.isEmpty();
        render(() -> AcademicHistoryViews.verifyGraduate(isGraduated, subjectsNotApproved));
    }

}
