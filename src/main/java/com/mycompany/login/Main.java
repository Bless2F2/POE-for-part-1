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
        while (!username.contains("_") || username.length() > 5) {
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        System.out.print("Enter Username (must contain _ and max 5 chars): ");
        username = scanner.nextLine();
}
System.out.println(loginSystem.getUsernameMessage(username));

        System.out.print("Enter Password (8 chars, capital, number, special char): ");
        String password = scanner.nextLine();
        while (!loginSystem.checkPasswordComplexity(password)) {
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
        System.out.print("Enter Password (8 chars, capital, number, special char): ");
        password = scanner.nextLine();
}
        System.out.println(loginSystem.getPasswordMessage(password));

        System.out.print("Enter SA Cell Number (e.g. +27831234567): ");
        String cell = scanner.nextLine();
        while (!cell.startsWith("+27") || cell.length() != 12) {
        System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        System.out.print("Enter SA Cell Number (e.g. +27831234567): ");
        cell = scanner.nextLine();
}
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
            
                        // ---- PART 2 - QUICKCHAT (NO ARRAYS) ----
            if (loggedIn) {
                System.out.println("\n--- Welcome to QuickChat ---");
                Message messageSystem = new Message();
                boolean running = true;
                int messageCount = 0;

                while (running) {
                    System.out.println("\nMenu:\n1) Send Messages\n2) Show recently sent messages\n3) Quit");
                    System.out.print("Choose option: ");
                    String choiceStr = scanner.nextLine();
                    int choice = Integer.parseInt(choiceStr);

                    if (choice == 1) {
                        System.out.print("How many messages do you want to send? ");
                        int howMany = Integer.parseInt(scanner.nextLine());

                        for (int i = 1; i <= howMany; i++) {
                            System.out.print("Enter recipient cell (e.g. +27831234567): ");
                            String rec = scanner.nextLine();
                            while (!rec.startsWith("+") || rec.length() < 10) {
    System.out.println("Cell phone number is incorrectly formatted. Please try again.");
    System.out.print("Enter recipient cell (e.g. +27831234567): ");
    rec = scanner.nextLine();
}
                    System.out.print("Enter message (max 250 chars): ");
                   String txt = scanner.nextLine();
                   while (txt.length() > 250) {
                   System.out.println("Message exceeds 250 characters. Please try again.");
                   System.out.print("Enter message (max 250 chars): ");
                  txt = scanner.nextLine();
                  }

                            Message m = new Message(rec, txt, i);
                            System.out.println(m.checkRecipientCell());
                            System.out.println(m.checkMessageLength());
                            
                            System.out.println("1) Send  2) Disregard  3) Store to send later");
                            int opt = Integer.parseInt(scanner.nextLine());
                            String result = m.SentMessage(opt);
                            System.out.println(result);
                            
                            if (result.equals("Message successfully sent.")) {
                                System.out.println("Message ID: " + m.getMessageID());
                             System.out.println("Message Hash:" + m.createMessageHash(i));
                             System.out.println("Recipient: " + rec);
                             System.out.println("Message: " + txt);
                                messageCount++;
                               
                            }
                        }

                    } else if (choice == 2) {
                        System.out.println("Coming soon.");
                    } else if (choice == 3) {
                        running = false;
                        System.out.println("Total messages sent: " + messageCount);
                        System.out.println("Quitting QuickChat...");
                    } else {
                        System.out.println("Invalid option");
                    }
                }
            }
        }
        }
}