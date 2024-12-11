package com.example.proiecttema5ppoo;

/**
 * Clasa de back-end pentru lucurul cu bucatari si ospatari.
 * Implementeaza design pattern-ul de Command
 */
public class Comanda implements IComanda{
    private Bucatar bucatar;
    private Produs produs;

    public Comanda(Bucatar bucatar, Produs produs) {
        this.bucatar = bucatar;
        this.produs = produs;
    }

    public Comanda(Produs produs){
        this.produs = produs;
        this.bucatar = null;
    }

    @Override
    public void prepara() {
        bucatar.gatesteComanda(produs);
    }
}
