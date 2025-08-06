package personaggi.mostri;

import personaggi.eroi.Eroi;

public class Scheletro extends Mostri{
    public Scheletro(String classe, int vita, int attacco) {
        super(classe,  vita, attacco);
    }

    public static Scheletro generateSkeleton(){
        Scheletro scheletro = new Scheletro(
                "Scheletro",
                60,
                20
        );
        return scheletro;
    }

}
