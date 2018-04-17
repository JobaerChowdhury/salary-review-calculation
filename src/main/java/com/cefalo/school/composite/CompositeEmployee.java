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

    @Override
    public double flatRaise(double percentage) {
        double sum = super.flatRaise(percentage);
        for (Employee employee : employees) {
            sum += employee.flatRaise(percentage);
        }
        return sum;
    }

    @Override
    public String print() {
        String result = super.print();

        for (Employee employee : employees) {
            result = result + "\n" + employee.print();
        }

        return result;
    }

    public void remove(Employee employee) {
        //todo this is not the correct way, since it may remove an employee with his subordinates, which we don't want
        employees.remove(employee);
    }
}