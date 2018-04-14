package com.cefalo.school.composite;

public interface Employee {
    public void add(Employee employee);

    public void remove(Employee employee);

    public Employee getChild(int i);

    public String getName();

    public double getSalary();

    public int getId();

    public Role getRole();

    public void print();
}