package com.cefalo.school;

import com.cefalo.school.calculator.CefaloReviewSystem;
import com.cefalo.school.calculator.ReviewSystem;
import com.cefalo.school.calculator.Score;
import com.cefalo.school.composite.*;

public class App {

    public static void main(String[] args) {
        testReviewSystem();
    }

    private static void testReviewSystem() {
        Score goodScore = new Score(8, 5, 9, 8, 9);
        Score badScore = new Score(5, 5, 5, 5, 6);

        ReviewSystem reviewSystem = new CefaloReviewSystem();
        EmployeeInfo cto = reviewSystem.create(1, "john the cto", Role.CTO, 100000, goodScore);

        EmployeeInfo pmJane = reviewSystem.create(2, "jane the pm", Role.PROJECTMANAGER, 80000, goodScore);
        EmployeeInfo pmJim = reviewSystem.create(3, "jim the pm", Role.PROJECTMANAGER, 90000, badScore);

        EmployeeInfo tlTim = reviewSystem.create(4, "tim the tl", Role.TEAMLEAD, 70000, badScore);
        EmployeeInfo tlTony = reviewSystem.create(5, "tony the tl", Role.TEAMLEAD, 70000, goodScore);
        EmployeeInfo tlTisha = reviewSystem.create(6, "tisha the tl", Role.TEAMLEAD, 60000, goodScore);

        EmployeeInfo devDon = reviewSystem.create(7, "don the dev", Role.DEVELOPER, 30000, goodScore);
        EmployeeInfo devDime = reviewSystem.create(8, "dime the dev", Role.DEVELOPER, 40000, goodScore);
        EmployeeInfo devDany = reviewSystem.create(9, "dany the dev", Role.DEVELOPER, 50000, badScore);
        EmployeeInfo devDina = reviewSystem.create(10, "dina the dev", Role.DEVELOPER, 60000, goodScore);
        EmployeeInfo devDilu = reviewSystem.create(11, "dilu the dev", Role.DEVELOPER, 40000, badScore);

        // Build hierarchy
        reviewSystem.addSubordinate(tlTim, devDon);
        reviewSystem.addSubordinate(tlTim, devDime);

        reviewSystem.addSubordinate(tlTony, devDany);
        reviewSystem.addSubordinate(tlTony, devDina);

        reviewSystem.addSubordinate(tlTisha, devDilu);

        reviewSystem.addSubordinate(pmJane, tlTim);
        reviewSystem.addSubordinate(pmJane, tlTony);
        reviewSystem.addSubordinate(pmJim, tlTisha);

        reviewSystem.addSubordinate(cto, pmJane);
        reviewSystem.addSubordinate(cto, pmJim);

        double ctoSalry = reviewSystem.calculateSalary(cto);
        System.out.printf("ctoSalry = %.2f\n", ctoSalry);

        double dinaSalry = reviewSystem.calculateSalary(devDina);
        System.out.printf("dinaSalry = %.2f\n", dinaSalry);
        double devGroupSalary = reviewSystem.calculateGroupSalary(devDina);
        System.out.printf("devGroupSalary = %.2f\n", devGroupSalary);

        double groupSalary = reviewSystem.calculateGroupSalary(cto);
        System.out.printf("groupSalary = %.2f\n", groupSalary);

    }
}
