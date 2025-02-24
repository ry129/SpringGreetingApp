package com.greetingapp.Service;
import com.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.greetingapp.repository.GreetingRepository;


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
       Greeting greeting = new Greeting();
        Greeting savedGreeting = greetingRepository.save(greeting);
        return "Saved Id : " + savedGreeting.getID();
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}