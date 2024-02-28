package student;

import common.Controller;

public class StudentController implements Controller {
    private static final StudentController instance = new StudentController();

    private StudentController() {
    }

    public static StudentController getInstance() {
        return instance;
    }

    public void index() {
        render(() -> StudentViews.index(Student.getAll()));
    }

    public void create(boolean save, Student model) {
        if (model == null) {
            model = new Student();
        }

        if (save) {
            if (model.save()) {
                view(model.getId());
            }
        } else {
            Student finalModel = model;
            render(() -> StudentViews.create(finalModel));
        }
    }

    public void update(boolean save, int id) {
        Student model = (Student) Student.getById(id);

        if (save) {
            if (model.update()) {
                view(model.getId());
            }
        } else {
            render(() -> StudentViews.update(model));
        }
    }

    public void view(int id) {
        Student model = (Student) Student.getById(id);
        render(() -> StudentViews.view(model));
    }

    public void delete(boolean validation, int id) {
        if (validation) {
            Student model = (Student) Student.getById(id);
            model.delete();
            render(() -> StudentViews.delete(true, id));
        } else {
            render(() -> StudentViews.delete(false, id));
        }
    }
}
