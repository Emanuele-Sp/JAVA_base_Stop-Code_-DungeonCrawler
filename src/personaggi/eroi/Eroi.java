package personaggi.eroi;

import dungeonCrawler.Creature;
import dungeonCrawler.Logger;
import dungeonCrawler.Oggetti;
import personaggi.mostri.Mostri;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Eroi extends Creature {

    public abstract void attacco(Mostri mostro);
    public abstract void attaccoMagico(Mostri mostro);
    public abstract void calcMagickAttack(int initialMagicAttack, Eroi eroe );

    private String nome;
    private int livello;
    private ArrayList<Oggetti> inventario;
    private int vita;

    public Eroi(String classe, String nome, int livello, ArrayList<Oggetti> inventario, int vita) {
        super(classe);
        this.nome = nome;
        this.livello = livello;
        this.inventario = inventario;
        this.vita = vita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public ArrayList<Oggetti> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Oggetti> inventario) {
        this.inventario = inventario;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public static Mostri attack(Eroi eroe, Mostri mostro) {
       eroe.attacco(mostro);
        return mostro;
    }

    public static Mostri magicAttack(Eroi eroe, Mostri mostro) {
        eroe.attaccoMagico(mostro);
        return mostro;
    }

    public static void calcolaAttaccoMagico(int initialMagicAttack, Eroi eroe ){
        eroe.calcMagickAttack(initialMagicAttack, eroe);
    };


    public static String choiceAction(Eroi eroe) {
        String azione = "";
        if (eroe instanceof Guerriero) {
            String[] string = {"Attacca", "Difenditi", "Usa oggetto", "scappa"};
            for (int i = 0; i < string.length; i++) {
                azione += i + 1 + " - " + string[i] + "\n";
            }
        } else {
            String[] string = {"Attacca", "Difenditi", "Usa oggetto", "scappa", "Attacco Magico"};
            for (int i = 0; i < string.length; i++) {
                azione += i + 1 + " - " + string[i] + "\n";
            }
        }
        return azione;
    }

    public static Eroi heroEscape(Eroi eroe) {
        int nowLifeHero = eroe.getVita();
        eroe.setVita(nowLifeHero - 5);
        Logger.getInstance().yellow("Sei fuggito!");
        Logger.getInstance().magent("Hai subito un danno di 5");
        return eroe;
    }

    public static Oggetti findObject() {
        int random = (int) (Math.random() * 3);
        Oggetti treasure = null;
        switch (random) {
            case 0:
                treasure = Oggetti.POZIONE;

                break;
            case 1:
                treasure = Oggetti.BOMBA;

                break;
            case 2:
                treasure = Oggetti.MONETA;

                break;
        }
        return treasure;
    }

    public static String insertNameHero(Scanner scanner){
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {

            if (nome.matches("[a-zA-Z]+")) {
               nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
            } else {
                Logger.getInstance().yellow("Devi inserire solo lettere");
                nome = scanner.nextLine();
            }
        } else {
            Logger.getInstance().yellow("L'array non può essere vuoto");
            nome = scanner.nextLine();
        }
        return nome;
    }



    @Override
    public String toString() {
        return super.toString() +
                "Nome: " + nome + "\n" +
                "Livello: " + livello + "\n" +
                "Inventario: " + inventario + "\n" +
                "Vita: " + vita + "\n"
                ;
    }

}
