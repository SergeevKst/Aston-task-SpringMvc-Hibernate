package com.sergeev.application.repository.impl;

import com.sergeev.application.entity.Employee;
import com.sergeev.application.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void save(Employee entity) {
        var session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
    }
}
