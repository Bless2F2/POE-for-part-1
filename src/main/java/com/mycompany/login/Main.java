/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Main {
    
        public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        Login loginSystem = new Login(firstName, lastName);

        System.out.print("Enter Username (must contain _ and max 5 chars): ");
        String username = scanner.nextLine();
        System.out.println(loginSystem.getUsernameMessage(username));

        System.out.print("Enter Password (8 chars, capital, number, special char): ");
        String password = scanner.nextLine();
        System.out.println(loginSystem.getPasswordMessage(password));

        System.out.print("Enter SA Cell Number (e.g. +27831234567): ");
        String cell = scanner.nextLine();
        System.out.println(loginSystem.getCellPhoneMessage(cell));

        String registrationResult = loginSystem.registerUser(username, password, cell);
        System.out.println(registrationResult);

        // Only allow login if registration was successful
        if (registrationResult.startsWith("Welcome")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter username to login: ");
            String loginU = scanner.nextLine();
            System.out.print("Enter password to login: ");
            String loginP = scanner.nextLine();

            boolean loggedIn = loginSystem.loginUser(loginU, loginP);
            System.out.println(loginSystem.returnLoginStatus(loggedIn));
        }
        }
}