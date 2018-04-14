package com.cefalo.school.calculator;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

public interface EmployeeInfo {
    public String getName();

    public double getSalary();

    public int getId();

    public Role getRole();

    public Score getScore();

}