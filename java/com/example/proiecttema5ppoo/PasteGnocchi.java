package com.example.proiecttema5ppoo;

public class PasteGnocchi implements IPizza{
    @Override
    public double calcPret() {
        return 35;
    }

    @Override
    public String descriere() {
        return "Paste gnocchi cu sos pesto";
    }
}
