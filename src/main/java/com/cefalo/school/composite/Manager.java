package com.cefalo.school.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager implements Employee{

    private int id;
    private String name;
    private Role role;
    private double salary;

    public Manager(int id, String name, Role role, double salary){
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    List<Employee> employees = new ArrayList<Employee>();
    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee getChild(int i) {
        return employees.get(i);
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

    public void print() {
        System.out.println(this);

        Iterator<Employee> employeeIterator = employees.iterator();
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            employee.print();
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", salary=" + salary +
                '}';
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }
}