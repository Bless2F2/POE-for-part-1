/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.login;


/**
 *
 * @author Student
 */
public class Login {
    
        private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method 1: Check username
    public boolean checkUserName(String username) {
        // Must contain _ and be no more than 5 chars
        return username.contains("_") && username.length() <= 5;
    }

    // Method 2: Check password complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasLength = password.length() >= 8;
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        
        return hasLength && hasCapital && hasNumber && hasSpecial;
    }

    // Method 3: Check cell phone number with regex
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Must contain international code +27 and be no more than 10 chars long after code
        // Format: +27831234567 (12 chars including +) or +27 + 9 digits
        String regex = "^\\+27\\d{9}$";
        return cellNumber.matches(regex);
    }

    // Method 4: Register user - returns messages from your brief
    public String registerUser(String username, String password, String cellNumber) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellNumber;

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Welcome " + firstName + ", " + lastName + " it is great to see you.";
    }

    // Method 5: Verify login details match registration
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }

    // Method 6: Return login status message
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Extra helper messages required for Part 1a table
    public String getUsernameMessage(String username){
        if(checkUserName(username)){
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }

    public String getPasswordMessage(String password){
        if(checkPasswordComplexity(password)){
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }

    public String getCellPhoneMessage(String cell){
        if(checkCellPhoneNumber(cell)){
            return "Cell phone number successfully added.";
        } else {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
    }
}

        
     

    
    