package com.example.proiecttema5ppoo;

/**
 * Factory design pattern pentru crearea diferitelor obiecte de Paste (in ciuda numelui interfetei)
 */
public class PastaFactory {
    public IPizza createPasta(TipPaste tipPaste) throws Exception{
        switch (tipPaste) {
            case GNOCCHI:
                return new PasteGnocchi();
            case LINGUINI:
                return new PasteLinguini();
            case BOLOGNESE:
                return new PasteBolognese();
            case CARBONARA:
                return new PasteCarbonara();
            default:
                throw new Exception("Nu exista acest fel de pizza!");
        }
    }
}
