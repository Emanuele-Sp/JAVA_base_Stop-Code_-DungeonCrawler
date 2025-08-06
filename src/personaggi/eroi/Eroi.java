package personaggi.eroi;

import dungeonCrawler.Creature;
import dungeonCrawler.Oggetti;
import personaggi.mostri.Mostri;

import java.util.ArrayList;
import java.util.Scanner;

public class Eroi extends Creature {
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
        if (eroe instanceof Guerriero) {
            Guerriero guerriero = (Guerriero) eroe; // Cast sicuro
            int nowLifeMonster = mostro.getVita();
            int newLifeMonster = nowLifeMonster - guerriero.getAttacco();
            mostro.setVita(newLifeMonster); // Se vuoi aggiornare la vita
            System.out.println(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        } else if (eroe instanceof Mago) {
            Mago mago = (Mago) eroe; // Cast sicuro
            int nowLifeMonster = mostro.getVita();
            int newLifeMonster = nowLifeMonster - mago.getAttacco();
            mostro.setVita(newLifeMonster); // Se vuoi aggiornare la vita
            System.out.println(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        } else if (eroe instanceof Elfo) {
            Elfo elfo = (Elfo) eroe; // Cast sicuro
            int nowLifeMonster = mostro.getVita();
            int newLifeMonster = nowLifeMonster - elfo.getAttacco();
            mostro.setVita(newLifeMonster);
            System.out.println(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        }
        return mostro;
    }

    public static Mostri magicAttack(Eroi eroe, Mostri mostro) {
        if (eroe instanceof Mago) {
            Mago mago = (Mago) eroe; // Cast sicuro
            int nowLifeMonster = mostro.getVita();
            int newLifeMonster = nowLifeMonster - mago.getAttaccoMagico();
            mostro.setVita(newLifeMonster); // Se vuoi aggiornare la vita
            System.out.println(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        } else if (eroe instanceof Elfo) {
            Elfo elfo = (Elfo) eroe; // Cast sicuro
            int nowLifeMonster = mostro.getVita();
            int newLifeMonster = nowLifeMonster - elfo.getAttaccoMagico();
            mostro.setVita(newLifeMonster);
            System.out.println(mostro.getClasse() + " ha ora " + newLifeMonster + " punti vita.");
        }
        return mostro;
    }

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
                System.out.println("Devi inserire solo lettere");
                nome = scanner.nextLine();
            }
        } else {
            System.out.println("L'array non può essere vuoto");
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
