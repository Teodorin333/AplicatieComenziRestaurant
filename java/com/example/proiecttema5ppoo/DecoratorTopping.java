package com.example.proiecttema5ppoo;

import java.util.List;

/**
 * Decorator folosit pentru adaugarea de topping-uri la pizza
 */
public class DecoratorTopping extends ADecoratorPizza{
    private List<Toppings> toppings;

    public DecoratorTopping(IPizza pizza,List<Toppings> toppings) {
        super(pizza);
        this.toppings = toppings;
    }
    //de verificat daca sunt bagate toppinguri aiurea
    @Override
    public double calcPret() {
        double pret_final = super.calcPret();
        if (toppings != null && toppings.size() > 0) {
            for (Toppings t : toppings) {
                switch (t) {
                    case CEAPA -> pret_final += 2;
                    case EXTRA_MOZZARELLA -> pret_final += 3;
                    case PEPERONI -> pret_final += 2.5;
                    case MASLINE -> pret_final += 1.5;
                    case SOS_PICANT -> pret_final += 2;
                    case SOS_DULCE -> pret_final += 2;
                    default -> pret_final += 0;
                }
            }
        }
            return pret_final;
        }

    @Override
    public String descriere() {
        String desc_finala = super.descriere();
        if (toppings != null && !toppings.isEmpty()) {
            desc_finala += " si cu extra: ";
            for (Toppings t : toppings) {
                switch (t) {
                    case CEAPA -> desc_finala += "ceapa ";
                    case EXTRA_MOZZARELLA -> desc_finala += "mozzarella ";
                    case PEPERONI -> desc_finala += "peperoni ";
                    case MASLINE -> desc_finala += "masline ";
                    case SOS_PICANT -> desc_finala += "sos_picant ";
                    case SOS_DULCE -> desc_finala += "sos_dulce ";
                    default -> desc_finala += " ";
                }
                desc_finala += ", ";
            }
        }
        return desc_finala;
    }
}

