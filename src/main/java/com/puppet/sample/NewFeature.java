package com.puppet.sample;

public class NewFeature {

    public String getWelcomeMessage(String userName) {
        return "Welcome to the WebApp, " + userName + "!";
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
