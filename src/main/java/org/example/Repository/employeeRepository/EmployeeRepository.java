package org.example.Repository.employeeRepository;

import org.example.Entity.baseEntity.BaseEntity;

public interface EmployeeRepository<T extends BaseEntity>
{
        T save(T entity);

        T update(T entity);

        void delete(T entity);
}
