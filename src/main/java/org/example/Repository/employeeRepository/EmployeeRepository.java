package org.example.Repository.employeeRepository;

import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;

import java.util.List;

public interface EmployeeRepository<T extends BaseEntity>
{
        BaseEmployee login(String username, String password);

        T save(T entity);

        T update(T entity);

        void delete(T em);

        Student findStudentByNumber(String number);

        BaseEmployee findEmployeeByNumber(String number);

        Course findCourseByCourseCodeOrTitle(String courseCode, String title);

        Teacher findByTeacherCodeOrFirstNameAndLastName(Teacher teacher);


        Term findTerm(Integer year);

        List<Course> findAllCourse();

        List<Lesson> findStudentByLessonAndStudentNumber(String courseCode,String studentNumber);
}
