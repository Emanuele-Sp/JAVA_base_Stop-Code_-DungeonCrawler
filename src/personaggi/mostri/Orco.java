package personaggi.mostri;

import personaggi.eroi.Eroi;

public class Orco extends Mostri{
    public Orco(String classe, int vita, int attacco) {
        super(classe, vita, attacco);
    }

    public static Orco generateOrc(){
        Orco orco = new Orco(
                "Orco",
                70,
                25

        );
        return orco;
    }
}
