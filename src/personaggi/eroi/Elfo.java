package personaggi.eroi;

import dungeonCrawler.Oggetti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Elfo extends Eroi{
    private int attacco;
    private int attaccoMagico;

    public Elfo(String classe, String nome, int livello, ArrayList<Oggetti> inventario, int vita,
                int attacco,int attaccoMagico) {
        super(classe, nome, livello, inventario, vita);
        this.attacco = attacco;
        this.attaccoMagico = attaccoMagico;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getAttaccoMagico() {
        return attaccoMagico;
    }

    public void setAttaccoMagico(int attaccoMagico) {
        this.attaccoMagico = attaccoMagico;
    }

    public static Elfo choiceElf() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome del tuo Elfo:");
        String nome = Eroi.insertNameHero(scanner);
        ArrayList<Oggetti> inv = new ArrayList<>(Arrays.asList(Oggetti.MONETA));
        Elfo elfo = new Elfo(
                "Elfo",
                nome,
                1,
                inv,
                130,
                15,
                5
        );
        return elfo;
    };

    @Override
    public String toString(){
        return  super.toString() +
                "Attacco: " + attacco + "\n" +
                "Attacco Magico: " + attaccoMagico + "\n"
                ;
    }
}
