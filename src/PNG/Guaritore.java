package PNG;

import personaggi.eroi.Eroi;

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
    public String toString() {
        return message + '\'';
    }
}
