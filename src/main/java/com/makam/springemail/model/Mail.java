package com.makam.springemail.model;

import java.util.Arrays;

public class Mail {
    private String[] to;
    private String subject;
    private String text;
    private String[] bcc;

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String getString() {
        String message = "to: " + Arrays.toString(this.to) +
                ", subject: " + this.subject +
                ", text: " + this.text;
        return message;
    }
}
