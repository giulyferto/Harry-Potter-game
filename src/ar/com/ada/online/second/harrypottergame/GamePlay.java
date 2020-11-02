package ar.com.ada.online.second.harrypottergame;

import java.util.*;

public class GamePlay {
    private Character playerOne;
    private Character playerTwo;
    Scanner keyboard = new Scanner(System.in);


    public void ChoosePlayer() {
        System.out.println("Seleccione al jugador uno: ");
        playerOne = chooseCharacter();
        System.out.println("\n");
        System.out.println("Seleccione al jugador dos: ");
        playerTwo = chooseCharacter();
    }

    private Character chooseCharacter() {
        System.out.println("Seleccione 1 si quiere jugar como un MAGO");
        System.out.println("Seleccione 2 si quiere jugar como un ELFO");
        int answer = keyboard.nextInt();
        Character character = null;
        switch (answer) {
            case 1:
                character = chooseWizard();
                break;
            case 2:
                character = chooseElf();
                break;
        }
        return character;
    }

    private Wizard chooseWizard() {
        Wizard wizard = new Wizard();
        System.out.println("Seleccione un mago de la lista: ");
        List<String> wizardsNames = Arrays.asList("Harry Potter", "Draco Malfoy", "Hermione Granger", "Albus Dumbledore", "Severus Snape");//Metodo estatico
        for (int i = 0; i < wizardsNames.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + wizardsNames.get(i));
        }

        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                String name1 = wizardsNames.get(0);
                wizard.setName(name1);
                break;
            case 2:
                String name2 = wizardsNames.get(1);
                wizard.setName(name2);
                break;
            case 3:
                String name3 = wizardsNames.get(2);
                wizard.setName(name3);
                break;
            case 4:
                String name4 = wizardsNames.get(3);
                wizard.setName(name4);
                break;
            case 5:
                String name5 = wizardsNames.get(4);
                wizard.setName(name5);
                break;
            default:
                System.out.println("Debe elegir una opcion valida");
                wizard = null;

        }
        Wand wand = selectionOfWand();
        wizard.setWand(wand);
        wizard.getLocation();
        wizard.setLocation(getLocation());
        return wizard;
    }

    private Elf chooseElf() {
        Elf elf = new Elf();
        System.out.println("Seleccione un Elfo de la lista: ");
        List<String> elfNames = Arrays.asList("Dobby", "Kreacher", "Hokey", "Winky");
        for (int i = 0; i < elfNames.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + elfNames.get(i));
        }

        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                String name1 = elfNames.get(0);
                elf.setName(name1);
                break;
            case 2:
                String name2 = elfNames.get(1);
                elf.setName(name2);
                break;
            case 3:
                String name3 = elfNames.get(2);
                elf.setName(name3);
                break;
            case 4:
                String name4 = elfNames.get(3);
                elf.setName(name4);
                break;
            default:
                System.out.println("Debe elegir una opcion valida");
                elf = null;
        }
        elf.getLocation();
        elf.setLocation(getLocation());
        return elf;
    }
    private char getLocation(){
        System.out.println("Seleccione su ubicacion: ");
        System.out.println("A B C");
        char location = keyboard.next().charAt(0);
        return location;
    }


    public Wand selectionOfWand() {
        Wand wand = new Wand();
        Random rand = new Random(System.nanoTime());
        System.out.println("\nLa varita escoge al mago...");
        int random = rand.nextInt(7);
        int option = random;
        switch (option) {
            case 1:
                wand.setName("Varita de Sauco");
                wand.setPower(60);
                break;
            case 2:
                wand.setName("Varita de Pluma de fénix");
                wand.setPower(50);
                break;
            case 3:
                wand.setName("Varita de Fresno");
                wand.setPower(40);
                break;
            case 4:
                wand.setName("Varita de Madera de serpiente");
                wand.setPower(30);
                break;
            case 5:
                wand.setName("Varita de Abedul");
                wand.setPower(20);
                break;
            case 6:
                wand.setName("Varita de Espino");
                wand.setPower(10);
                break;
            default:
                wand.setName("Varita de Palisandro");
                wand.setPower(5);
                break;
        }
        System.out.println("\t Te ha escogido la " + wand.getName() + " que te añade " + wand.getPower() + " puntos de poder " + "\n");
        return wand;
    }


    public void chooseSpells() {
        Spell spells = new Spell();
        int continueMenu;
        do {
            System.out.println("Por favor ingrese una categoria de hechizos: \n");
            System.out.println("\t1)Hechizos de Ataque\n");
            System.out.println("\t2)Hechizos de Sanacion\n");
            System.out.println("\t3)Hechizos de Recuperacion\n");
            int option = keyboard.nextInt();

            switch (option) {
                case 1:
                    getAttackSpells(keyboard);
                    if (spells != null)
                        spells.addAttackSpell();
                    break;
                case 2:
                    getHealingSpells(keyboard);
                    break;
                case 3:
                    getRecoverySpells(keyboard);
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
            System.out.println("Desea agregar otro Hechizo?: \n\t1) Si\n\t2)No");
            continueMenu = keyboard.nextInt();

        } while (continueMenu == 1);
    }

    private Spell getAttackSpells(Scanner keyboard) {
        Spell spells = new Spell();

        Set<String> attackSpells = new HashSet<String>();
        System.out.println("\nHechizos de ataque:");
        System.out.println("\t1) Avada Kedravra: \n 100pts de daño, 90pts energia magica requerida.");
        System.out.println("\t2) Imperius: \n 90pts de daño, 80pts de energia magica requerida.");
        System.out.println("\t3) Cruciatus: \n 90pts de daño, 80pts de energia magica requerida.");
        System.out.println("\t4) Expulso: \n 25pts de daño, 15pts de energia magica requerida.");
        System.out.println("\t5) Expelliarmus: \n 20pts de daño, 10pts de energia magica requerida.");
        System.out.println("\t6) Sectum: \n 15pts de daño, 8pts de energia magica requerida.");
        System.out.println("\t7) Desmaius: \n 15pts de daño, 10pts de energia magica requerida.");
        System.out.println("\t8) Petrificus totalus: \n 10 pts de daño, 5pts de energia magica requerida.");

        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                spells.setName("Avada Kedravra");
                spells.setDamage(100);
                spells.setMagicPower(90);
                attackSpells.add("Avada Kedravra");
                break;
            case 2:
                spells.setName("Imperius");
                spells.setDamage(90);
                spells.setMagicPower(80);
                attackSpells.add("Imperius");
                break;
            case 3:
                spells.setName("Cruciatus");
                spells.setDamage(90);
                spells.setMagicPower(80);
                attackSpells.add("Cruciatus");
                break;
            case 4:
                spells.setName("Expulso");
                spells.setDamage(25);
                spells.setMagicPower(15);
                attackSpells.add("Expulso");
                break;
            case 5:
                spells.setName("Expelliarmus");
                spells.setDamage(20);
                spells.setMagicPower(10);
                attackSpells.add("Expelliarmus");
                break;
            case 6:
                spells.setName("Sectum");
                spells.setDamage(15);
                spells.setMagicPower(8);
                attackSpells.add("Sectum");
                break;
            case 7:
                spells.setName("Desmaius");
                spells.setDamage(15);
                spells.setMagicPower(10);
                attackSpells.add("Desmaius");
                break;
            case 8:
                spells.setName("Petrificus totalus");
                spells.setDamage(10);
                spells.setMagicPower(5);
                attackSpells.add("Petrificus totalus");
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        return spells;
    }

    private Spell getHealingSpells(Scanner keyboard) {
        Spell spells = new Spell();
        Set<String> healingSpells = new HashSet<String>();
        System.out.println("\nHechizos de Sanacion: ");
        System.out.println("\t1) Anapneo: \n 20pts de sanacion, 15pts energia magica requerida.");
        System.out.println("\t2) Tergeo: \n 20pts de sanacion, 15pts de energia magica requerida.");
        System.out.println("\t3) Ferula: \n 15pts de sanacion, 10pts de energia magica requerida.");
        System.out.println("\t4) Reparifors: \n 10pts de sanacion, 5pts de energia magica requerida.");
        System.out.println("\t5) Episkey: \n 5pts de sanacion, 3pts de energia magica requerida.");
        System.out.println("\t6) Vulnera Sanentur: \n 5pts de sanacion, 3pts de energia magica requerida.");
        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                spells.setName("Anapneo");
                spells.setRecovery(20);
                spells.setMagicPower(15);
                healingSpells.add("Anapneo");
                break;
            case 2:
                spells.setName("Tergeo");
                spells.setRecovery(20);
                spells.setMagicPower(15);
                healingSpells.add("Tergeo");
                break;
            case 3:
                spells.setName("Ferula");
                spells.setRecovery(15);
                spells.setMagicPower(10);
                healingSpells.add("Ferula");
                break;
            case 4:
                spells.setName("Reparifors");
                spells.setRecovery(10);
                spells.setMagicPower(5);
                healingSpells.add("Reparifors");
                break;
            case 5:
                spells.setName("Episkey");
                spells.setRecovery(5);
                spells.setMagicPower(3);
                healingSpells.add("Episkey");
                break;
            case 6:
                spells.setName("Vulnera Sanentur");
                spells.setRecovery(5);
                spells.setMagicPower(3);
                healingSpells.add("Vulnera Sanentur");
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        return spells;
    }

    private Spell getRecoverySpells(Scanner keyboard) {
        Spell spells = new Spell();
        Set<String> recoverySpells = new HashSet<String>();
        System.out.println("\nHechizos de Recuperacion: ");
        System.out.println("\t1) Contorsione: \n 15pts de sanacion, 8pts energia magica requerida.");
        System.out.println("\t2) Taenia: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t3) Ventriculum: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t4) Cortisem detraho: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t5) Enervate: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t6) Reparifors: \n 15pts de sanacion, 8pts de energia magica requerida.");
        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                spells.setName("Contorsione");
                spells.setMagicPower(15);
                spells.setMagicPower(8);
                recoverySpells.add("Contorsione");
                break;
            case 2:
                spells.setName("Taenia");
                spells.setMagicPower(15);
                spells.setMagicPower(8);
                recoverySpells.add("Taenia");
                break;
            case 3:
                spells.setName("Ventriculum");
                spells.setMagicPower(15);
                spells.setMagicPower(8);
                recoverySpells.add("Ventriculum");
                break;
            case 4:
                spells.setName("Cortisem detraho");
                spells.setMagicPower(15);
                spells.setMagicPower(8);
                recoverySpells.add("Cortisem detraho");
                break;
            case 5:
                spells.setName("Enervate");
                spells.setMagicPower(15);
                spells.setMagicPower(8);
                recoverySpells.add("Enervate");
                break;
            case 6:
                spells.setName("Reparifors");
                spells.setMagicPower(15);
                spells.setMagicPower(8);
                recoverySpells.add("Reparifors");
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        return spells;
    }


}