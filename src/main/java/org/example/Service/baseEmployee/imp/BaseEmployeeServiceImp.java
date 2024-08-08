package org.example.Service.baseEmployee.imp;

import jakarta.persistence.NoResultException;
import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.Repository.employeeRepository.EmployeeRepository;
import org.example.Repository.employeeRepository.imp.EmployeeRepositoryImp;
import org.example.Service.baseEmployee.BaseEmployeeService;

import java.util.List;

public class BaseEmployeeServiceImp<T extends BaseEntity> implements BaseEmployeeService<T> {
    EmployeeRepository<T> employeeRepository;
    public BaseEmployeeServiceImp() {
        employeeRepository = new EmployeeRepositoryImp<>();
    }
    @Override
    public BaseEmployee login(String username, String password) {
        return employeeRepository.login(username, password);
    }

    @Override
    public T save(T entity) {
         return employeeRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return employeeRepository.update(entity);
    }

    @Override
    public T delete(T entity) {
        return null;
    }

    @Override
    public Student findByStudentNumber(String studentNumber) {
        return employeeRepository.findStudentByNumber(studentNumber);
    }

    @Override
    public Teacher findByTeacherNumber(String teacherNumber) {
        try {
            return employeeRepository.findTeacher(teacherNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public BaseEmployee findByEmployeeNumber(String phoneNumber) {
        try {
            return employeeRepository.findEmployeeByNumber(phoneNumber);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Course findByCourseCodeOrTitle(String courseCode, String title) {
        try {
            return employeeRepository.findCourseByCourseCodeOrTitle(courseCode, title);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        }

    @Override
    public Teacher findByTeacherCodeOrFirstNameAndLastName(Teacher teacher) {
        try {
            return employeeRepository.findByTeacherCodeOrFirstNameAndLastName(teacher);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Lesson> findLessonsByTeacher(Teacher teacher) {
        try {
            return employeeRepository.lessonsByTeacher(teacher);
        }catch (NoResultException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
