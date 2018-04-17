package com.cefalo.school.common;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

/**
 * Basic data class.
 * <p>
 * Created by jobaer on Apr-17-2018.
 */
public class EmployeeInfoImpl implements EmployeeInfo {

    private int id;
    private String name;
    private double salary;
    private Role role;
    private Score score;

    public EmployeeInfoImpl(int id, String name, Role role, double salary, Score score) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.role = role;
        this.score = score;
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
        return "EmployeeInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", salary=" + salary +
                '}';
    }
}
