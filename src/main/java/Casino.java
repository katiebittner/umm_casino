import java.util.Scanner;

public class Casino {

    public static String playersName = "Default";
    public static int playersCash = 100;
    private boolean stayingame = true;

    Scanner scan;

    public static void main(String[] args) {
        Casino casino = new Casino();
    }

    Casino() {
        System.out.println(ArtWork.welcome);
        scan = new Scanner(System.in);
        options();
    }

    //main menu
    public void options() {

        while (stayingame) {

            if (playersCash == 0) {
                System.out.println("You're now broke. Do you A: Lunge at a table, grab a handful of chips, and make a run for it? " +
                        "B: Get absolutely annihilated drunk on stolen drinks. or C: Try to plead your case to the Unemployed Murder Monkeys?");
                while (!scan.hasNext()) {
                }

                char userInput = Character.toUpperCase(scan.next().charAt(0));

                switch (userInput) {
                    default: {
                        System.out.println(ArtWork.angrymonkey);
                        System.out.println("You have displeased the monkeys and have been thrown out of the casino!");
                        stayingame = false;
                        break;
                    }
                }
            }

            if (stayingame) {

                System.out.println("WELCOME TO THE MAIN MENU");
                System.out.println("Would you like add a player ('A'), " +
                        "select a game ('G'), or view credits ('C')?");

                while (!scan.hasNext()) {
                }

                char userChoice = Character.toUpperCase(scan.next().charAt(0));
                switch (userChoice) {
                    case ('A'): {
                        addPlayer();
                        options();
                    }
                    break;
                    case ('G'): {
                        if (playersName.equals("Default")) {
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

        while (!scan.hasNext()) {
        }

        playersName = scan.next();
        System.out.println("We've credited your account with $100. If only all casinos worked like this!");
        playersCash = 100;
    }

    void selectGame() {
        System.out.println("Choose from Blackjack, Baccarat, or NumberGame.");
        String newGame;

        while (!scan.hasNext()) {
        }

        newGame = scan.next();

        if (newGame.equalsIgnoreCase("Blackjack")) {
            new BlackJack();
        }
        if (newGame.equalsIgnoreCase("Baccarat")) {
            new Bacarat();
        }
        if (newGame.equalsIgnoreCase("NumberGame")){
            new NumberGame();
        }

    }

    void credits() {
        System.out.println("Made by the UMM crew: Katie Bittner, John Davis," +
                "Jocelyn Harper, Will Scown. January 2016");
        options();
    }
}