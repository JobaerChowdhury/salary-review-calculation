package com.cefalo.school;

import com.cefalo.school.composite.Developer;
import com.cefalo.school.composite.Employee;
import com.cefalo.school.composite.Manager;

public class App {

    public static void main(String[] args) {
        /*Team 1*/
        /*Score tl1Score = new Score(8, 3, 2, 7, 10);
        TeamLeader emp4 = new TeamLeader("TL 1", "NV", 15000, tl1Score);

        Score devScore = new Score(8, 3, 2, 7, 10);
        Developer dev1 = new Developer("Dev 1", "GB", 10000, devScore);
        Developer dev2 = new Developer("Dev 2", "GB", 20000, devScore);
        Developer dev3 = new Developer("Dev 3", "GB", 30000, devScore);*/

        /*Team 2*/
        /*Score tlScore = new Score(8, 3, 2, 7, 10);
        TeamLeader emp4 = new TeamLeader("TL 2", "NV", 15000, tlScore);

        Score devScore = new Score(8, 3, 2, 7, 10);
        Developer dev4 = new Developer("Dev 3", "GB", 10000, devScore);
        Developer emp5 = new Developer("Dev 4", "GB", 20000, devScore);
        Developer emp6 = new Developer("Dev 5", "GB", 30000, devScore);*/

        test();
    }

    public static void test() {
        Employee emp1=new Developer("John", 10000);
        Employee emp2=new Developer("David", 15000);
        Employee manager1=new Manager("Daniel",25000);
        manager1.add(emp1);
        manager1.add(emp2);
        Employee emp3=new Developer("Michael", 20000);
        Manager generalManager=new Manager("Mark", 50000);
        generalManager.add(emp3);
        generalManager.add(manager1);
        generalManager.print();
    }
}
