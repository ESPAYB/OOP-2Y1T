package com.mycompany.m4a1_hilario;

// Abstract class representing a generic message
public abstract class Message {
    private String recipient;

    // Constructor to set recipient
    public Message(String recipient) {
        this.recipient = recipient;
    }

    // Getter for recipient
    public String getRecipient() {
        return recipient;
    }

    // Abstract method to be implemented by subclasses
    public abstract void send();
}
