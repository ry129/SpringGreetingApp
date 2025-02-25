package com.greetingapp.Service;
import com.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;


import com.greetingapp.repository.GreetingRepository;

import java.util.List;
import java.util.Optional;


@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World!";
        }
        // Save to database
        Greeting greeting = new Greeting(message);
        Greeting savedGreeting = greetingRepository.save(greeting);
        return "Saved with ID: " + savedGreeting.getID();
    }

    //Method to fetch a greeting by id from the repository
    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public void deleteGreeting(Long id){
        Optional<Greeting> existinggreeting = greetingRepository.findById(id);
        if (existinggreeting.isPresent()) {
            greetingRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("greeting with id : " + id + "not found.");
        }
    }
}