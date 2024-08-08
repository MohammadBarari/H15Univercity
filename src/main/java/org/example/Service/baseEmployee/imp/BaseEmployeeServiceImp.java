package org.example.Service.baseEmployee.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.Repository.employeeRepository.EmployeeRepository;
import org.example.Repository.employeeRepository.imp.EmployeeRepositoryImp;
import org.example.Service.baseEmployee.BaseEmployeeService;
import org.example.enums.TypeOfTeacher;

import java.time.LocalDate;
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
        try {
            return employeeRepository.update(entity);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        try {
            employeeRepository.delete(entity);
        }catch (NoResultException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findByStudentNumber(String studentNumber) {
        try {
            return employeeRepository.findStudentByNumber(studentNumber);
        }catch (Exception e){
            e.printStackTrace();
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

    @Override
    public Term findTerm(Integer year) {
        try {return
                employeeRepository.findTerm(year);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Course> findAll() {
       return employeeRepository.findAllCourse();
    }

    @Override
    public List<Lesson> findStudentByLessonAndStudentNumber(String courseCode, String studentNumber) {
        try {
            return employeeRepository.findStudentByLessonAndStudentNumber(courseCode, studentNumber);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SalaryForTeacher calculateSalaryForTeacher(Teacher teacher, LocalDate update) {
        try {
            SalaryForTeacher salaryForTeacher = new SalaryForTeacher();
            salaryForTeacher.setEmployee(teacher);
            salaryForTeacher.setSalaryUpdate(update);
            int sum = teacher.getLessons().stream().mapToInt(Lesson::getNumberOfUnit).sum();
            if (teacher.getTypeOfTeacher().equals(TypeOfTeacher.faculity_member)) {
                salaryForTeacher.setSalary(1_000_000L * sum + 5_000_000L);
            } else {
                salaryForTeacher.setSalary(1_000_000L * sum);
            }
            return salaryForTeacher;
        }catch (Exception e){
            System.out.println("something went wrong");
            return null;
        }
    }

    @Override
    public SalaryPaper calculateSalaryPaperForEmployee(BaseEmployee employee, LocalDate update) {
        return null;
    }
}
