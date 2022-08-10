package com.spring.batch.step;

import com.spring.batch.entity.Employee;
import com.spring.batch.repository.EmployeeRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBItemWriter implements ItemWriter<Employee> {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void write(List<? extends Employee> employees) throws Exception {
        System.out.println("Data saved for Employees:" + employees);
        employeeRepository.saveAll(employees);
    }
}
