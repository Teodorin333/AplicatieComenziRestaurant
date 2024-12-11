package com.example.proiecttema5ppoo;

public class PizzaVegana implements IPizza {

    @Override
    public double calcPret() {
        return 21.5;
    }

    @Override
    public String descriere() {
        return "O pizza vegana cu rosii, ceapa si ardei";
    }
}
