package com.cefalo.school;

import com.cefalo.school.calculator.Score;
import com.cefalo.school.composite.Developer;
import com.cefalo.school.composite.Employee;
import com.cefalo.school.composite.Manager;
import com.cefalo.school.composite.Role;

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

    private static void test() {
        Score score = new Score(8, 7, 9, 7, 9);
        Employee emp1=new Developer(20, "John", Role.DEVELOPER, 10000, score);
        Employee emp2=new Developer(21, "David", Role.DEVELOPER, 15000, score);
        Employee manager1=new Manager(2,"Daniel", Role.PROJECTMANAGER, 25000, score);
        manager1.add(emp1);
        manager1.add(emp2);
        Score score2 = new Score(9, 5, 8, 9, 8);
        Employee emp3=new Developer(31,"Michael", Role.DEVELOPER, 20000, score2);
        Manager generalManager=new Manager(3, "Mark", Role.CTO, 50000, score2);
        generalManager.add(emp3);
        generalManager.add(manager1);
        generalManager.print();
    }
}
