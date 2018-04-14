package com.cefalo.school.composite;

import com.cefalo.school.calculator.Score;

public interface Employee extends EmployeeInfo {
    public void add(Employee employee);

    public void remove(Employee employee);

    public Employee getChild(int i);

    public void print();
}