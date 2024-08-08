package org.example.Menu;

import org.example.Entity.*;

public interface MenuEmployee {
    void instantiateOrUpdateEmployee(BaseEmployee employee , int forUpdate);
    void instantiateOrUpdateStudent(Student student, int forUpdate);
    void instantiateOrUpdateCourse(Course course, int forUpdate);
    void instantiateOrUpdateTeacher(Teacher teacher, int forUpdate);
    void instantiateOrUpdateLesson(Lesson lesson, int forUpdate);
    Student findStudent(String studentNumber);
    Teacher findTeacher(String teacherNumber);
    BaseEmployee findEmployee(BaseEmployee baseEmployee);
    Course findCourse(Course course);
    void deleteEmployee(BaseEmployee baseEmployee);
    void deleteStudent(Student student);
    void deleteTeacher(Teacher teacher);
    void deleteCourse(Course course);
    void deleteLesson(Lesson lesson);
}
