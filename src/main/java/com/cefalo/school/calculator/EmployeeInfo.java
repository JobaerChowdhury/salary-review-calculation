package com.cefalo.school.calculator;

public interface EmployeeInfo extends Identity {
    public String getName();

    public double getSalary();

    public Role getRole();

    public Score getScore();
}