package com.cefalo.school.calculator;

public interface ReviewSystem {
    EmployeeInfo create(int id, String name, Role role, double salary, Score score);
    void addSubordinate(EmployeeInfo parent, EmployeeInfo child);
    void removeSubordinate(EmployeeInfo parent, EmployeeInfo child);
    double calculateSalary(EmployeeInfo employee);
    double calculateGroupSalary(EmployeeInfo empWithSub);
}
