package personaggi.eroi;

import dungeonCrawler.Logger;
import dungeonCrawler.Oggetti;
import personaggi.mostri.Mostri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mago extends Eroi{
    private int attacco;
    private int attaccoMagico;

    public Mago(String classe, String nome, int livello, ArrayList<Oggetti> inventario, int vita, int attacco,
                int attaccoMagico) {
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

    public static Mago choiceWizard(Scanner scanner) {

        System.out.println("Inserisci il nome del tuo Mago:");
        String nome = Eroi.insertNameHero(scanner);
        ArrayList<Oggetti> inv = new ArrayList<>(Arrays.asList(Oggetti.MONETA));
        Mago mago = new Mago(
                "Mago",
                nome,
                1,
                inv,
                110,
                10,  
                7  
        );
        return mago;
    };

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
        int newLifeMonster = mostro.getVita() - this.getAttaccoMagico();
        mostro.setVita(newLifeMonster);
        if (newLifeMonster > 0)
            Logger.getInstance().yellow(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        else
            Logger.getInstance().red(mostro.getClasse() + " è stato sconfitto");
    }

    @Override
    public void calcMagickAttack(int initialMagicAttack, Eroi eroe ){
        this.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
    }

    @Override
    public String toString(){
        return  super.toString() +
                "Attacco: " + attacco + "\n" +
                "Attacco Magico: " + attaccoMagico + "\n"
                ;
    }
}
