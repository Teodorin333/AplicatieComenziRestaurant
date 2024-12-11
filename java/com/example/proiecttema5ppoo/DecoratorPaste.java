package com.example.proiecttema5ppoo;

import java.util.List;

/**
 * Decorator folosit pentru adaugarea optiunilor extra la paste
 */
public class DecoratorPaste extends ADecoratorPizza{
    private List<TipExtraPaste> tipExtraPaste;

    public DecoratorPaste(IPizza paste,List<TipExtraPaste> tipExtraPaste) {
        super(paste);
        this.tipExtraPaste = tipExtraPaste;
    }
    @Override
    public double calcPret() {
        double pret_final = super.calcPret();
        if (tipExtraPaste != null && tipExtraPaste.size() > 0) {
            for (TipExtraPaste t : tipExtraPaste) {
                switch (t) {
                    case BRANZA -> pret_final += 2;
                    case BUSUIOC -> pret_final += 3;
                    default -> pret_final += 0;
                }
            }
        }
        return pret_final;
    }

    @Override
    public String descriere() {
        String desc_finala = super.descriere();
        if (tipExtraPaste != null && !tipExtraPaste.isEmpty()) {
            desc_finala += " cu extra: ";
            for (TipExtraPaste t : tipExtraPaste) {
                switch (t) {
                    case BRANZA -> desc_finala += "branza ";
                    case BUSUIOC -> desc_finala += "busuioc ";
                    default -> desc_finala += " ";
                }
                desc_finala += ", ";
            }
        }
        return desc_finala;
    }
}
