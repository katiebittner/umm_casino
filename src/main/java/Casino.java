import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wscown on 1/29/16.
 */
public class Casino {
    //initializing an empty arrayList of players
    private ArrayList<Player> players = new ArrayList<Player>();
    private int Maxcompplayers = 3;
    //initializes the activeGame to be later up cast into one of the specific Game classes
    private Game activeGame = new Game();
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Casino casino = new Casino();
    }
    Casino(){
        options();


    }

    //main menu
    void options() {
        System.out.println("Would you like add a player ('A'), remove a player ('R'), " +
                "select a game ('G'), or view credits ('C')?");
        String userInput = scan.nextLine();
        char userChoice = userInput.charAt(0);
        switch (userChoice) {
            case ('A'): {
                addPlayer();
                options();
            }
            break;
            case ('R'): {
                removePlayer();
                options();
            }
            break;
            case ('G'): {
                //before starting a game, check the size of the array
                if (players.size() == 4) {
                    selectGame();
                } else if (players.size() == 0) {
                    System.out.println("You must add at least one player.");
                    addPlayer();
                } else {
                    //get random Computer players
                }
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

    void addPlayer() {
        if (players.size() < 4) {

            System.out.println("Enter player's name.");
            String player = scan.nextLine();
            players.add(new Player());
            //player constructor takes arguments for name and score. starts at 0
        } else {
            System.out.println("You already have 4 players.");
        }
    }

    void removePlayer() {
        System.out.println("Remove how many players?");
        int removing = scan.nextInt();
        for (int i = 0; i <= removing; i++) {
            players.remove(i);
        }

    }

    void selectGame() {
        System.out.println("Choose from Blackjack, Baccarat, or NumberGame.");
        String newGame = scan.nextLine();
        //need Game constructor

    }

    void credits() {
        System.out.println("Made by the UMM crew: Katie Bittner, John Davis," +
                "Jocelyn Harper, Will Scown. January 2016");
        options();
    }

}

