package com.cefalo.school.composite;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

import java.util.ArrayList;
import java.util.List;

public class CompositeEmployee extends AbstractEmployee {
    List<Employee> employees = new ArrayList<Employee>();

    public CompositeEmployee(int id, String name, Role role, double salary, Score score) {
        super(id, name, role, salary, score);
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public double calculateGroupSalary() {
        double sum = calculateSalary();
        for (Employee employee : employees) {
            sum += employee.calculateGroupSalary();
        }
        return sum;
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}