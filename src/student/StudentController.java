package student;

import career.CareerViews;
import common.Controller;

public class StudentController implements Controller {
    private static final StudentController instance = new StudentController();

    private StudentController() {
    }

    public static StudentController getInstance() {
        return instance;
    }

    public void index() {
        render(StudentViews::index);
    }

    public void create(boolean isRegister, boolean save, Student model) {
        if (model == null) {
            model = new Student();
        }

        if (save) {
            if (model.save()) {
                view(isRegister, model.getId());
            }
        } else {
            Student finalModel = model;
            render(() -> StudentViews.create(isRegister, finalModel));
        }
    }

    public void update(boolean isRegister, boolean save, int id) {
        Student model = (Student) StudentSearch.getById(id);

        if (save) {
            if (model.update()) {
                view(isRegister, model.getId());
            }
        } else {
            render(() -> StudentViews.update(isRegister, model));
        }
    }

    public void view(boolean isRegister, int id) {
        Student model = (Student) StudentSearch.getById(id);
        render(() -> StudentViews.view(isRegister, model));
    }

    public void delete(boolean isRegister, boolean validation, int id) {
        if (validation) {
            Student model = (Student) StudentSearch.getById(id);
            model.delete();
            render(() -> StudentViews.delete(isRegister,true, id));
        } else {
            render(() -> StudentViews.delete(isRegister, false, id));
        }
    }

    public void search() {
        render(StudentViews::search);
    }
}
