package com.mycompany.m4a1_hilario;

public class MessageDemo {
    public static void main(String[] args) {
        // Instantiate one EmailMessage and one SmsMessage
        EmailMessage email = new EmailMessage("student@university.edu");
        SmsMessage sms = new SmsMessage("+639123456789");

        // Store both objects in a Message[] array (Upcasting)
        Message[] messages = new Message[]{ email, sms };

        System.out.println("--- Broadcasting Campus Notice ---");
        // Loop through the Message[] array and execute send() polymorphically
        for (Message msg : messages) {
            msg.send(); // Dynamic Dispatch selects the appropriate send() method at runtime
        }

        System.out.println("\n--- Tracking Status ---");
        // Using a Trackable reference to call showStatus()
        Trackable trackableEmail = email;
        trackableEmail.showStatus();

        Trackable trackableSms = sms;
        trackableSms.showStatus();
    }
}