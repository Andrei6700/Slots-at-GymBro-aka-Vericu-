package com.example.pacanele;

public class InstructionsHandler {
    String title;
    String message;
    int image;

    public InstructionsHandler(String title, String message, int image) {
        this.title = title;
        this.message = message; // Updated to assign parameter to class variable
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {  // getGen
        return message;
    }


    public int getImage() {
        return image;
    }
}
