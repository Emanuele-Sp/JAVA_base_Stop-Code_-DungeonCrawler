package PNG;

import dungeonCrawler.Logger;
import dungeonCrawler.Oggetti;
import personaggi.eroi.Elfo;
import personaggi.eroi.Eroi;
import personaggi.eroi.Guerriero;
import personaggi.eroi.Mago;
import personaggi.mostri.Mostri;

public abstract class PersonaggioNonGiocante {
    private String classe;

    public PersonaggioNonGiocante(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    // INSERIMENTO CASUALE DEL PNG
    public static PersonaggioNonGiocante insertPng() {
        int random = (int) (Math.random() * 3);

        switch (random) {
            case 0:
                Logger.getInstance().backGreen("\u001B[30m" + "Esce il Guaritore" + "\u001B[0m");
                return Guaritore.generateHealer();

            case 1:
                Logger.getInstance().backCyan("\u001B[30m" + "Esce il Fabbro" + "\u001B[0m");
                return Fabbro.generateLocksmith();

            case 2:
                Logger.getInstance().backMagent("\u001B[30m" + "Esce il Mercante" + "\u001B[0m");
                return Mercante.generateMerchant();

            default:
                return null; // teoricamente mai raggiunto
        }
    }

    public static Eroi actionPNG(Eroi eroe, PersonaggioNonGiocante png, int maxLife, Guerriero guerriero, Mago mago, Elfo elfo) {

        png.azioneDelPng(eroe, png, maxLife, guerriero, mago, elfo);
        return eroe;
    }

    public abstract void azioneDelPng(Eroi eroe, PersonaggioNonGiocante png, int maxLife, Guerriero guerriero, Mago mago, Elfo elfo);

    @Override
    public String toString() {
        return "PersonaggioNonGiocante" +
                "classe: " + classe + "\n";
    }
}
