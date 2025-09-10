package PNG;

import dungeonCrawler.Logger;
import personaggi.eroi.Elfo;
import personaggi.eroi.Eroi;
import personaggi.eroi.Guerriero;
import personaggi.eroi.Mago;

public class Guaritore extends PersonaggioNonGiocante{
    private String message;

    public Guaritore(String classe, String message) {
        super(classe);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Guaritore generateHealer(){
        Guaritore guaritore = new Guaritore(
                "PNG Guaritore",
                "Ho curato tutte le tue ferite e aumentato la vita massima di 1"
        );
        return guaritore;
    }

    public static Eroi cureHealer(Eroi eroe, int maxLife){
        eroe.setVita(maxLife + 1);
        maxLife++;
        return eroe;
    }

    @Override
    public void azioneDelPng(Eroi eroe, PersonaggioNonGiocante png, int maxLife, Guerriero guerriero, Mago mago, Elfo elfo){
        Logger.getInstance().yellow(((Guaritore) png).getMessage());
        Guaritore.cureHealer(eroe, maxLife);
    }

    @Override
    public String toString() {
        return message + '\n';
    }
}
