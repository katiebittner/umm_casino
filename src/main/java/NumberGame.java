import java.util.ArrayList;
import java.util.Scanner;

public class NumberGame extends Game {
    int money;
    int bet; //The amount of money the user is going to bet

    public static void main(String[] args) {
        System.out.println("derp");

        NumberGame ni = new NumberGame();
    }

    NumberGame() {

        scanner = new Scanner(System.in); //User input
        poc = new PackOfCards();

        printInstructions();
        run();
    }

    NumberGame(String Test) {
        poc = new PackOfCards();
    }

    public void printInstructions() {

        System.out.println("Welcome to Unemployed Murder Monkey's House Card Game!");
        System.out.println();
        System.out.println("This game is High or Low with a deck of cards. Your goal is to guess if the next number flipped is" +
                "higher or lower than the current card showing. Ace is low. Easy, right?");
        System.out.println("Let's get started!"); //Detective Pikachu art

    }

    public void run() {
        money = Casino.playersCash;  // User starts with $100.
        poc.shuffle();
        boolean userWins = false; //Did the user win the game? Used for incrementing money.
        boolean playon = true;

        System.out.println("You have " + money + " dollars to start.");

        while (playon) {

            if (money == 0) {
                System.out.println("Looks like you are out of money!");
                System.out.println("The first step to recovery is admitting you have a problem " + Casino.playersName + ". The national problem gambling helpline is 1-800-522-4700.");
                playon = false;
            } else {

                System.out.println("How much money do you want to bet?  (Enter 0 to end.)");
                System.out.print("?");

                bet = scanner.nextInt();

                if (bet > 1 && bet <= money) {
                    userWins = playNumberGame();
                } else if (bet == 0) {
                    System.out.println("EXITING UNEMPLOYED MURDER MONKEY'S HOUSE CARD GAME");

                    System.out.println("\nYou leave with $" + money + '.');

                    Casino.playersCash = money;

                    playon = false;
                } else {
                    System.out.println("Your answer must be between 0 and " + money + '.');
                }

                if (userWins) {
                    money += bet;
                } else {
                    money -= bet;
                }
            }
        }
    }

    public boolean playNumberGame() { //This is checking if the user has guessed the card correctly

        PackOfCards poc = new PackOfCards();
        ArrayList<Card> discard = new ArrayList<Card>();
        Scanner question = new Scanner(System.in);
        poc.shuffle();
        Card newCard = poc.dealCard();
        discard.add(newCard);

        PackOfCards.printArt(newCard.toCharGraphic());

        System.out.println("Do you think the next card is Higher (H) or Lower (L)?");
        System.out.println();
        String guess = question.nextLine().toUpperCase();

        Card card2 = poc.dealCard();
        PackOfCards.printArt(card2.toCharGraphic());
        boolean isItEqual = isEqual(newCard, card2);
        if (isItEqual) {
            System.out.println("It's a draw. Dealer wins! Your current pot is: " + (money - bet));
            return false;
        }
        //returns true if the second card is higher than the first
        boolean isItHigher = isHigher(newCard, card2);
        if (isItHigher) {
            if (guess.equals("H")) {
                System.out.println("You guessed correctly! Your current pot total is: " + (money + bet));
                return true;
            } else {
                System.out.println("You did not guess the card correctly. It was actually higher! Your current pot total is:  " + (money - bet));
                return false;
            }

        } else {
            if (guess.equals("L")) {
                System.out.println("You guessed correctly! Your current pot total is: " + (money + bet));
                return true;
            } else {
                System.out.println("You did not guess the card correctly. It was actually lower! Your current pot total is:  " + (money - bet));
                return false;

            }
        }
    }

    //returns true if the cards are equal
    public boolean isEqual(Card card1, Card card2) {
        if (card1.getValue().ordinal() == card2.getValue().ordinal()) {
            return true;
        } else {
            return false;
        }
    }

    //returns true if the second card is higher than the first
    public boolean isHigher(Card card1, Card card2) {
        if (card1.getValue().ordinal() < card2.getValue().ordinal()) {
            return true;
        } else {
            return false;
        }
    }
}