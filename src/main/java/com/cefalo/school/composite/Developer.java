package com.cefalo.school.composite;

import com.cefalo.school.calculator.Role;
import com.cefalo.school.calculator.Score;

public class Developer extends AbstractEmployee {
    public Developer(int id, String name, Role role, double salary, Score score) {
        super(id, name, role, salary, score);
    }

    public void add(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }

    public Employee getChild(int i) {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }

    @Override
    public double calculateGroupSalary() {
        return calculateSalary();
    }

    public void remove(Employee employee) {
        //this is leaf node so this method is not applicable to this class.
    }
}