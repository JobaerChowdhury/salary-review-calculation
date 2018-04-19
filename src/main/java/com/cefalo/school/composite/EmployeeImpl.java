package com.cefalo.school.composite;

import com.cefalo.school.calculator.ReviewCalculator;
import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

public class EmployeeImpl implements Employee {

    private int id;
    private String name;
    private double salary;
    private Role role;
    private Score score;

    EmployeeImpl(int id, String name, Role role, double salary, Score score) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.role = role;
        this.score = score;
    }

    @Override
    public double calculateSalary() {
        ReviewCalculator reviewCalculator = new ReviewCalculator(salary, score, role.getImpact());
        return reviewCalculator.calculate();
    }

    @Override
    public double calculateGroupSalary() {
        return calculateSalary();
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

    public void add(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }

    public Employee getChild(int i) {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }


    public void remove(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public double flatRaise(double percentage) {
        return salary * (1.0 + percentage);
    }
}