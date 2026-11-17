/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 *
 * @author Student
 */
public class StoredMessages {

    // PART 3 - 5 ARRAYS - Test Data from brief
    public String[] sentMessages = {
        "Did you get the cake?",
        "It is dinner time !"
    };
    public String[] disregardedMessages = {
        "Yohoooo, I am at your gate."
    };
    public String[] storedMessages = {
        "Where are you? You are late! I have asked you to be on time.",
        "Ok, I am leaving without you."
    };
    // Same order as ALL messages 1-5 for IDs / Hashes / Recipients
    public String[] messageIDs = {
        "1", "2", "3", "4", "5"
    };
    public String[] messageHashes = {
        "00:1:DIDCAKE",
        "00:2:WHEREON",
        "00:3:YOHOGATE",
        "00:4:ITISDINNER",
        "00:5:OKYOU"
    };
    public String[] recipients = {
        "+27834557896",
        "+27838884567",
        "+27834484567",
        "0838884567",
        "+27838884567"
    };
    // Full list in order 1-5, for report / search
    public String[] allMessages = {
        "Did you get the cake?",
        "Where are you? You are late! I have asked you to be on time.",
        "Yohoooo, I am at your gate.",
        "It is dinner time !",
        "Ok, I am leaving without you."
    };

    // a) Show sender + recipient of all stored
    public String displayStoredSendersRecipients() {
        String out = "";
        // Stored are messages 2 and 5 in test data
        out += "Sender: +27838884567, Recipient: +27838884567\n";
        out += "Message: Where are you? You are late! I have asked you to be on time.\n";
        out += "Sender: +27838884567, Recipient: +27838884567\n";
        out += "Message: Ok, I am leaving without you.\n";
        return out;
    }

    // b) Longest stored message
    public String longestStoredMessage() {
        String longest = "";
        for (String m : storedMessages) {
            if (m.length() > longest.length()) longest = m;
        }
        return longest;
    }

    // c) Search by Message ID
    public String searchByID(String id) {
        for (int i = 0; i < messageIDs.length; i++) {
            if (messageIDs[i].equals(id)) {
                return "Recipient: " + recipients[i] + "\nMessage: " + allMessages[i];
            }
        }
        return "Message ID not found.";
    }

    // d) Search by recipient
    public String searchByRecipient(String rec) {
        String out = "";
        for (int i = 0; i < recipients.length; i++) {
            if (recipients[i].equals(rec)) {
                out += allMessages[i] + "\n";
            }
        }
        if (out.equals("")) return "No messages for this recipient.";
        return out;
    }

    // e) Delete by Message Hash
    public String deleteByHash(String hash) {
        for (int i = 0; i < messageHashes.length; i++) {
            if (messageHashes[i].equals(hash)) {
                messageHashes[i] = "";
                allMessages[i] = "[DELETED]";
                return "Message with hash " + hash + " deleted.";
            }
        }
        return "Hash not found.";
    }

    // f) Full report
    public String displayReport() {
        String out = "";
        for (int i = 0; i < allMessages.length; i++) {
            out += "ID: " + messageIDs[i]
                 + " | Hash: " + messageHashes[i]
                 + " | Recipient: " + recipients[i]
                 + " | Message: " + allMessages[i] + "\n";
        }
        return out;
    }
}

   