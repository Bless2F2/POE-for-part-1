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
    private int messageNumber;

    public Message(String recipient, String message, int messageNumber) {
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;
        this.messageID = generateID();
        this.messageHash = createMessageHash(messageNumber);
    }

    public Message() {
    this.recipient = "+27831234567";
    this.message = "Hi Mike, can you join us for dinner tonight?";
    this.messageNumber = 0;
    this.messageID = generateID();
    this.messageHash = createMessageHash(messageNumber);
}

    private String generateID() {
    Random rand = new Random();
    StringBuilder sb = new StringBuilder();
    sb.append(rand.nextInt(9) + 1); // first digit 1-9, so no leading 0
    for (int i = 1; i < 10; i++) {
        sb.append(rand.nextInt(10)); // next 9 digits 0-9
    }
    return sb.toString();

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
    return "Message successfully sent.";
}
        else if (choice == 2){
            return "Press 0 to delete message.";
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

    // This list remembers all stored messages while app is running
private static java.util.List<String> allStored = new java.util.ArrayList<>();

public void storeMessage() {
    try {
        String json = "{\"messageID\":\"" + messageID + "\",\"messageHash\":\"" + messageHash + "\",\"recipient\":\"" + recipient + "\",\"message\":\"" + message + "\"}";
        allStored.add(json);

        FileWriter writer = new FileWriter("storedMessages.json", false);
        writer.write("[\n");
        for (int i = 0; i < allStored.size(); i++) {
            writer.write(allStored.get(i));
            if (i < allStored.size() - 1) writer.write(",");
            writer.write("\n");
        }
        writer.write("]");
        writer.close();
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
}
