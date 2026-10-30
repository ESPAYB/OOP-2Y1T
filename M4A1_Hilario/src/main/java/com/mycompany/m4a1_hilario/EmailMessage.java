package com.mycompany.m4a1_hilario;

// Concrete implementation for Email messages
public class EmailMessage extends Message implements Trackable {
    
    public EmailMessage(String recipient) {
        super(recipient);
    }

    @Override
    public void send() {
        System.out.println("Sending EMAIL to " + getRecipient() + ": \"Campus Notice: Midterm exam schedule has been released.\"");
    }

    @Override
    public void showStatus() {
        System.out.println("Email Status: Delivered to mail server for " + getRecipient());
    }
}
