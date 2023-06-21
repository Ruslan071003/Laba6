package com.example.myfriendofmisery;

public class Document extends Package {
    private final String sender;
    private final String recipient;

    public Document(String sender, String recipient) {
        super("Documents", false, "None");
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}
