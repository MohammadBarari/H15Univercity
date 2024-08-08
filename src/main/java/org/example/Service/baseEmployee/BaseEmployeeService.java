package org.example.Service.baseEmployee;

import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;

import java.time.LocalDate;
import java.util.List;

public interface BaseEmployeeService <T extends BaseEntity>{
    BaseEmployee login(String username, String password);
    T save (T entity);
    T update (T entity);
    void delete (T entity);
    Student findByStudentNumber (String studentNumber);
    BaseEmployee findByEmployeeNumber (String phoneNumber);
    Course findByCourseCodeOrTitle (String courseCode, String title);
    Teacher findByTeacherCodeOrFirstNameAndLastName(Teacher teacher);

    List<Lesson> findLessonsByTeacher (Teacher teacher);

    Term findTerm(Integer year);
    List<Course>findAll();

    List<Lesson> findStudentByLessonAndStudentNumber(String courseCode,String studentNumber);

    SalaryForTeacher calculateSalaryForTeacher(Teacher teacher, LocalDate update);

    SalaryPaper calculateSalaryPaperForEmployee(BaseEmployee employee, LocalDate update);
}
