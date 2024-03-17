package com.example.greetings_api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong count = new AtomicLong();

    @GetMapping("/greeting")
    public Greetings greeting() {
        return new Greetings(count.incrementAndGet(), String.format(template, "World"));
    }

    @GetMapping("/greeting/name")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "<Your name>") String name) {
        return new Greetings(count.incrementAndGet(), String.format(template, name));
    }
}
