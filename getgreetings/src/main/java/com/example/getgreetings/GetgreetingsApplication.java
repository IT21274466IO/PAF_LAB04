package com.example.getgreetings;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetgreetingsApplication {

	private static RestTemplate httpClient = null;

	private static String baseURL = "http://localhost:8080/";

	private static String defaultGreetingURL = "greeting";
	private static String namedGreetingURL = "greeting/name?name=<your_name>";

	public static void main(String[] args) {
		SpringApplication.run(GetgreetingsApplication.class, args);
		makeCalls();
	}

	private static RestTemplate getHttpClient() {
		if (httpClient == null) {
			httpClient = new RestTemplate();
		}
		return httpClient;
	}

	private static Greetings getGreeting(String url){
		RestTemplate restmp = getHttpClient();
		return restmp.getForObject(baseURL + url, Greetings.class);
	}

	public static Greetings getGreetingByName(String name) {
		RestTemplate restmp = getHttpClient();
		return restmp.getForObject(baseURL + namedGreetingURL, Greetings.class, name);
	}

	private static void makeCalls(){
		// Existing code to retrieve greetings
		Greetings receivedGreeting1 = GetgreetingsApplication.getGreeting(defaultGreetingURL);
		Greetings receivedGreeting2 = GetgreetingsApplication.getGreetingByName(namedGreetingURL);
	
		String content1 = receivedGreeting1.content();
		System.out.println("Default Greeting: " + content1);
	
		String content2 = receivedGreeting2.content();
		System.out.println("Named Greeting: " + content2);
	
		// New code to retrieve greeting with date
		String greetingWithDateURL = "greetings/withDate";
		Greetings receivedGreetingWithDate = GetgreetingsApplication.getGreeting(greetingWithDateURL);
		String contentWithDate = receivedGreetingWithDate.content();
		LocalDate date = receivedGreetingWithDate.date(); // Access date directly from the Greetings record
		System.out.println("Greeting with Date: " + contentWithDate);
		System.out.println("Today's Date: " + date.toString());
	}
	
	
}
