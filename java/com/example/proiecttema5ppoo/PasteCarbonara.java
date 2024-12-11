package com.example.proiecttema5ppoo;

public class PasteCarbonara implements IPizza{

    @Override
    public double calcPret() {
        return 30.5;
    }

    @Override
    public String descriere() {
        return "Paste carbonara facute cu smantana de casa";
    }
}
