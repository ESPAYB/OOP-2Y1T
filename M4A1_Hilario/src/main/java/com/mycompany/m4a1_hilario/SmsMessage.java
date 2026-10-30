package com.mycompany.m4a1_hilario;

// Concrete implementation for SMS messages
public class SmsMessage extends Message implements Trackable {

    public SmsMessage(String recipient) {
        super(recipient);
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + getRecipient() + ": \"Campus Notice: Midterm exam schedule has been released.\"");
    }

    @Override
    public void showStatus() {
        System.out.println("SMS Status: Sent via Cellular Network to " + getRecipient());
    }
}
