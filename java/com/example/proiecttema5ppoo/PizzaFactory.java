package com.example.proiecttema5ppoo;

/**
 * Factory design pattern pentru crearea diferitelor tipuri de obiecte de Pizza
 */
public class PizzaFactory {
    public IPizza createPizza(TipPizza tipPizza) throws Exception{
        switch (tipPizza) {
            case CARNIVORA:
                return new PizzaCarnivora();
            case CHEESY:
                return new PizzaCheesy();
            case VEGANA:
                return new PizzaVegana();
            case DIAVOLA:
                return new PizzaDiavola();
            case MARGHERITA:
                return new PizzaMargherita();
            default:
                throw new Exception("Nu exista acest fel de pizza!");
        }
    }
}
