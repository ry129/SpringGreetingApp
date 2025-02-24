package com.greetingapp.Service;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getgreeting() {
        return "Hello From Greeting Service";
    }


}
