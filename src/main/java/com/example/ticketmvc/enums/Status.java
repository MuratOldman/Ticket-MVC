package com.example.ticketmvc.enums;

public enum Status {
    OPEN("Open"),IN_PROGRESS("In Progress"),COMPLETE("Completed");

    private final String value;

    private String getValue() {
        return value;
    }

    Status(String value) {
        this.value = value;
    }
}
