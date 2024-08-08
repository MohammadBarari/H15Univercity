package org.example.Menu;

import org.example.Entity.BaseEmployee;

import java.util.Scanner;
import java.util.function.Predicate;

public class Menu {
    public static void main(String[] args) {
        System.out.println("FOR STUDENT PRESS 1 FOR TEACHER PRESS 2 AND FOR EMPLOYEE PRESS 3");
        Scanner sc = new Scanner(System.in);
        int pressInteger = sc.nextInt();
        switch (pressInteger) {
            case 3:{
                BaseEmployee emp = new BaseEmployee();
                System.out.println("Enter Employee userName = : ");
                sc.nextLine();
                emp.setUsername(sc.nextLine());
                System.out.println("Enter Employee password = : ");
                emp.setPassword(sc.nextLine());
                EmployeeMenu employeeMenu = new EmployeeMenu();
                if (employeeMenu.validate(emp)){
               employeeMenu.Login();
                }
            }

        }
    }
}
