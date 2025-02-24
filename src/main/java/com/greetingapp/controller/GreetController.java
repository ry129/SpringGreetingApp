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

    public GreetController(GreetingService greetingServices) {
        this.greetingServices = greetingServices;
    }
    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required=false)String firstName,@RequestParam(required=false)String lastName) {
        return  Map.of("message", greetingServices.getGreetingMessage(firstName,lastName));
    }
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingServices.getGreetingById(id);
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> body) {
        return Map.of("message", "Hello POST Request! ", "data", body.get("name"));
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> body) {
        return Map.of("message", "Hello PUT Request!", "data", body.get("name"));
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Hello, DELETE Request!");
    }
}
