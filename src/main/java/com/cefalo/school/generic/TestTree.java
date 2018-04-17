package com.cefalo.school.generic;

import com.cefalo.school.calculator.*;

public class TestTree {
    public static void main(String[] args) {
        System.out.println("Testing generic tree");

        Tree<EmployeeInfo> tree = new CompositeTree<>();

        EmployeeInfo cto = tree.createNode(new EmployeeInfoImpl(1, "john the cto", Role.CTO, 100000, goodScore));

        EmployeeInfo pmJane = tree.createNode(new EmployeeInfoImpl(2, "jane the pm", Role.PROJECTMANAGER, 80000, goodScore));
        EmployeeInfo tlTim = tree.createNode(new EmployeeInfoImpl(4, "tim the tl", Role.TEAMLEAD, 70000, badScore));
        EmployeeInfo devDon = tree.createNode(new EmployeeInfoImpl(7, "don the dev", Role.DEVELOPER, 30000, goodScore));
        EmployeeInfo devDime = tree.createNode(new EmployeeInfoImpl(8, "dime the dev", Role.DEVELOPER, 40000, goodScore));

        EmployeeInfo tlTony = tree.createNode(new EmployeeInfoImpl(5, "tony the tl", Role.TEAMLEAD, 70000, goodScore));
        EmployeeInfo devDany = tree.createNode(new EmployeeInfoImpl(9, "dany the dev", Role.DEVELOPER, 50000, badScore));
        EmployeeInfo devDina = tree.createNode(new EmployeeInfoImpl(10, "dina the dev", Role.DEVELOPER, 60000, goodScore));


        EmployeeInfo pmJim = tree.createNode(new EmployeeInfoImpl(3, "jim the pm", Role.PROJECTMANAGER, 90000, badScore));
        EmployeeInfo tlTisha = tree.createNode(new EmployeeInfoImpl(6, "tisha the tl", Role.TEAMLEAD, 60000, goodScore));
        EmployeeInfo devDilu = tree.createNode(new EmployeeInfoImpl(11, "dilu the dev", Role.DEVELOPER, 40000, badScore));

        tree.makeChild(tlTim, devDon);
        tree.makeChild(tlTim, devDime);
        tree.makeChild(pmJane, tlTim);

        tree.makeChild(tlTony, devDany);
        tree.makeChild(tlTony, devDina);
        tree.makeChild(pmJane, tlTony);

        tree.makeChild(tlTisha, devDilu);
        tree.makeChild(pmJim, tlTisha);

        tree.makeChild(cto, pmJane);
        tree.makeChild(cto, pmJim);

        // Print the whole tree using forEach
//        tree.forEach(cto, System.out::println);

        // Find the sum of everyones salary using fold
        Double result = tree.fold(pmJane, 0.0, e -> e.getSalary(), (a, b) -> a + b);
        Double result2 = tree.fold(pmJim, 0.0, e -> e.getSalary(), (a, b) -> a + b);
        Double result3 = tree.fold(cto, 0.0, e -> e.getSalary(), (a, b) -> a + b);
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);

        Double newSalary = newSalary(cto);
        System.out.printf("newSalary cto = %.2f\n", newSalary);

        Double afterIncreaseTotal = tree.fold(cto, 0.0, e -> newSalary(e), (a, b) -> a + b);
        System.out.printf("afterIncreaseTotal = %.2f\n", afterIncreaseTotal);

        Double flatIncreaseTotal = tree.fold(cto, 0.0, e -> flatIncrease(e, 0.05), (a, b) -> a + b);
        System.out.printf("flatIncreaseTotal = %.2f\n", flatIncreaseTotal);

        System.out.println("END");
    }

    private static Double flatIncrease(EmployeeInfo emp, Double percentage) {
        return emp.getSalary() * (1 + percentage);
    }

    private static Double newSalary(EmployeeInfo emp) {
        ReviewCalculator reviewCalculator = new ReviewCalculator(emp.getSalary(), emp.getScore(), emp.getRole().getImpact());
        return reviewCalculator.calculate();
    }

    private static Score goodScore = new Score(8, 5, 9, 8, 9);
    private static Score badScore = new Score(5, 5, 5, 5, 6);
}
