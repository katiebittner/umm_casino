import  java.util.ArrayList;
import  java.util.Scanner;

/**
 * Created by wscown on 1/29/16.
 */
/*public class Casino {

    //initializing an empty arrayList of players

    //initializes the activeGame to be later up cast into one of the specific Game classes
    private Game activeGame = new Game();
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Casino casino = new Casino();
    }

    Casino() {
        options();

    }


    //main menu
    void  options () {
        System.out.println("WELCOME TO THE MAIN MENU");
        System.out.println("Would you like add a player ('A'), remove a player ('R'), " +
                "select a game ('G'), or view credits ('C')?");
        String userinput = scan.nextLine();
        char userChoice = userinput.charAt (0);
        switch (userChoice) {
            case ('A'): {
                addPlayer ();
                options();
            }
            break;
            case ('R'): {

                options();
            }
            break;
            case ('G'): {


                selectGame();
            }
            break;
            case ('C'): {
                credits();
                options();
            }
            break;
            default: {
                System.out.println("Please enter a valid command.");
                options();
            }
        }

    }

    void  addPlayer () {


        System.out.println("Enter player's name.");
        String player = scan.nextLine();
        Player gambler = new Player(player, 100);
        //player constructor takes arguments for name and score. starts at 0
    }





    void selectGame() {
        System.out.println("Choose from Blackjack, Baccarat, or NumberGame.");
        String newGame = scan.nextLine();

        if ( newGame.equalsIgnoreCase("Blackjack")){

            new BlackJack().run();
        }
        if (newGame.equalsIgnoreCase("Baccarat")){
            new  Bacarat ();
        }

    }

    void  credits () {
        System.out.println("Made by the UMM crew: Katie Bittner, John Davis," +
                "Jocelyn Harper, Will Scown. January 2016");
        options();
    }
}*/