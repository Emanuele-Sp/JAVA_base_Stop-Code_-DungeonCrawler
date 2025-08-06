package dungeonCrawler;

public abstract class Creature {
    private String classe;

    public Creature(String classe) {
        this.classe = classe;

    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

@Override
    public String toString(){
        return classe + "\n"
                ;
}
}
