package org.example.Service.baseEmployee;

import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;

import java.util.List;

public interface BaseEmployeeService <T extends BaseEntity>{
    BaseEmployee login(String username, String password);
    T save (T entity);
    T update (T entity);
    T delete (T entity);
    Student findByStudentNumber (String studentNumber);
    Teacher findByTeacherNumber (String teacherNumber);
    BaseEmployee findByEmployeeNumber (String phoneNumber);
    Course findByCourseCodeOrTitle (String courseCode, String title);
    Teacher findByTeacherCodeOrFirstNameAndLastName(Teacher teacher);

    List<Lesson> findLessonsByTeacher (Teacher teacher);
}
