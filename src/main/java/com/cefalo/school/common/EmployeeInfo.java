package com.cefalo.school.common;

import com.cefalo.school.calculator.Score;

public interface EmployeeInfo extends Identity {
    String getName();

    double getSalary();

    Role getRole();

    Score getScore();
}