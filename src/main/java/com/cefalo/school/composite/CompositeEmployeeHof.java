package com.cefalo.school.composite;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CompositeEmployeeHof extends EmployeeImpl {
    private List<Employee> employees = new ArrayList<>();

    public CompositeEmployeeHof(int id, String name, Role role, double salary, Score score) {
        super(id, name, role, salary, score);
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public double calculateGroupSalary() {
        return fold(calculateSalary(), emp -> emp.calculateGroupSalary(), (a, b) -> a + b);
    }

    @Override
    public double flatRaise(double percentage) {
        return fold(super.flatRaise(percentage), e -> e.flatRaise(percentage), (a, b) -> a + b);
    }

    @Override
    public String print() {
        return fold(super.print(), emp -> emp.print(), (s1, s2) -> s1 + "\n" + s2);
    }

    private <T> T fold(
            T initialValue,
            Function<Employee, T> iteration,
            BiFunction<T, T, T> combiner
    ) {
        T result = initialValue;
        for (Employee emp : employees) {
            T val = iteration.apply(emp);
            result = combiner.apply(result, val);
        }
        return result;
    }

    public void remove(Employee employee) {
        //todo this is not the correct way, since it may remove an employee with his subordinates, which we don't want
        employees.remove(employee);
    }
}