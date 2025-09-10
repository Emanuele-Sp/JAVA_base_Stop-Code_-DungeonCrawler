package personaggi.mostri;

import dungeonCrawler.Creature;
import personaggi.eroi.Eroi;

public class Mostri extends Creature {
    private int vita;
    private int attacco;

    public Mostri(String classe, int vita, int attacco) {
        super(classe);
        this.vita = vita;
        this.attacco = attacco;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public static Mostri insertMonster(Goblin goblin, Scheletro scheletro, Orco orco, Drago drago) {
//          int random = (int) (Math.random() * 4);
        int random = 2;

        switch (random) {
            case 0:
                goblin = Goblin.generateGoblin();
                return goblin;
            case 1:
                scheletro = Scheletro.generateSkeleton();
                return scheletro;
            case 2:
                orco = Orco.generateOrc();
                return orco;
            case 3:
                drago = Drago.generateDragon();
                return drago;
            default:
                return goblin;
        }
    }

    public static Eroi monsterAttack(Eroi eroe, Mostri mostro, int difesa) {
        int nowLifeHero = eroe.getVita();
        eroe.setVita(nowLifeHero - mostro.getAttacco() / difesa);
        return eroe;
    }

    @Override
    public String toString() {
        return "Classe: " + getClasse() + "\n" +
                "Vita: " + vita + "\n" +
                "Attacco: " + attacco + "\n"
                ;
    }
}
