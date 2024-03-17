package com.example.getgreetings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/withDate")
    public GreetingWithDate getGreetingWithDate() {
        LocalDate today = LocalDate.now();
        String content = "Hello, today is " + today.toString();
        return new GreetingWithDate(content, today);
    }
}
