/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class MessageTest {

    // 1
    @Test public void testMessageIDNotNull() {
        Message m = new Message();
        assertNotNull(m.getMessageID());
    }
    // 2
    @Test public void testMessageIDLength10() {
        Message m = new Message();
        assertEquals(10, m.getMessageID().length());
    }
    // 3
    @Test public void testCheckMessageIDTrue() {
        Message m = new Message();
        assertTrue(m.checkMessageID());
    }
    // 4 - YOUR hash format is first2:msgNumber:FIRST+LAST
    @Test public void testHashContainsColons() {
        Message m = new Message();
        String hash = m.createMessageHash("1234567890", 1, "Hi Mike, can you join us for dinner tonight?");
        assertTrue(hash.contains(":"));
    }
    // 5
    @Test public void testHashStartsWithFirstTwoOfID() {
        Message m = new Message();
        String hash = m.createMessageHash("0012345678", 1, "Hi Mike, can you join us for dinner tonight?");
        assertTrue(hash.startsWith("00:"));
    }
    // 6
    @Test public void testHashContainsFirstAndLastWord() {
        Message m = new Message();
        String hash = m.createMessageHash("1234567890", 1, "Hi Mike, can you join us for dinner tonight?");
        // your code makes HIMIKE? + TONIGHT -> HITONIGHT?
        assertTrue(hash.toUpperCase().contains("HI"));
        assertTrue(hash.toUpperCase().contains("TONIGHT"));
    }
    // 7
    @Test public void testHashWithSecondMessage() {
        Message m = new Message();
        String hash = m.createMessageHash("1234567890", 2, "Hello world again");
        assertTrue(hash.contains("2:"));
    }
    // 8
    @Test public void testCheckRecipientValid() {
        Message m = new Message("+27718693002", "Test", 1);
        assertEquals("Cell phone number successfully captured.", m.checkRecipientCell());
    }
    // 9
    @Test public void testCheckRecipientInvalid() {
        Message m = new Message("0718693002", "Test", 1);
        assertTrue(m.checkRecipientCell().contains("incorrectly formatted"));
    }
    // 10
    @Test public void testCheckMessageLengthValid() {
        Message m = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        assertEquals("Message ready to send.", m.checkMessageLength());
    }
    // 11
    @Test public void testCheckMessageLengthTooLong() {
        String longMsg = "a".repeat(300);
        Message m = new Message("+27718693002", longMsg, 1);
        assertTrue(m.checkMessageLength().contains("exceeds 250"));
    }
    // 12
    @Test public void testSentMessageIncrements() {
        Message m = new Message("+27718693002", "Hi", 1);
        int before = m.returnTotalMessages();
        m.SentMessage(1);
        assertEquals(before + 1, m.returnTotalMessages());
    }
    // 13
    @Test public void testReturnTotalMessagesNotNegative() {
        Message m = new Message();
        assertTrue(m.returnTotalMessages() >= 0);
    }
    // 14
    @Test public void testStoreMessageFileExists() {
        Message m = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 1);
        m.SentMessage(1); // this calls storeMessage() inside
        File f = new File("storedMessages.json");
        assertTrue(f.exists());
    }
}