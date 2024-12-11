package com.example.proiecttema5ppoo;

public class PizzaCheesy implements IPizza{
    @Override
    public double calcPret() {
        return 22;
    }

    @Override
    public String descriere() {
        return "O pizza cu mozzarella, cascaval si branza albastra";
    }
}
