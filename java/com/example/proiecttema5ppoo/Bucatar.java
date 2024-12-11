package com.example.proiecttema5ppoo;

/**
 * Clasa de back-end pentru lucrul cu bucatari si ospatari
 */
public class Bucatar {
    private String nume;
    //add queue


    public Bucatar(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void gatesteComanda(Produs produs){
        System.out.println(this.nume + " gateste " + produs.toString());
    }
}
