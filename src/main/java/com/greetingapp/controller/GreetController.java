
package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.greetingapp.Service.GreetingService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetController {
    private final GreetingService greetingServices;

    @Autowired
    public GreetController(GreetingService greetingServices) {
        this.greetingServices = greetingServices;
    }

    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required = false) String firstName,@RequestParam(required = false) String lastName) {
        return  Map.of("message", greetingServices.getGreetingMessage(firstName, lastName));
    }

    // Taking id from the user
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingServices.getGreetingById(id);
    }

    @GetMapping("/getall")
    public List<Greeting> getAllGreeting() {
        return greetingServices.getAllGreetings();
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> body) {
        return Map.of("message", "Hello POST Request! ", "data", body.get("name"));
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> body) {
        return Map.of("message", "Hello PUT Request!", "data", body.get("name"));
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteGreetings(@PathVariable Long id) {
        greetingServices.deleteGreeting(id);
        return Map.of("message", "Deleted Greeting with id: " + id + " deleted successfully.");
    }
}
