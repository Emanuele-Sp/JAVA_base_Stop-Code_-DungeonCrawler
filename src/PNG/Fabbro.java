package PNG;

import personaggi.eroi.Elfo;
import personaggi.eroi.Eroi;
import personaggi.eroi.Guerriero;
import personaggi.eroi.Mago;

public class Fabbro extends PersonaggioNonGiocante{
    private String message;
    public Fabbro(String classe, String message) {
        super(classe);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int increaseLife(Eroi eroi){

        int nowLife = eroi.getVita();
        int newLife = nowLife + 1;
        eroi.setVita(newLife);
        return newLife;
    }

    public static Fabbro generateLocksmith(){
        Fabbro fabbro = new Fabbro(
                "PNG Fabbro",
                "Ho affilata la tua arma, il tuo attacco è aumentato permanentemente di 5 \n"
        );
        return fabbro;
    }

    public static Eroi increaseAttack(Eroi eroe, Guerriero guerriero, Mago mago, Elfo elfo){
        if (eroe instanceof Guerriero) {
            guerriero.setAttacco(guerriero.getAttacco() + 5);
            return eroe;
        } else if(eroe instanceof Mago){
            mago.setAttacco(mago.getAttacco() + 5);
            return eroe;
        } else if(eroe instanceof Elfo){
            elfo.setAttacco(elfo.getAttacco() + 5);
            return eroe;
        }
        return eroe;
    }

    @Override
    public String toString() {
        return message + '\''
                ;
    }
}
