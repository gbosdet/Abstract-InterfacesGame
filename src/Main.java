import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Player player;
    static Random rand;
    static Scanner input;
    static Weapon[] weapons;
    static Enemy[] enemies;
    static Enemy enemy;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        rand = new Random();
        loadWeapons();
        loadEnemies();
        System.out.println();
        System.out.println("Welcome to Guns n' Swords: Polymorphic Steampunk");
        playerInit();
        while (true) {

            townIntro();
            char userInput = input.next().toLowerCase().charAt(0);
            switch (userInput) {
                case 'l':
                    arena();
                    break;
                case 'w':
                    weaponShop();
                    break;
                case 'i':
                    inn();
                    break;
                case 's':
                    status();
                    break;
                case 'd':
                    if (player.getLevel() >= 30) {
//                        defendCity();
//                        endGame();
                        break;
                    }
                default:
                    System.out.println("That is not an option. Please try again.");
                    pause(1.2);

            }
        }

    }

    public static void playerInit() {

        char reroll = 'y';
        System.out.print("Enter your character's name: \t");
        String name = input.next();
        player = new Player(name);
        do {
            player.reroll();
            player.displayStats();
            System.out.println("Would you like to roll again?");
            reroll = input.next().charAt(0);
        } while (reroll == 'y');
    }

    private static void status() {
        player.displayStats();
        System.out.println("Press enter to continue");
        System.out.println("\n\n\n\n\n\n\n");
        //Sneaky way to press any key to continue
        //input.next();
        try {
            System.in.read();  //Tries to read a char from keyboard and return an
        } catch (Exception e) {
        }

    }


    private static void townIntro() {
        System.out.println("\n\n\n\n\n");
        System.out.println("\n\n---------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("Welcome to the last great city of Utopia.");
        System.out.println("\tWhat would you like to do?");
        System.out.println("\t\t[L] : Leave the protection of the city");
        System.out.println("\t\t[W] : Go to weapon shop");
        System.out.println("\t\t[I] : Go to the inn (cost: 10 gold, all HP and MP recovered)");
        System.out.println("\t\t[S] : Check Status");
        if (player.getLevel() >= 30) {
            System.out.println("\t\t[D] : Defend City");
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    private static void inn() {
        if (player.getGold() >= 10) {
            player.decreaseGold(10);
            player.heal();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("You have an excellent sleep and feel much better in the morning.");
            pause(1.2);

        } else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("You don't have enough money.");
            pause(1.2);
        }
    }


    private static void weaponShop() {
        int shopChoice = -1;
        while (shopChoice != 0) {
            System.out.println("\n\n\n\n\n");
            System.out.println("\n\n\t------------------------------------------------------------\n");
            System.out.println("\t\tWhat would you like to buy?");

            for (int i = 0; i < weapons.length; i++) {
                System.out.println("\t\t[" + (i + 1) + "] : " + weapons[i] + "\tCost:" + weapons[i].getCost());
            }
            System.out.println("\t\t[0]  Exit the shop");
            System.out.println("\n\t------------------------------------------------------------\n");
            System.out.println("\t\t\t\t ------------");
            System.out.println("\t\t\t\t   Gold: " + player.getGold());
            System.out.println("\t\t\t\t ------------");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            while (!input.hasNextInt()) {
                input.next();
            }
            shopChoice = input.nextInt();
            if (shopChoice == 0) {
                System.out.println("Goodbye!");
                pause(1.2);
            } else if (shopChoice <= 7 && shopChoice > 0) {
                if (player.getWeapon().getPowerLevel() >= weapons[shopChoice - 1].getPowerLevel()) {
                    System.out.println("You don't need that weapon. It is no better than what you have already.");
                    pause(1.2);
                } else if (weapons[shopChoice - 1].getCost() <= player.getGold()) {
                    player.decreaseGold(weapons[shopChoice - 1].getCost());
                    player.setWeapon(weapons[shopChoice - 1]);
                    System.out.println("You bought the " + weapons[shopChoice - 1].getName());
                    pause(1.4);
                } else {
                    System.out.println("You don't have enough gold");
                    pause(1.2);
                }

            } else {
                System.out.println(shopChoice + " is not an an option");
                pause(1.2);
            }
        }
    }

    private static void arena() {

        char userInput = 'y';
        while (userInput == 'y') {
            int enemyNum = (player.getLevel() + rand.nextInt(11)) / 5;
            enemyNum = Math.min(enemyNum, enemies.length);
            Enemy e = enemies[enemyNum];
            enemy = new Enemy(e.getName(), e.getMaxHealth(), e.getExperience(), e.getGold(), e.getStrength(), e.getAccuracy(), e.getWeapon(), e.getToSay());
            System.out.println("------------------------------------------------------");
            System.out.println("\t# A " + enemy.getName() + " appeared! #\n");

            System.out.println("Enemy number: " + Enemy.getNumEnemies());
            System.out.println(player.getName() + " says:");
            player.talk();
            System.out.println(enemy.getName() + " says:");
            enemy.talk();

            while (true) {

                System.out.println("Your HP:   " + player.getHealth());
                System.out.println(enemy.getName() + " HP:   " + enemy.getHealth());
                System.out.println("\n \nWhat do you want to do? Attack (A) or Run (R)");
                userInput = input.next().charAt(0);
                if (userInput == 'r' || userInput == 'R') {

                    System.out.println("You escaped the " + enemy.getName() + "\n\n");
                    break;
                }


                if (userInput == 'a') {

                    int damage = player.getWeapon().getDamage(player);
                    enemy.takeDamage(damage);
                    System.out.println("You hit the " + enemy.getName() + " for " + damage + " damage!");
                    if (enemy.getHealth() < 1) {
                        System.out.println(enemy.getName() + " Terminated");
                        System.out.println("You received " + enemy.getExperience() + " experience.");
                        System.out.println("You received " + enemy.getGold() + " gold pieces.");
                        player.gainExperience(enemy.getExperience());
                        player.increaseGold(enemy.getGold());
                        break;
                    }
                }

                enemyAttack();
            }
            player.getWeapon().reload();
            System.out.println("\t\t\t\t\t-------------------------");
            System.out.println("\t\t\t\t\t  Experience: " + player.getExperience() + "/" + player.getLevel() * 100);
            System.out.println("\t\t\t\t\t  Gold Pieces: " + player.getGold());
            System.out.println("\t\t\t\t\t-------------------------");
            System.out.println("Would you like to look for a new enemy to face?(y/n)");
            userInput = input.next().toLowerCase().charAt(0);

        }
    }

    private static void enemyAttack() {

        int enemyDamage = enemy.getWeapon().getDamage(enemy);
        player.takeDamage(enemyDamage);
        System.out.println("The " + enemy.getName() + " hit you for " + enemyDamage + "\n\n");
        if (player.getHealth() <= 0) {
            System.out.println("You have died.\n");
            System.out.println("Thank you for playing Sword of Knowledge!");
            System.exit(0);
        }

    }

    private static void pause(double seconds) {
        int milliseconds = (int) (seconds * 1000);
        try {
            // wait 1 second for people to see the message
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void loadWeapons() {
        weapons = new Weapon[6];
        weapons[0] = new Sword("Rapier     ", 15, 100);
        weapons[1] = new Gun("Dueling Gun", 30, 2, 250);
        weapons[2] = new MachineGun("Devastator", 20, 13, 2000, 5);
        weapons[3] = new Sword("Sky Splitter", 150, 5000);
        weapons[4] = new Gun("Hand Cannon", 65, 3, 900);
        weapons[5] = new MachineGun("Excalibur", 2000, 500, Integer.MAX_VALUE, 50);
        Arrays.sort(weapons);
    }

    private static void loadEnemies() {
        enemies = new Enemy[6];
        enemies[0] = new Enemy("Mutant Scrapper", 15, 10, 10, 8, 8, new Sword("Sharp Stick", 3, 0), "RRRAAAWWWWRRR");
        enemies[1] = new Enemy("Mutant Scrapper", 15, 10, 10, 8, 8, new Sword("Sharp Stick", 3, 0), "RAWR");
        enemies[2] = new Enemy("Mutant Scrapper", 15, 10, 10, 8, 8, new Sword("Sharp Stick", 3, 0), "rawr?");
        enemies[3] = new Enemy("Mutant Scrapper", 15, 10, 10, 8, 8, new Sword("Sharp Stick", 3, 0), "Bye");
        enemies[4] = new Enemy("Mutant Scrapper", 15, 10, 10, 8, 8, new Sword("Sharp Stick", 3, 0), "Not in the face!");
        enemies[5] = new Enemy("Mutant Scrapper", 15, 10, 10, 8, 8, new Sword("Sharp Stick", 3, 0), "AHHHHH");
        Enemy.numEnemies = 0;
    }

}
