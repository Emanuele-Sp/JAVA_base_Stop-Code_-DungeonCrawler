package personaggi.eroi;

import dungeonCrawler.Logger;
import dungeonCrawler.Oggetti;
import personaggi.mostri.Mostri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Guerriero extends Eroi {
    private int attacco;



    public Guerriero(String classe, String nome, int livello, ArrayList<Oggetti> inventario, int vita, int attacco) {
        super(classe, nome, livello, inventario, vita);
        this.attacco = attacco;
    }

    @Override
    public void attacco(Mostri mostro) {
        int newLifeMonster = mostro.getVita() - this.getAttacco();
        mostro.setVita(newLifeMonster);
        if (newLifeMonster > 0)
            Logger.getInstance().yellow(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        else
            Logger.getInstance().red(mostro.getClasse() + " è stato sconfitto");
    }

    @Override
    public void attaccoMagico(Mostri mostro) {
        System.out.print("Il guerriero non ha un attacco magico");
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public static Guerriero choiceWarrior(Scanner scanner) {

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
    public void calcMagickAttack(int initialMagicAttack, Eroi eroe ){

    }


    @Override
    public String toString() {
        return super.toString() +
                "attacco: " + attacco + "\n"
                ;
    }
}
