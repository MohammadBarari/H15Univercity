package org.example.Repository.employeeRepository;

import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;

import java.util.List;

public interface EmployeeRepository<T extends BaseEntity>
{
        BaseEmployee login(String username, String password);

        T save(T entity);

        T update(T entity);

        void delete(T entity);

        Student findStudentByNumber(String number);

        Teacher findTeacher(String teacherNumber);

        BaseEmployee findEmployeeByNumber(String number);

        Course findCourseByCourseCodeOrTitle(String courseCode, String title);

        Teacher findByTeacherCodeOrFirstNameAndLastName(Teacher teacher);

        List<Lesson> lessonsByTeacher (Teacher teacher);

}
