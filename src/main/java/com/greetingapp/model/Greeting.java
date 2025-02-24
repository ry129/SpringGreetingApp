package com.greetingapp.model;
import jakarta.persistence.*;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ID;
    private String message;
    public Greeting() {
    }
    public Greeting(String message) {
        this.message = message;
    }
    public long getID() {
        return ID;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
