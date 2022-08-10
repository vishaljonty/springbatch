package com.spring.batch.step;

import com.spring.batch.entity.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CSVItemProcessor implements ItemProcessor<Employee, Employee> {
    Map<String, String> empMap = new HashMap<>();

    public CSVItemProcessor() {
        empMap.put("1", "HR");
        empMap.put("2", "Developer");
        empMap.put("3", "Tester");
    }

    @Override
    public Employee process(Employee employee) throws Exception {
        String deptCode = employee.getDept();
        String dept = empMap.get(deptCode);
        employee.setDept(dept);
        employee.setTime(new Date());
        System.out.println(String.format("Converted from  %s to %s", deptCode, dept));
        return employee;

    }
}
