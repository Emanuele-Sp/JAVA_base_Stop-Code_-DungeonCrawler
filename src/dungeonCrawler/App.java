package dungeonCrawler;

import PNG.Fabbro;
import PNG.Guaritore;
import PNG.Mercante;
import PNG.PersonaggioNonGiocante;
import personaggi.eroi.Elfo;

import personaggi.eroi.Eroi;
import personaggi.eroi.Guerriero;
import personaggi.eroi.Mago;
import personaggi.mostri.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Goblin goblin = Goblin.generateGoblin();
        Scheletro scheletro = Scheletro.generateSkeleton();
        Orco orco = Orco.generateOrc();
        Drago drago = Drago.generateDragon();


        PersonaggioNonGiocante png = null;

        Mostri mostro = null;
        Eroi eroe = null;
        Guerriero guerriero = null;
        Mago mago = null;
        Elfo elfo = null;


        int maxLife;
        int initialMagicAttack = 0;

        String[] heroes = {"Guerriero", "Mago", "Elfo"};
        System.out.println("Scegli un personaggio: ");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i + 1) + " - " + heroes[i]);
        }


        // SCELTA DELL'EROE
        System.out.println("fai la tua scelta: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    guerriero = Guerriero.choiceWarrior();
                    System.out.println("");
                    System.out.println(guerriero);
                    eroe = guerriero;
                    maxLife = eroe.getVita();
                    break;

                case 2:
                    mago = Mago.choiceWizard();
                    System.out.println("");
                    System.out.println(mago);
                    eroe = mago;
                    initialMagicAttack = mago.getAttaccoMagico();
                    maxLife = eroe.getVita();
                    break;

                case 3:
                    elfo = Elfo.choiceElf();
                    System.out.println("");
                    System.out.println(elfo);
                    eroe = elfo;
                    initialMagicAttack = elfo.getAttaccoMagico();
                    maxLife = eroe.getVita();

                    break;
                default:
                    System.out.println("Scelta non valida. Inserisci un altro valore: ");
                    continue;
            }
            break;
        }

        // SCELTA DELLE PORTE
        do {
            System.out.println("Scegli una porta: \n" + choiceDoor());
            Scanner scanner2 = new Scanner(System.in);
            int input = scanner2.nextInt();
            boolean isEscaped = false;

            switch (input) {
                // PORTA DI SINISTRA ************************
                case 1:
                    System.out.println("Hai scelto la porta di sinistra");
                    int scelta = (int) (Math.random() * 19) + 1;

                    if (scelta > 0 && scelta <= 5) {
                        mostro = Mostri.insertMonster(goblin, scheletro, orco, drago);
                        int difesa = 1; // Necessario per modificare l'attacco del mostro
                        System.out.println("E' uscito un " + mostro.getClass().getSimpleName() + "\n");
                        isEscaped = battle(scanner, eroe, mostro, difesa, maxLife);
                        System.out.println("\n");
                        if (eroe.getVita() <= 0) {
                            System.out.println("Sei stato sconfitto");
                            return;
                        } else {
                            if (!isEscaped) {
                                eroe.setLivello(eroe.getLivello() + 1);
                                if (eroe instanceof Mago) {
                                    mago.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
                                } else if (eroe instanceof Elfo) {
                                    elfo.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
                                }
                                System.out.println("Il tuo livello è salito a: " + eroe.getLivello());
                                dropObject(eroe);
                            } else {
                                System.out.println("Sei fuggito! \n");
                            }
                        }

                    } else if (scelta > 5 && scelta <= 9) {
                        System.out.println("L'eroe subisce un danno di 1");
                        eroe.setVita(eroe.getVita() - 1);
                        System.out.println(eroe.getVita());

                    } else if (scelta > 9 && scelta <= 12) {
                        System.out.println("Incontro con un PNG");
                        png = PersonaggioNonGiocante.insertPng();
                        actionPNG(eroe, png, maxLife, guerriero, mago, elfo);

                    } else if (scelta > 12 && scelta <= 17) {
                        System.out.println("Stanza vuota");

                    } else {
                        Oggetti drop = dropObject(eroe);
                        System.out.println("Hai ricevuto: " + drop);
                    }

                    if (!isEscaped && mostro == drago) {
                        break; // Uscita dal ciclo se era un drago e non è scappato
                    }
                    continue;

                    //PORTA CENTRALE************************
                case 2:
                    System.out.println("Hai scelto la porta centrale");
                    scelta = (int) (Math.random() * 19) + 1;

                    if (scelta > 0 && scelta <= 5) {
                        mostro = Mostri.insertMonster(goblin, scheletro, orco, drago);
                        int difesa = 1; // Necessario per modificare l'attacco del mostro
                        System.out.println("E' uscito un " + mostro.getClass().getSimpleName() + "\n");
                        isEscaped = battle(scanner, eroe, mostro, difesa, maxLife);
                        if (eroe.getVita() <= 0) {
                            System.out.println("Sei stato sconfitto");
                            return;
                        } else {
                            if (!isEscaped) {
                                eroe.setLivello(eroe.getLivello() + 1);
                                if (eroe instanceof Mago) {
                                    mago.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
                                } else if (eroe instanceof Elfo) {
                                    elfo.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
                                }
                                System.out.println("Il tuo livello è salito a: " + eroe.getLivello());
                                dropObject(eroe);
                            } else {
                                System.out.println("Sei fuggito! \n");
                            }
                        }

                    } else if (scelta > 5 && scelta <= 9) {
                        System.out.println("L'eroe subisce un danno di 1");
                        eroe.setVita(eroe.getVita() - 1);
                        System.out.println(eroe.getVita());

                    } else if (scelta > 9 && scelta <= 12) {
                        System.out.println("Incontro con un PNG");
                        png = PersonaggioNonGiocante.insertPng();
                        actionPNG(eroe, png, maxLife, guerriero, mago, elfo);

                        System.out.println(eroe.getInventario());

                    } else if (scelta > 12 && scelta <= 17) {
                        System.out.println("Stanza vuota");

                    } else {
                        Oggetti drop = dropObject(eroe);
                        System.out.println("Hai ricevuto: " + drop);
                    }

                    if (!isEscaped && mostro == drago) {
                        break; // Uscita dal ciclo se era un drago e non è scappato
                    }
                    continue;

                    //PORTA DI DESTRA **************************
                case 3:
                    System.out.println("Hai scelto la porta di destra");
                    scelta = (int) (Math.random() * 19) + 1;

                    if (scelta > 0 && scelta <= 5) {
                        mostro = Mostri.insertMonster(goblin, scheletro, orco, drago);
                        int difesa = 1; // Necessario per modificare l'attacco del mostro
                        System.out.println("E' uscito un " + mostro.getClass().getSimpleName() + "\n");
                        isEscaped = battle(scanner, eroe, mostro, difesa, maxLife);
                        if (eroe.getVita() <= 0) {
                            System.out.println("Sei stato sconfitto");
                            return;
                        } else {
                            if (!isEscaped) {
                                eroe.setLivello(eroe.getLivello() + 1);
                                if (eroe instanceof Mago) {
                                    mago.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
                                } else if (eroe instanceof Elfo) {
                                    elfo.setAttaccoMagico(initialMagicAttack * eroe.getLivello());
                                }
                                System.out.println("Il tuo livello è salito a: " + eroe.getLivello());
                                dropObject(eroe);
                            } else {
                                System.out.println("Sei fuggito! \n");
                            }
                        }

                    } else if (scelta > 5 && scelta <= 9) {
                        System.out.println("L'eroe subisce un danno di 1");
                        eroe.setVita(eroe.getVita() - 1);
                        System.out.println(eroe.getVita());

                    } else if (scelta > 9 && scelta <= 12) {
                        System.out.println("Incontro con un PNG");
                        png = PersonaggioNonGiocante.insertPng();
                        actionPNG(eroe, png, maxLife, guerriero, mago, elfo);

                    } else if (scelta > 12 && scelta <= 17) {
                        System.out.println("Stanza vuota");

                    } else {
                        Oggetti drop = dropObject(eroe);
                        System.out.println("Hai ricevuto: " + drop);
                    }

                    if (!isEscaped && mostro == drago) {
                        break; // Uscita dal ciclo se era un drago e non è scappato
                    }
                    continue;

                default:
                    System.out.println("Inserisci un valore da 1 a 3:");
            }

        } while ((!(mostro instanceof Drago) || mostro.getVita() > 0) && eroe.getLivello() < 10);

        System.out.println("CONGRATULAZIONI HAI COMPLETATO IL GIOCO!!!");
    }


    // METODO DELLA BATTAGLIA CON UN MOSTRO
    static boolean battle(Scanner scanner, Eroi eroe, Mostri mostro, int difesa, int maxLife) {
        do {
            System.out.println("HP " + eroe.getClasse() + ": " + eroe.getVita() + " - " +
                    "HP " + mostro.getClasse() + ": " + mostro.getVita());
            System.out.println(Eroi.choiceAction(eroe));
            int inputAction = scanner.nextInt();
            switch (inputAction) {
                case 1:
                    Eroi.attack(eroe, mostro);
                    if (mostro.getVita() > 0) {
                        Mostri.monsterAttack(eroe, mostro, difesa);
                    }
                    break;

                case 2:
                    if (difesa == 1) {
                        difesa++;
                        Mostri.monsterAttack(eroe, mostro, difesa);
                    } else {
                        System.out.println("Puoi aumentare la tua difesa una volta per avversario \n");
                    }
                    break;
                case 3:
                    ArrayList<Oggetti> newInventario = new ArrayList<>();
                    for (int i = 0; i < eroe.getInventario().size(); i++) {
                        if (eroe.getInventario().get(i) != Oggetti.MONETA) {
                            newInventario.add(eroe.getInventario().get(i));
                        }
                    }
                    if (!newInventario.isEmpty()) {
                        System.out.println("Scegli un oggetto: ");

                        int inp;
                        int numero = 1;
                        System.out.println(0 + " - Torna indietro");
                        for (Oggetti ogg : newInventario) {
                            System.out.println(numero++ + " - " + ogg);
                        }
                        do {
                            try {
                                inp = scanner.nextInt();
                                if (inp == 0){
                                    break;
                                }
                                if ((newInventario.get(inp - 1)).equals(Oggetti.POZIONE)) {
                                    if (eroe.getVita() == maxLife) {
                                        System.out.println("Hai gia gli HP massimi");
                                        break;

                                    } else if (eroe.getVita() + 25 >= maxLife) {
                                        System.out.println("Hai ricaricato gli HP fino al tuo attuale massimo");
                                        eroe.setVita(maxLife);
                                        newInventario.remove(newInventario.get(inp - 1));
                                        Mostri.monsterAttack(eroe, mostro, difesa);
                                        eroe.getInventario().remove(Oggetti.POZIONE);
                                    } else {
                                        eroe.setVita(eroe.getVita() + 25);
                                        newInventario.remove(newInventario.get(inp - 1));
                                        Mostri.monsterAttack(eroe, mostro, difesa);
                                        eroe.getInventario().remove(Oggetti.POZIONE);
                                    }
                                    break;
                                } else {
                                    mostro.setVita(mostro.getVita() - 35);
                                    System.out.println("Hai usato una Bomba gli HP del mostro sono scesi di 35 \n");
                                    Mostri.monsterAttack(eroe, mostro, difesa);
                                    newInventario.remove(newInventario.get(inp - 1));
                                    eroe.getInventario().remove(Oggetti.BOMBA);
                                    break;
                                }
                            } catch (IndexOutOfBoundsException iobEx) {
                                System.out.println("Inserisci un valore corretto");
                                scanner.nextLine(); // questo pulisce
                            }

                        } while (true);


                    } else {
                        System.out.println("Il tuo inventario è vuoto, inserisci un altra azione \n");
                        break;
                    }
                    break;

                case 4:
                    Eroi.heroEscape(eroe);
                    return true;  // Segnala che è scappato
                case 5:
                    if (eroe instanceof Mago || eroe instanceof Elfo) {
                        Eroi.magicAttack(eroe, mostro);
                        Mostri.monsterAttack(eroe, mostro, difesa);
                    }
                default:
                    if (eroe instanceof Guerriero) {
                        System.out.println("Scegli un valore da 1 a 4");
                    } else {
                        System.out.println("Scegli un valore da 1 a 5");
                    }

            }
        } while (mostro.getVita() > 0 && eroe.getVita() > 0);

        return false;  // Non è scappato
    }


    // SCELTA DELLA PORTA
    public static String choiceDoor() {
        String[] string = {"Porta di sinistra", "Porta centrale", "Porta di destra"};
        String porta = "";
        for (int i = 0; i < string.length; i++) {
            porta += i + 1 + " - " + string[i] + "\n";
        }
        return porta;
    }


    public static Eroi actionPNG(Eroi eroe, PersonaggioNonGiocante png, int maxLife, Guerriero guerriero, Mago mago, Elfo elfo) {
        if (png instanceof Guaritore) {
            System.out.println(((Guaritore) png).getMessage());
            Guaritore.cureHealer(eroe, maxLife);
            return eroe;
        } else if (png instanceof Fabbro) {
            System.out.println(((Fabbro) png).getMessage());
            Fabbro.increaseAttack(eroe, guerriero, mago, elfo);

            return eroe;
        } else {
            if (eroe.getInventario().contains(Oggetti.MONETA)) {
                System.out.println(((Mercante)png).getMessage() + "\n");
                Oggetti oggetto = Mercante.sendObject(eroe);

                if (oggetto != null) {

                    eroe.getInventario().add(oggetto);
                    eroe.getInventario().remove(Oggetti.MONETA);
                    System.out.println(eroe.getInventario());
                }
            } else {
                System.out.println("Non hai monete, al momento non puoi acquistare! \n");
            }

            return eroe;
        }
    }

    public static Oggetti dropObject(Eroi eroe) {
        Oggetti oggetto = Eroi.findObject();
        eroe.getInventario().add(oggetto);
        System.out.println(eroe.getInventario());
        return oggetto;
    }

    public static void stampObject() {
        int i = 1;
        for (Oggetti ogg : Oggetti.values()) {
            if (ogg != Oggetti.MONETA)
                System.out.println(i++ + " - " + ogg);
        }
    }


}
