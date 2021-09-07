package com.example.cdrapplication.Models;

public class Contact {
    private String callOrigin;
    private String callDialed;
    private int frequency;

    public Contact() {
    }

    public Contact(String callOrigin, String callDialed, int frequency) {
        this.callOrigin = callOrigin;
        this.callDialed = callDialed;
        this.frequency = frequency;
    }

    public String getCallOrigin() {
        return callOrigin;
    }

    public void setCallOrigin(String callOrigin) {
        this.callOrigin = callOrigin;
    }

    public String getCallDialed() {
        return callDialed;
    }

    public void setCallDialed(String callDialed) {
        this.callDialed = callDialed;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
