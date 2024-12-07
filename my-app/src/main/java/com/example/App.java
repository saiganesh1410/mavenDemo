package com.example;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Person person = new Person("John", 30);

        Gson gson = new Gson();

        String json = gson.toJson(person);

        System.out.println("JSON representation of the object: " + json);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters and Setters (optional)
    }
}

