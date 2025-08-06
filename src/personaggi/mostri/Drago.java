package personaggi.mostri;

import personaggi.eroi.Eroi;

public class Drago extends Mostri{
    public Drago(String classe, int vita, int attacco) {
        super(classe, vita, attacco);
    }

    public static Drago generateDragon(){
        Drago drago = new Drago(
                "Drago",
                250,
                40

        );
        return drago;
    }

}
