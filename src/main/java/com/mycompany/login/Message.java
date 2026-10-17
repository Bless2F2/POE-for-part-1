/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private static int totalMessages = 0;
    private static String allMessages = "";

    public Message(String recipient, String message, int messageNumber) {
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateID();
        this.messageHash = createMessageHash(messageNumber);
    }

    public Message() {
        this.messageID = generateID();
        this.message = "Hi Mike, can you join us for dinner tonight?";
    }

    private String generateID() {
        Random rand = new Random();
        long num = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(num);
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public String checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+") && recipient.length() >= 10 && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String checkMessageLength() {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int over = message.length() - 250;
            return "Message exceeds 250 characters by " + over + ", please reduce size.";
        }
    }

    public String createMessageHash(int msgNumber) {
    String firstTwo = messageID.substring(0, 2);
    String trimmed = message.trim();
    
    // first word without array
    int firstSpace = trimmed.indexOf(" ");
    String firstWord;
    if (firstSpace == -1) {
        firstWord = trimmed;
    } else {
        firstWord = trimmed.substring(0, firstSpace);
    }
    
    // last word without array
    int lastSpace = trimmed.lastIndexOf(" ");
    String lastWord;
    if (lastSpace == -1) {
        lastWord = trimmed;
    } else {
        lastWord = trimmed.substring(lastSpace + 1);
    }
    
    String first = firstWord.replaceAll("[^A-Za-z]", "").toUpperCase();
    String last = lastWord.replaceAll("[^A-Za-z]", "").toUpperCase();
    
    return firstTwo + ":" + msgNumber + ":" + first + last;
}

    public String createMessageHash(String fixedID, int msgNumber, String fixedMessage) {
        this.messageID = fixedID;
        this.message = fixedMessage;
        return createMessageHash(msgNumber);
    }

    public String SentMessage(int choice) {
        if (choice == 1) {
            totalMessages++;
            allMessages = allMessages + messageHash + " To: " + recipient + " | " + message + "\n";
            storeMessage();
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete the message.";
        } else {
            storeMessage();
            return "Message successfully stored.";
        }
    }

    public String printMessages() {
        if (allMessages.equals("")) return "No messages sent.";
        return allMessages;
    }

    public int returnTotalMessages() {
        return totalMessages;
    }

        public void storeMessage() {
        try {
            FileWriter writer = new FileWriter("storedMessages.json", true);
            String json = "{\"messageID\":\"" + messageID + "\",\"messageHash\":\"" + messageHash + "\",\"recipient\":\"" + recipient + "\",\"message\":\"" + message.replace("\"", "'") + "\"}\n";
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
}
