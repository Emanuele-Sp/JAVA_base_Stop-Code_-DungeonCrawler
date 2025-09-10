package PNG;

import dungeonCrawler.Logger;
import dungeonCrawler.Oggetti;
import personaggi.eroi.Elfo;
import personaggi.eroi.Eroi;
import personaggi.eroi.Guerriero;
import personaggi.eroi.Mago;

import java.util.Scanner;

public class Mercante extends PersonaggioNonGiocante{

    private String message;

    public Mercante(String classe, String message) {
        super(classe);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Mercante generateMerchant(){
        Mercante mercante = new Mercante(
                "PNG Mercante",
                "Cosa vuoi acquistare?"
        );
        return mercante;
    }



    public static Oggetti sendObject(Eroi eroe) {
        Scanner scanner = new Scanner(System.in);
        int input;
        Oggetti oggetto = null;

        while (true) {

            System.out.println("Scegli un oggetto:");
            System.out.println("1. POZIONE");
            System.out.println("2. BOMBA");

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    oggetto = Oggetti.POZIONE;
                    return oggetto;
                case 2:
                    oggetto = Oggetti.BOMBA;
                    return oggetto;
                default:
                    System.out.println("Inserisci un valore valido 1 o 2");
            }
        }
    }

    @Override
    public void azioneDelPng(Eroi eroe, PersonaggioNonGiocante png, int maxLife, Guerriero guerriero, Mago mago, Elfo elfo){
        if (eroe.getInventario().contains(Oggetti.MONETA)) {
            System.out.println(((Mercante)png).getMessage() + "\n");
            Oggetti oggetto = Mercante.sendObject(eroe);

            if (oggetto != null) {

                eroe.getInventario().add(oggetto);
                eroe.getInventario().remove(Oggetti.MONETA);

                Logger.getInstance().green("\n" + "Hai comprato una " + oggetto );
                if (oggetto == Oggetti.POZIONE)
                    Logger.getInstance().green("Permette di recuperare la vita di 25 HP");
                else if (oggetto == Oggetti.BOMBA)
                    Logger.getInstance().green("Infligge un danno di 35 HP al mostro");
                else
                    Logger.getInstance().green("Permette di acquistare oggetti dal mercante");

                Logger.getInstance().yellow("Questo è il tuo inventario: " + eroe.getInventario() + "\n");
            }
        } else {
            Logger.getInstance().yellow("Non hai monete, al momento non puoi acquistare! \n");
        }
    }

    @Override
    public String toString() {
        return "message: " + message + "\n"
                ;
    }
}
