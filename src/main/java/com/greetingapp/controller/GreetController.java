package com.greetingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.greetingapp.Service.GreetingService;
import java.util.Map;


@RestController
@RequestMapping("/greeting")
public class GreetController {
    private final GreetingService greetingServices;
    @Autowired
    public GreetController(GreetingService greetingServices) {
        this.greetingServices = greetingServices;
    }
    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required=false)String firstName,@RequestParam(required=false)String lastName) {
        return  Map.of("message", greetingServices.getgreetingMessage(firstName,lastName));
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
