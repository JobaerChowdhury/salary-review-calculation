package com.cefalo.school.common;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

public interface ReviewSystem {
    EmployeeInfo create(int id, String name, Role role, double salary, Score score);
    void addSubordinate(EmployeeInfo parent, EmployeeInfo child);
    void removeSubordinate(EmployeeInfo parent, EmployeeInfo child);
    double calculateSalary(EmployeeInfo employee);
    double calculateGroupSalary(EmployeeInfo empWithSub);

    void print(EmployeeInfo cto);
    double flatRaise(double percentage, EmployeeInfo empInfo);
}
