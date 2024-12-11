package com.example.proiecttema5ppoo;

public class PizzaMargherita implements IPizza {

    @Override
    public double calcPret() {
        return 20;
    }

    @Override
    public String descriere() {
        return "O pizza margherita";
    }
}
