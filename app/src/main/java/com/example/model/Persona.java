package com.example.model;

public class Persona {
    String name;

    public Persona(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
