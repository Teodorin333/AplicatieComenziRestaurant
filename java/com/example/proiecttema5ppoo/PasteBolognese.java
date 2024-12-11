package com.example.proiecttema5ppoo;

public class PasteBolognese implements IPizza{
    @Override
    public double calcPret() {
        return 29.5;
    }

    @Override
    public String descriere() {
        return "Paste bolognese cu sos pomodoro fresh";
    }
}
