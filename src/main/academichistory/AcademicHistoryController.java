package main.academichistory;

import main.career.Career;
import main.career.CareerSearch;
import main.common.Controller;
import main.common.Model;
import main.student.Student;
import main.student.StudentSearch;
import main.studyplan.StudyPlan;
import main.studyplan.StudyPlanSearch;
import main.subject.Subject;
import main.subject.SubjectSearch;

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

    public void searchStudent(boolean isVerify) {
        render(() -> AcademicHistoryViews.searchStudent(isVerify));
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

            String type = studyPlan.getType();
            if (Objects.equals(type, "A")) {

            } else if (Objects.equals(type,"B")) {

            } else if (Objects.equals(type,"C")) {

            } else if (Objects.equals(type,"D")) {

            } else if (Objects.equals(type,"E")) {

            }

            if (model.save()) {
                view(model.getId());
            }
        } else {
            AcademicHistory finalModel = model;
            render(() -> AcademicHistoryViews.enrollSubject(finalModel));
        }
    }

    public void verifyGraduate(int idStudent) {
        Student student = (Student) StudentSearch.getById(idStudent);
        Career career = (Career) CareerSearch.getById(student.getIdCareer());

        Map<Integer, Model> allSubjects = SubjectSearch.getAllSubjectsForCareer(career.getId());

        Map<Integer, Model> allAcademicHistory = AcademicHistorySearch.getAllAcademicHistoryFromStudent(idStudent);

    }
}
