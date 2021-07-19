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

        do {
            isrunning = false;
            switch (input.nextLine()){
                case "inv":
                    System.out.println("---------------------");
                    System.out.println("Health: " + playerHealth);
                    System.out.println("Weapon: " + playerWeapon);
                    System.out.println("---------------------");
                    main(args);
                case "fight":
                    fight(args);
                    main(args);
                case "help":
                    System.out.println("-----------");
                    System.out.println("Help");
                    break;
                case "clear":
                    for (int i = 0; i < 10; i++){
                        System.out.println("\n");
                    }
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
            System.out.println("You have been attacked!...type attack to attack the knight");
            System.out.println("Your health: " + playerHealth);
            do {
                isrunning = false;
                switch (input.nextLine()) {
                    case "exit":
                        return;
                    case "attack":
                        attack(args);
                }
            } while (isfighting);
        }
        else {
            System.out.println("You won!");
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
