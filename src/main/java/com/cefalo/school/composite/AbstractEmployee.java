package com.cefalo.school.composite;

import com.cefalo.school.calculator.ReviewCalculator;
import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

public abstract class AbstractEmployee implements Employee {

    private int id;
    private String name;
    private double salary;
    private Role role;
    private Score score;

    AbstractEmployee(int id, String name, Role role, double salary, Score score) {
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
        return "Emplyee{" +
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