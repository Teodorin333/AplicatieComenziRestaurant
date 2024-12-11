package com.example.proiecttema5ppoo;

/**
 * Clasa abstracta pentru decoratori
 */
public abstract class ADecoratorPizza implements IPizza{
    protected IPizza pizza;

    /**
     * Constructorul decoratorului
     * @param pizza Orice produs ce implementeaza interfata IPizza
     */
    public ADecoratorPizza(IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double calcPret() {
        return pizza.calcPret();
    }

    @Override
    public String descriere() {
        return pizza.descriere();
    }
}
