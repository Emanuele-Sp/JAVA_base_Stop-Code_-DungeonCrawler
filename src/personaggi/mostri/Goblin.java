package personaggi.mostri;

public class Goblin extends Mostri {
    public Goblin(String classe, int vita, int attacco) {
        super(classe, vita, attacco);
    }

    public static Goblin generateGoblin() {
        Goblin goblin = new Goblin(
                "Goblin",
                50,
                15
        );
        return goblin;
    }
}
