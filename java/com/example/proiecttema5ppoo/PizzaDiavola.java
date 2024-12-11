package com.example.proiecttema5ppoo;

public class PizzaDiavola implements IPizza {
    @Override
    public double calcPret() {
        return 23.5;
    }

    @Override
    public String descriere() {
        return "O pizza cu salam, sos picant si ardei iuti";
    }
}
