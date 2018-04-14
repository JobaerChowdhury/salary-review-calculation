package com.cefalo.school.composite;

import com.cefalo.school.calculator.ReviewCalculator;
import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

import java.util.ArrayList;
import java.util.List;

public class CompositeEmployee implements Employee {

    private int id;
    private String name;
    private Role role;
    private double salary;
    private Score score;

    public CompositeEmployee(int id, String name, Role role, double salary, Score score) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.score = score;
    }

    List<Employee> employees = new ArrayList<Employee>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public double calculateSalary() {
        ReviewCalculator reviewCalculator = new ReviewCalculator(salary, score, role.getImpact());
        return reviewCalculator.calculate();
    }

    @Override
    public double calculateGroupSalary() {
        double sum = calculateSalary();
        for (Employee employee : employees) {
            sum += employee.calculateGroupSalary();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public Score getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "CompositeEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", salary=" + salary +
                '}';
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}