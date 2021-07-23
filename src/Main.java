import java.util.Scanner;
import java.util.Random;

public class Main {

    static Random rand = new Random();
    static Scanner input = new Scanner(System.in);

    static int randEnemy = rand.nextInt(3);

    static int playerHealth = 10;
    static String playerWeapon = "Knife";

    static String Spider;
    static int spiderHealth = 10;

    static String Ant;
    static int antHealth = 10;

    static String Dragon;
    static int dragonHealth = 10;

    static boolean isDragon;
    static boolean isAnt;
    static boolean isSpider;
    static boolean isrunning;
    static boolean isfighting;

    public static void main(String[] args) {

        System.out.println("ohayo gozaimasu!\nType help");
        do {
            isrunning = false;
            switch (input.nextLine()){
                case "help":
                    System.out.println("------------------------------------------");
                    System.out.println("fight - Use this command to fight random demons.");
                    System.out.println("inv - Use this to know about your health & weapon.");
                    System.out.println("clear -  Use to clear the screen.");
                    System.out.println("exit - Use to know quit the game.");
                    System.out.println("Thanks for playing!");
                    System.out.println("Source code available @ https://github.com/Sidhhh/text-based-adventure-game#text-based-adventure-game-tbag");
                    System.out.println("Based on the idea by https://github.com/Asianerd/TextAdventure");
                    System.out.println("------------------------------------------");
                    isrunning = true;
                    break;
                case "inv":
                    System.out.println("---------------------");
                    System.out.println("Health: " + playerHealth);
                    System.out.println("Weapon: " + playerWeapon);
                    System.out.println("---------------------");
                    isrunning = true;
                    break;
                case "fight":
                    fight(args);
                    main(args);
                case "clear":
                    for (int i = 0; i < 10; i++){
                        System.out.println("\n");
                    }
                    isrunning = true;
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("ERRRR");
                    isrunning = true;
            }
        }while (isrunning);

    }
    public static void fight(String[] args){

        if (randEnemy == 1) {
            isSpider = true;
            isAnt = false;
            isDragon = false;
        }
        else if (randEnemy == 2){
            isSpider = false;
            isAnt = true;
            isDragon = false;
        }
        else if (randEnemy == 3) {
            isSpider = false;
            isAnt = false;
            isDragon = true;
        }

        int attack = rand.nextInt(3);
        playerHealth = playerHealth-attack;
        if (isSpider) {
            if (spiderHealth >= 0) {
                if (playerHealth >= 0) {
                    System.out.println("You have been attacked!...type attack to attack the SPIDER");
                    System.out.println("Your health: " + playerHealth);
                    do {
                        isrunning = false;
                        switch (input.nextLine()) {
                            case "exit":
                                return;
                            case "attack":
                                attack(args);
                            case "inv":
                                System.out.println("---------------------");
                                System.out.println("Health: " + playerHealth);
                                System.out.println("Weapon: " + playerWeapon);
                                System.out.println("---------------------");
                                fight(args);
                            default:
                                System.out.println("ERRR");
                                fight(args);
                        }
                    } while (isfighting);
                } else {
                    playerHealth = 10;
                    spiderHealth = 10;
                    System.out.println("You lost");
                    main(args);
                }
            } else {
                playerHealth = 10;
                spiderHealth = 10;
                System.out.println("You won!");
                main(args);
            }
        }
        else if (isAnt) {
            if (antHealth >= 0) {
                if (playerHealth >= 0) {
                    System.out.println("You have been attacked!...type attack to attack the ANT");
                    System.out.println("Your health: " + playerHealth);
                    do {
                        isrunning = false;
                        switch (input.nextLine()) {
                            case "exit":
                                return;
                            case "attack":
                                attack(args);
                            case "inv":
                                System.out.println("---------------------");
                                System.out.println("Health: " + playerHealth);
                                System.out.println("Weapon: " + playerWeapon);
                                System.out.println("---------------------");
                                fight(args);
                            default:
                                System.out.println("ERRR");
                                fight(args);
                        }
                    } while (isfighting);
                } else {
                    playerHealth = 10;
                    antHealth = 10;
                    System.out.println("You lost");
                    main(args);
                }
            } else {
                playerHealth = 10;
                antHealth = 10;
                System.out.println("You won!");
                main(args);
            }
        }
        else {
            if (dragonHealth >= 0) {
                if (playerHealth >= 0) {
                    System.out.println("You have been attacked!...type attack to attack the DRAGON");
                    System.out.println("Your health: " + playerHealth);
                    do {
                        isrunning = false;
                        switch (input.nextLine()) {
                            case "exit":
                                return;
                            case "attack":
                                attack(args);
                            default:
                                System.out.println("ERRR");
                                fight(args);
                        }
                    } while (isfighting);
                } else {
                    playerHealth = 10;
                    dragonHealth = 10;
                    System.out.println("You lost");
                    main(args);
                }
            } else {
                playerHealth = 10;
                dragonHealth = 10;
                System.out.println("You won!");
                main(args);
            }
        }
    }
    public static void attack(String[] args){
        Random rand = new Random();

        int attack = rand.nextInt(  3);

        if (isAnt){
            antHealth = antHealth - attack;
            System.out.println("You attacked the ANT");
            System.out.println("Enemy Health: " + antHealth);
            fight(args);
        }
        else if (isSpider) {
            spiderHealth = spiderHealth-attack;
            System.out.println("You attacked the SPIDER");
            System.out.println("Enemy Health: " + spiderHealth);
            fight(args);
        }
        else {
            dragonHealth = dragonHealth-attack;
            System.out.println("You attacked the DRAGON");
            System.out.println("Enemy Health: " + dragonHealth);
            fight(args);
        }
    }
}
