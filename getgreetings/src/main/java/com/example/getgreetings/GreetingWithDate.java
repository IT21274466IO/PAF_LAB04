package com.example.getgreetings;

import java.time.LocalDate;

public class GreetingWithDate {
    private String greetings;
    private LocalDate date;

    public GreetingWithDate(String content, LocalDate date) {
        this.greetings = content;
        this.date = date;
    }

    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
