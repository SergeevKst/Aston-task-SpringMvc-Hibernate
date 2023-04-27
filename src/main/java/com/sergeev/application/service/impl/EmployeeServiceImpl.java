package com.sergeev.application.service.impl;

import com.sergeev.application.entity.Employee;
import com.sergeev.application.repository.EmployeeRepository;
import com.sergeev.application.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
