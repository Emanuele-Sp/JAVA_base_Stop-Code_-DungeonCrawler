package PNG;

import dungeonCrawler.Oggetti;
import personaggi.eroi.Eroi;

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
    public String toString() {
        return "message: " + message + "\n"
                ;
    }
}
