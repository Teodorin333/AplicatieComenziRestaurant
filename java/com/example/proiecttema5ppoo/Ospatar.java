package com.example.proiecttema5ppoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa de back-end pentru lucrul cu bucatari si ospatari
 */
public class Ospatar {
    private String name;
    private List<IComanda> comenzi = new ArrayList<IComanda>();

    public Ospatar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IComanda> getComenzi() {
        return comenzi;
    }

    public void adaugaComanda(IComanda comanda) {
        comenzi.add(comanda);
    }

    public void trimiteComanda(){
        for(IComanda comanda : comenzi){
            comanda.prepara();
        }
        comenzi.clear();
    }
}
