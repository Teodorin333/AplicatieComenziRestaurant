package com.example.proiecttema5ppoo;

/**
 * Zona de test...hello world?
 */
public class Main {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        IPizza pizza = null;
        IPizza pizza2 = null;
        Toppings[] toppings = new Toppings[] {Toppings.CEAPA, Toppings.EXTRA_MOZZARELLA};

        try {
            pizza = pizzaFactory.createPizza(TipPizza.DIAVOLA);
            //System.out.println(pizza.descriere());


            //pizza = new DecoratorTopping(pizza, toppings);
            //System.out.println(pizza.descriere());
            //System.out.println(pizza.calcPret());

            pizza2 = pizzaFactory.createPizza(TipPizza.CHEESY);
            toppings = new Toppings[]{Toppings.MASLINE, Toppings.PEPERONI, Toppings.SOS_DULCE};
            pizza2 = new DecoratorBlat(pizza2, Blat.INTEGRAL);
            //pizza2 = new DecoratorTopping(pizza2, toppings);
            //System.out.println(pizza2.descriere());
            //System.out.println(pizza2.calcPret());

            Bucatar buc1 = new Bucatar("Bontea");
            Bucatar buc2 = new Bucatar("Chicago");
            IComanda comanda1 = new Comanda(buc1, Produs.PASTE);
            IComanda comanda2 = new Comanda(buc2, Produs.PIZZA);

            Ospatar osp1 = new Ospatar("Ospatar");
            osp1.adaugaComanda(comanda1);
            osp1.adaugaComanda(comanda2);
            osp1.trimiteComanda();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
