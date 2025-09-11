package dungeonCrawler;

import PNG.PersonaggioNonGiocante;
import personaggi.eroi.Elfo;

import personaggi.eroi.Eroi;
import personaggi.eroi.Guerriero;
import personaggi.eroi.Mago;
import personaggi.mostri.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.logging.Logger;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Logger log = Logger.getInstance();

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
        int difesa = 1;

        String[] heroes = {"Guerriero", "Mago", "Elfo"};
        log.grey("Scegli un personaggio: ");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println((i + 1) + " - " + heroes[i]);
        }

        // SCELTA DELL'EROE
        log.grey("fai la tua scelta: ");

        while (true) {
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        scanner.nextLine();
                        guerriero = Guerriero.choiceWarrior(scanner);
                        System.out.println();
                        System.out.println(guerriero);
                        eroe = guerriero;
                        maxLife = eroe.getVita();
                        break;

                    case 2:
                        scanner.nextLine();
                        mago = Mago.choiceWizard(scanner);
                        System.out.println();
                        System.out.println(mago);
                        eroe = mago;
                        initialMagicAttack = mago.getAttaccoMagico();
                        System.out.println(initialMagicAttack);
                        maxLife = eroe.getVita();
                        break;

                    case 3:
                        scanner.nextLine();
                        elfo = Elfo.choiceElf(scanner);
                        System.out.println();
                        System.out.println(elfo);
                        eroe = elfo;
                        initialMagicAttack = elfo.getAttaccoMagico();
                        maxLife = eroe.getVita();
                        break;

                    default:
                        log.yellow("Scelta non valida. Inserisci un altro valore da 1 a 3: ");
                        continue;
                }
                break; // esce solo se la scelta è valida
            } catch (InputMismatchException e) {
                log.yellow("Devi inserire un numero!");
                scanner.nextLine(); // pulisce il buffer
            }
        }

        // SCELTA DELLE PORTE
        do {
            log.grey("Scegli una porta:");
            System.out.println(choiceDoor());
            int input = scanner.nextInt();
            boolean isEscaped = false;
            String sconfitta = "Sei stato sconfitto!";

            switch (input) {
                // PORTA DI SINISTRA ************************
                case 1:
                    String stringDoor = "Hai scelto la porta di sinistra";
                    log.blue(stringDoor);

                    int scelta = (int) (Math.random() * 19) + 1;

                    if (scelta > 0 && scelta <= 5) {
                        if (eroe.getLivello() <= 9) {
                            mostro = Mostri.insertMonster(goblin, scheletro, orco, drago);
                        } else {
                            mostro = Drago.generateDragon();
                        }
                        difesa = 1; // Necessario per modificare l'attacco del mostro
                        log.red("E' uscito un " + mostro.getClass().getSimpleName());
                        isEscaped = battle(scanner, eroe, mostro, difesa, maxLife);
                        System.out.print("\n");
                        if (eroe.getVita() <= 0) {
                            log.red(sconfitta);
                            return;
                        } else {
                            if (!isEscaped) {
                                if (mostro instanceof Drago) {
                                    System.out.println("CONGRATULAZIONI HAI COMPLETATO IL GIOCO!!!");
                                    return;
                                }
                                eroe.setLivello(eroe.getLivello() + 1);
                                eroe.calcolaAttaccoMagico(initialMagicAttack, eroe);
                                log.green("Il tuo livello è salito a: " + eroe.getLivello());
                                dropObject(eroe);
                            } else
                                System.out.print("");
                        }

                    } else if (scelta > 5 && scelta <= 9) {
                        damage(eroe);

                    } else if (scelta > 9 && scelta <= 12) {
                        log.cyan("\nIncontro con un PNG");
                        png = PersonaggioNonGiocante.insertPng();
                        png.actionPNG(eroe, png, maxLife, guerriero, mago, elfo);

                    } else if (scelta > 12 && scelta <= 17) {
                        System.out.println("Stanza vuota \n");

                    } else {
                        Oggetti drop = dropObject(eroe);
                    }

                    if (!isEscaped && mostro == drago) {
                        break; // Uscita dal ciclo se era un drago e non è scappato
                    }
                    continue;

                    //PORTA CENTRALE************************
                case 2:
                    stringDoor = "Hai scelto la porta centrale";
                    log.blue(stringDoor);

                    scelta = (int) (Math.random() * 19) + 1;

                    if (scelta > 0 && scelta <= 5) {
                        if (eroe.getLivello() <= 9) {
                            mostro = Mostri.insertMonster(goblin, scheletro, orco, drago);
                        } else {
                            mostro = Drago.generateDragon();
                        }
                        difesa = 1; // Necessario per modificare l'attacco del mostro
                        log.red("E' uscito un " + mostro.getClass().getSimpleName());
                        isEscaped = battle(scanner, eroe, mostro, difesa, maxLife);
                        System.out.print("\n");
                        if (eroe.getVita() <= 0) {
                            log.red(sconfitta);
                            return;
                        } else {
                            if (!isEscaped) {
                                if (mostro instanceof Drago) {
                                    System.out.println("CONGRATULAZIONI HAI COMPLETATO IL GIOCO!!!");
                                    return;
                                }
                                eroe.setLivello(eroe.getLivello() + 1);
                                eroe.calcolaAttaccoMagico(initialMagicAttack, eroe);
                                log.green("Il tuo livello è salito a: " + eroe.getLivello());
                                dropObject(eroe);
                            } else
                                System.out.print("");
                        }

                    } else if (scelta > 5 && scelta <= 9) {
                        damage(eroe);

                    } else if (scelta > 9 && scelta <= 12) {
                        log.cyan("\nIncontro con un PNG");
                        png = PersonaggioNonGiocante.insertPng();
                        png.actionPNG(eroe, png, maxLife, guerriero, mago, elfo);

                    } else if (scelta > 12 && scelta <= 17) {
                        System.out.println("Stanza vuota \n");

                    } else {
                        Oggetti drop = dropObject(eroe);
                    }

                    if (!isEscaped && mostro == drago) {
                        break; // Uscita dal ciclo se era un drago e non è scappato
                    }
                    continue;

                    //PORTA DI DESTRA **************************
                case 3:
                    stringDoor = "Hai scelto la porta di destra";
                    log.blue(stringDoor);

                    scelta = (int) (Math.random() * 19) + 1;

                    if (scelta > 0 && scelta <= 5) {
                        if (eroe.getLivello() <= 9) {
                            mostro = Mostri.insertMonster(goblin, scheletro, orco, drago);
                        } else {
                            mostro = Drago.generateDragon();
                        }
                        difesa = 1; // Necessario per modificare l'attacco del mostro
                        log.red("E' uscito un " + mostro.getClass().getSimpleName());
                        isEscaped = battle(scanner, eroe, mostro, difesa, maxLife);
                        System.out.print("\n");
                        if (eroe.getVita() <= 0) {
                            log.red(sconfitta);
                            return;
                        } else {
                            if (!isEscaped) {
                                if (mostro instanceof Drago) {
                                    System.out.println("CONGRATULAZIONI HAI COMPLETATO IL GIOCO!!!");
                                    return;
                                }
                                eroe.setLivello(eroe.getLivello() + 1);
                                eroe.calcolaAttaccoMagico(initialMagicAttack, eroe);
                                log.green("Il tuo livello è salito a: " + eroe.getLivello());
                                dropObject(eroe);
                            } else
                                System.out.print("");
                        }
                    } else if (scelta > 5 && scelta <= 9) {
                        damage(eroe);

                    } else if (scelta > 9 && scelta <= 12) {
                        log.cyan("\nIncontro con un PNG");
                        png = PersonaggioNonGiocante.insertPng();
                        png.actionPNG(eroe, png, maxLife, guerriero, mago, elfo);

                    } else if (scelta > 12 && scelta <= 17) {
                        System.out.println("Stanza vuota \n");

                    } else {
                        Oggetti drop = dropObject(eroe);
                    }

                    if (!isEscaped && mostro == drago) {
                        break; // Uscita dal ciclo se era un drago e non è scappato
                    }
                    continue;
                default:
                    log.yellow("Inserisci un valore da 1 a 3:");
            }
        } while ((!(mostro instanceof Drago) || mostro.getVita() > 0) && eroe.getLivello() < 11);
    }

    // DANNO DI 1
    static void damage(Eroi eroe) {
       Logger.getInstance().red("Sei caduto in una trappola");
        Logger.getInstance().magent(eroe.getClasse() + " subisce un danno di 1");
        eroe.setVita(eroe.getVita() - 1);
        System.out.println("HP: " + eroe.getVita() + "\n");
    }

    // METODO DELLA BATTAGLIA CON UN MOSTRO
    static boolean battle(Scanner scanner, Eroi eroe, Mostri mostro, int difesa, int maxLife) {
        do {
            System.out.println("HP " + eroe.getClasse() + ": " + eroe.getVita() + " - " +
                    "HP " + mostro.getClasse() + ": " + mostro.getVita() + " ATK: " + mostro.getAttacco());
            System.out.println(Eroi.choiceAction(eroe));
            int inputAction = scanner.nextInt();
            switch (inputAction) {
                case 1:
                    Eroi.attack(eroe, mostro);
                    if (mostro.getVita() > 0) {
                        Mostri.monsterAttack(eroe, mostro, difesa);
                        Logger.getInstance().magent("Hai subito " + mostro.getAttacco() / difesa + " di danno");
                    }
                    break;
                case 2:
                    if (difesa == 1) {
                        Logger.getInstance().yellow("Subirai la metà dei danni");
                        difesa++;
                        Mostri.monsterAttack(eroe, mostro, difesa);
                        Logger.getInstance().magent("Hai subito " + mostro.getAttacco() / difesa + " di danno");
                    } else {
                        Logger.getInstance().yellow("Puoi aumentare la tua difesa una volta per avversario \n");
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
                                if (inp == 0) {
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
                                Logger.getInstance().yellow("Inserisci un valore corretto");
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
                        if (mostro.getVita() > 0) {
                            Mostri.monsterAttack(eroe, mostro, difesa);
                            Logger.getInstance().magent("Hai subito " + mostro.getAttacco() / difesa + " di danno");
                        }
                    } else
                        Logger.getInstance().yellow("Scegli un valore da 1 a 4");
                    break;
                default:
                    if (eroe instanceof Guerriero) {
                        Logger.getInstance().yellow("Scegli un valore da 1 a 4");
                    } else {
                        Logger.getInstance().yellow("Scegli un valore da 1 a 5");
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

    public static Oggetti dropObject(Eroi eroe) {
        Oggetti oggetto = Eroi.findObject();
        String string = "Hai ricevuto una: ";
        Logger.getInstance().green(string + oggetto);
        if (oggetto == Oggetti.POZIONE)
            Logger.getInstance().green("Permette di recuperare la vita di 25 HP");
        else if (oggetto == Oggetti.BOMBA)
            Logger.getInstance().green("Infligge un danno di 35 HP al mostro");
        else
            Logger.getInstance().green("Permette di acquistare oggetti dal mercante");

        eroe.getInventario().add(oggetto);
        System.out.println("Inventario: " + eroe.getInventario() + "\n");

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
