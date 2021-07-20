import java.util.Scanner;
import java.util.Random;

public class Main {

    static int playerHealth = 10;
    static String playerWeapon = "Knife";

    static int enemyHealth = 10;

    static boolean isrunning;
    static boolean isfighting;

    static Scanner input = new Scanner(System.in);

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
        Random rand = new Random();
        //attack
        int attack = rand.nextInt(3);
        playerHealth = playerHealth-attack;
        if (enemyHealth >= 0) {
            if (playerHealth >= 0) {
                System.out.println("You have been attacked!...type attack to attack the knight");
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
            }
            else{
                System.out.println("You lost");
                return;
            }
        }
        else {
            System.out.println("You won!");
            main(args);
        }
    }
    public static void attack(String[] args){
        Random rand = new Random();

        int attack = rand.nextInt(  3);

        enemyHealth = enemyHealth-attack;
        System.out.println("You attacked the knight");
        System.out.println("Enemy Health: " + enemyHealth);
        fight(args);
    }
}
