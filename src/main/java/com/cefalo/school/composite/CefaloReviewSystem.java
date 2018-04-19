package com.cefalo.school.composite;

import com.cefalo.school.common.EmployeeInfo;
import com.cefalo.school.common.Role;
import com.cefalo.school.calculator.Score;
import com.cefalo.school.common.ReviewSystem;

import java.util.HashMap;
import java.util.Map;

public class CefaloReviewSystem implements ReviewSystem {
    private Map<Integer, Employee> empStore = new HashMap<>();

    @Override
    public EmployeeInfo create(int id, String name, Role role, double salary, Score score) {
        Employee emp;
        if (Role.DEVELOPER.equals(role)) {
            emp = new EmployeeImpl(id, name, role, salary, score);
        } else {
            emp = new CompositeEmployeeHof(id, name, role, salary, score);
        }

        empStore.put(id, emp);
        return emp;
    }

    @Override
    public void addSubordinate(EmployeeInfo parent, EmployeeInfo child) {
        Employee composite = empStore.get(parent.getId());
        Employee leaf = empStore.get(child.getId());

        composite.add(leaf);
    }

    @Override
    public void removeSubordinate(EmployeeInfo parent, EmployeeInfo child) {
        Employee composite = empStore.get(parent.getId());
        Employee leaf = empStore.get(child.getId());

        composite.remove(leaf);
    }

    @Override
    public double calculateSalary(EmployeeInfo employee) {
        Employee storedEmployee = empStore.get(employee.getId());
        return storedEmployee.calculateSalary();
    }

    @Override
    public double calculateGroupSalary(EmployeeInfo empWithSub) {
        Employee storedEmployee = empStore.get(empWithSub.getId());
        return storedEmployee.calculateGroupSalary();
    }

    @Override
    public void print(EmployeeInfo emp) {
        Employee employee = empStore.get(emp.getId());
        String print = employee.print();
        System.out.println(print);
    }

    @Override
    public double flatRaise(double percentage, EmployeeInfo empInfo) {
        Employee employee = empStore.get(empInfo.getId());
        return employee.flatRaise(percentage);
    }
}
