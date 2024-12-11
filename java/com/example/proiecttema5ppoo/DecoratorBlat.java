package com.example.proiecttema5ppoo;

/**
 * Decorator folosit pentru adaugarea optiunii de Blat la pizza
 */
public class DecoratorBlat extends ADecoratorPizza{
    Blat blat;

    public DecoratorBlat(IPizza pizza, Blat blat) {
        super(pizza);
        this.blat = blat;
    }

    public DecoratorBlat(IPizza pizza) {
        super(pizza);
        this.blat = Blat.SIMPLU;
    }

    @Override
    public double calcPret() {
        if(blat != Blat.SIMPLU){
            return pizza.calcPret() + 5;
        }
        return pizza.calcPret();
    }

    @Override
    public String descriere() {
        if (blat != Blat.SIMPLU) {
            if(blat == Blat.PUFOS){
                return pizza.descriere() + " cu blat pufos";
            }
            if(blat == Blat.INTEGRAL){
                return pizza.descriere() + " cu blat integral";
            }
        }
        return pizza.descriere() + " cu blat simplu";
    }
}
