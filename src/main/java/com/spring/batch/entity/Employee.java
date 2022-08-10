package com.spring.batch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {
    @Id
    private Integer empId;
    private String name;
    private String dept;
    private Integer salary;
    private Date creationTs;

    public Employee(Integer empId, String name, String dept, Integer salary, Date time) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.creationTs = time;
    }

    public Employee() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("empId=").append(empId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dept='").append(dept).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }

    public Date getTime() {
        return creationTs;
    }

    public void setTime(Date time) {
        this.creationTs = time;
    }


}
