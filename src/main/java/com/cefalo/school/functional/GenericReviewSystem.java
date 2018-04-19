package com.cefalo.school.functional;

import com.cefalo.school.calculator.ReviewCalculator;
import com.cefalo.school.common.Role;
import com.cefalo.school.calculator.Score;
import com.cefalo.school.common.EmployeeInfo;
import com.cefalo.school.common.EmployeeInfoImpl;
import com.cefalo.school.common.ReviewSystem;
import com.cefalo.school.generic.CompositeTree;
import com.cefalo.school.generic.Tree;

/**
 * A ReviewSystem implementation based on the generic tree package.
 * <p>
 * Created by jobaer on Apr-18-2018.
 */
public class GenericReviewSystem implements ReviewSystem {
    private Tree<EmployeeInfo> tree = new CompositeTree<>();

    @Override
    public EmployeeInfo create(int id, String name, Role role, double salary, Score score) {
        return tree.createNode(new EmployeeInfoImpl(id, name, role, salary, score));
    }

    @Override
    public void addSubordinate(EmployeeInfo parent, EmployeeInfo child) {
        tree.makeChild(parent, child);
    }

    @Override
    public void removeSubordinate(EmployeeInfo parent, EmployeeInfo child) {
        tree.removeOnlyChild(parent, child);
    }

    @Override
    public double calculateSalary(EmployeeInfo employee) {
        return newSalary(employee);
    }

    @Override
    public double calculateGroupSalary(EmployeeInfo empWithSub) {
        return tree.fold(empWithSub, 0.0, e -> newSalary(e), (a, b) -> a + b);
    }

    @Override
    public void print(EmployeeInfo emp) {
        tree.forEach(emp, System.out::println);
    }

    @Override
    public double flatRaise(double percentage, EmployeeInfo emp) {
        return tree.fold(emp, 0.0, e -> flatIncrease(e, percentage), (a, b) -> a + b);
    }

    private static Double flatIncrease(EmployeeInfo emp, Double percentage) {
        return emp.getSalary() * (1 + percentage);
    }

    private static Double newSalary(EmployeeInfo emp) {
        ReviewCalculator reviewCalculator = new ReviewCalculator(emp.getSalary(), emp.getScore(), emp.getRole().impact);
        return reviewCalculator.calculate();
    }

}
