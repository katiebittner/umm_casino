import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wscown on 1/29/16.
 */
public class Casino {


    public static String playersName = "Default";
    public static int playersCash = 100;
    private boolean stayingame = true;
    //initializing an empty arrayList of players

    //initializes the activeGame to be later up cast into one of the specific Game classes
    Scanner scan;

    public static void main(String[] args) {
        Casino casino = new Casino();
    }

    Casino() {
        System.out.println(ArtWork.welcome);
        scan =  new Scanner(System.in);
        options();
    }

    //main menu

    public void options() {

        while(stayingame) {

            if(playersCash == 0){
                System.out.println("You're now broke. Do you A: Lunge at a table, grab a handful of chips, and make a run for it? B: Get absolutely annihilated drunk on stolen drinks. or C: Try to plead your case to the Unemplyed Murder Monkeys?");
                while(!scan.hasNext()) {}

                char userInput = Character.toUpperCase(scan.next().charAt(0));

                switch(userInput){
                    default:{
                        System.out.println(ArtWork.angrymonkey);
                        System.out.println("You have displeased the monkeys and have been thrown out of the casino!");
                        stayingame = false;
                        break;
                    }
                }

            }

            if(stayingame) {

                System.out.println("WELCOME TO THE MAIN MENU");
                System.out.println("Would you like add a player ('A'), remove a player ('R'), " +
                        "select a game ('G'), or view credits ('C')?");

                while(!scan.hasNext()) {}

                char userChoice = Character.toUpperCase(scan.next().charAt(0));
                switch (userChoice) {
                    case ('A'): {
                        addPlayer();
                        options();
                    }
                    break;
                    case ('R'): {

                        options();
                    }
                    break;
                    case ('G'): {
                        if (playersName.compareTo("Default") == 0) {
                            System.out.println("Please add a player first.");
                        } else {
                            selectGame();
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
        }

    }

    void addPlayer() {

        System.out.println("Enter player's name.");

        while(!scan.hasNext()){}

        playersName = scan.next();
        System.out.println("We've credited your account with $100. If only all casinos worked like this!");
        playersCash = 100;
    }

    void selectGame() {
        System.out.println("Choose from Blackjack, Baccarat, or NumberGame.");
        String newGame;

        while(!scan.hasNext()) {}

        newGame = scan.next();

        if ( newGame.equalsIgnoreCase("Blackjack")){
            System.out.println(ArtWork.blackjack);
            new BlackJack();
        }
        if (newGame.equalsIgnoreCase("Baccarat")){
            System.out.println(ArtWork.baccarat);
            new Bacarat();
        }
        if (newGame.equalsIgnoreCase("Numbergame")){
            System.out.println(ArtWork.numbergame);
            new NumberGame();
        }

    }

    void credits() {
        System.out.println("Made by the UMM crew: Katie Bittner, John Davis," +
                "Jocelyn Harper, Will Scown. January 2016");
        options();
    }
}

