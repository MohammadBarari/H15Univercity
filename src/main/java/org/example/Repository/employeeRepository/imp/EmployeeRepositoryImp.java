package org.example.Repository.employeeRepository.imp;

import jakarta.persistence.EntityManager;
import org.example.Entity.BaseEmployee;
import org.example.Entity.baseEntity.BaseEntity;
import org.example.Repository.employeeRepository.EmployeeRepository;
import org.example.Util.HibernateUtil;

public class EmployeeRepositoryImp <T extends BaseEntity> implements EmployeeRepository<T> {


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
}
