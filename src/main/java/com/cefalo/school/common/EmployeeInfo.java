package com.cefalo.school.common;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

public interface EmployeeInfo extends Identity {
    public String getName();

    public double getSalary();

    public Role getRole();

    public Score getScore();
}