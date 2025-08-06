package personaggi.eroi;

import dungeonCrawler.Oggetti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Guerriero extends Eroi {
    private int attacco;

    public Guerriero(String classe, String nome, int livello, ArrayList<Oggetti> inventario, int vita, int attacco) {
        super(classe, nome, livello, inventario, vita);
        this.attacco = attacco;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public static Guerriero choiceWarrior() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome del tuo Guerriero:");
        String nome = Eroi.insertNameHero(scanner);

        ArrayList<Oggetti> inv = new ArrayList<>(Arrays.asList(Oggetti.MONETA));
        Guerriero guerriero = new Guerriero(
                "Guerriero",
                nome,
                1,
                inv,
                160,
                25
        );
        return guerriero;
    }

    @Override
    public String toString() {
        return super.toString() +
                "attacco: " + attacco + "\n"
                ;
    }
}
