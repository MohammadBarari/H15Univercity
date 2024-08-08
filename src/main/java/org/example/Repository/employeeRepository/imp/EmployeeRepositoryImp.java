package org.example.Repository.employeeRepository.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.Entity.*;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.Repository.employeeRepository.EmployeeRepository;
import org.example.Util.HibernateUtil;

import java.util.List;

public class EmployeeRepositoryImp <T extends BaseEntity> implements EmployeeRepository<T> {


    @Override
    public BaseEmployee login(String username, String password) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createNativeQuery("select * from base_employee where username=? and password=?");
        query.setParameter(1, username);
        query.setParameter(2, password);
        return (BaseEmployee) query.getSingleResult();
    }

    @Override
    public T save(T entity) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Student findStudentByNumber(String number) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createNativeQuery("select * from student where studentNumber= ?");
        query.setParameter(1, number);
        return (Student) query.getSingleResult();
    }

    @Override
    public Teacher findTeacher(String teacherNumber) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createNativeQuery("select * from student where teacherNumber = ?");
        query.setParameter(1, teacherNumber);
        return (Teacher) query.getSingleResult();
    }

    @Override
    public BaseEmployee findEmployeeByNumber(String number) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createNativeQuery("select * from base_employee where phoneNumber = ?");
        query.setParameter(1, number);
        return (BaseEmployee) query.getSingleResult();
    }

    @Override
    public Course findCourseByCourseCodeOrTitle(String courseCode, String title) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> course = cq.from(Course.class);
        Predicate p1 = cb.equal(course.get("courseCode"), courseCode);
        Predicate p2 = cb.equal(course.get("name"), title);
        Predicate p3 = cb.or(p1, p2);
        cq.where(p3);
        return entityManager.createQuery(cq).getSingleResult();
    }
    public Teacher findByTeacherCodeOrFirstNameAndLastName(Teacher teacher) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        Root<Teacher> teacher1 = cq.from(Teacher.class);
        Predicate p1 = cb.equal(teacher1.get("teacherNumber"), teacher.getTeacherNumber());
        Predicate p2 = cb.equal(teacher1.get("firstName"), teacher.getFirstName());
        Predicate p3 = cb.equal(teacher1.get("lastName"), teacher.getLastName());
        Predicate p4 =  cb.and(p2,p3);
        Predicate p5 = cb.or(p4,p1);
        cq.where(p5);
        return  entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public List<Lesson> lessonsByTeacher(Teacher teacher) {
        return List.of();
    }

}
