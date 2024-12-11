package com.example.proiecttema5ppoo;

public class PizzaCarnivora implements IPizza{
    @Override
    public double calcPret() {
        return 23.5;
    }

    @Override
    public String descriere() {
        return "O pizza cu sunca, bacon si peperoni";
    }
}
