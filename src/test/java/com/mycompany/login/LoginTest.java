/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
        
            Login login = new Login("blessing", "selowa");

            
    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        assertTrue(login.checkUserName("bee_e"));
    }
    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("Bless_ing")); 
    }
    
    @Test
    public void testCheckPasswordComplexityMeets() {
        assertTrue(login.checkPasswordComplexity("Imbadinlove2@"));
    }
    @Test
    public void testCheckPasswordComplexityTooShort() {
        assertFalse(login.checkPasswordComplexity("Ab2@")); 
    }
    @Test
    public void testCheckPasswordComplexityNoCapital() {
        assertFalse(login.checkPasswordComplexity("imbadinlove2@")); 
    }
    @Test
    public void testCheckPasswordComplexityNoNumber() {
        assertFalse(login.checkPasswordComplexity("Imbadinlove@"));
    }
    @Test
    public void testCheckPasswordComplexityNoSpecial() {
        assertFalse(login.checkPasswordComplexity("Imbadinlove2"));
    }

    
    @Test
    public void testCheckCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27810473075"));
    }
    @Test
    public void testCheckCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("0810473075")); 
    }

    
    @Test
    public void testRegisterUserSuccessMessage() {
        String result = login.registerUser("bee_e", "Imbadinlove2@", "+27810473075");
        assertEquals("Welcome blessing, selowa it is great to see you.", result);
    }
    @Test
    public void testRegisterUserInvalidUsernameMessage() {
        String result = login.registerUser("Bless_ing", "Imbadinlove2@", "+27810473075");
        assertTrue(result.contains("Username is not correctly formatted"));
    }
    @Test
    public void testRegisterUserInvalidPasswordMessage() {
        String result = login.registerUser("bee_e", "password", "+27810473075");
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    
    @Test
    public void testReturnLoginStatusSuccess() {
        login.registerUser("bee_e", "Imbadinlove2@", "+27810473075");
        boolean loggedIn = login.loginUser("bee_e", "Imbadinlove2@");
        assertEquals("Welcome blessing, selowa it is great to see you again.", login.returnLoginStatus(loggedIn));
    }
    @Test
    public void testReturnLoginStatusFailed() {
        login.registerUser("bee_e", "Imbadinlove2@", "+27810473075");
        boolean loggedIn = login.loginUser("bee_e", "wrong");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(loggedIn));
    }
}
            
    

    
    

