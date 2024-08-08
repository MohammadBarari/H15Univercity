package org.example.Repository.employeeRepository.imp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.reflect.Typed;
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
    private Class<T> entityClass;
    @Override
    public T save(T entity) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
        }

    @Override
    public T update(T entity) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void delete(T em) {

        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        try {
            em = (T) entityManager.find(em.getClass(),em.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(em);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Student findStudentByNumber(String number){

        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        Predicate predicate = cb.equal(root.get("studentNumber"), number);
        cq.where(predicate);
        TypedQuery<Student> query = entityManager.createQuery(cq);
        return query.getSingleResult();
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

    @Override
    public Term findTerm(Integer year) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createNativeQuery("select * from term where termdate = ?");
        query.setParameter(1, year);
        return (Term) query.getSingleResult();
    }

    @Override
    public List<Course> findAllCourse() {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createNativeQuery("select * from course", Course.class);
        return query.getResultList();
    }

    @Override
    public List<Lesson> findStudentByLessonAndStudentNumber(String courseCode, String studentNumber) {
        EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
        Query query = entityManager.createQuery(
                "SELECT c FROM Student s " +
                        "JOIN s.coursePreferences c " +
                        "JOIN c.lesson l " +
                        "WHERE s.studentNumber = :studentNumber AND l.courseCode = :courseCode", CoursePreference.class);
        query.setParameter("studentNumber", studentNumber);
        query.setParameter("courseCode", courseCode);
        return query.getResultList();
    }

}
