package org.example.Menu.interfaces;

import org.example.Entity.Teacher;

public interface TeacherMenuInterFace {
    boolean validate(Teacher token);
    void menu();
    void changeGradeOfStudents(Teacher teacher);
    void showSalaryPaper(Teacher teacher);
}
