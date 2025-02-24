package com.greetingapp.Service;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getgreetingMessage(String firstName, String lastName) {
        if(firstName!=null && lastName!=null) {
            return  "Hello" + firstName + " " + lastName;
        }
        else if(firstName!=null) {
            return  "Hello " + firstName;
        }
        else if(lastName!=null) {
            return  "Hello " + lastName;
        }
        return "Hello World";

    }
}
