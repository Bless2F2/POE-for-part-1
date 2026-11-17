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
public class StoredMessagesTest {
    
    @Test
    public void testDisplayStoredSendersRecipients() {
        StoredMessages sm = new StoredMessages();
        String result = sm.displayStoredSendersRecipients();
        assertTrue(result.contains("+27838884567"));
        assertTrue(result.contains("Where are you?"));
    }

    @Test
    public void testLongestStoredMessage() {
        StoredMessages sm = new StoredMessages();
        String result = sm.longestStoredMessage();
        assertTrue(result.contains("Where are you? You are late!"));
    }

    @Test
    public void testSearchByRecipient() {
        StoredMessages sm = new StoredMessages();
        String result = sm.searchByRecipient("+27838884567");
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDisplayReport() {
        StoredMessages sm = new StoredMessages();
        String result = sm.displayReport();
        assertTrue(result.contains("Where are you?"));
        assertTrue(result.contains("Ok, I am leaving"));
    }

    @Test
    public void testSearchByInvalidID() {
        StoredMessages sm = new StoredMessages();
        String result = sm.searchByID("9999999999");
        assertTrue(result.toLowerCase().contains("not found"));
    }

    @Test
    public void testDeleteByInvalidHash() {
        StoredMessages sm = new StoredMessages();
        String result = sm.deleteByHash("INVALIDHASH");
        assertTrue(result.toLowerCase().contains("not found"));
    }
}
    
    

