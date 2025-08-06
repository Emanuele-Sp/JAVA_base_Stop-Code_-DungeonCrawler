package PNG;

public class PersonaggioNonGiocante {
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
                System.out.println("Esce il Guaritore");
                return Guaritore.generateHealer();

            case 1:
                System.out.println("Esce il Fabbro");
                return Fabbro.generateLocksmith();

            case 2:
                System.out.println("Esce il Mercante");
                return Mercante.generateMerchant();

            default:
                return null; // teoricamente mai raggiunto
        }
    }

    @Override
    public String toString() {
        return "PersonaggioNonGiocante" +
                "classe: " + classe + "\n";
    }
}
