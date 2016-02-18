import java.util.ArrayList;
import java.util.Scanner;

public class Bacarat extends Game {

    Bacarat() {
        scanner = new Scanner(System.in);
        poc = new PackOfCards();
        poc.shuffle();
        run();
    }

    Bacarat(String test) {
        poc = new PackOfCards();
    }

    public void run() {
        int money;          // Amount of money the user has.
        int bet;            // Amount user bets on a game.
        boolean userWins;   // Did the user win the game?

        System.out.println("Welcome " + Casino.playersName + " to the game of baccarat.");
        System.out.println("\nThe object of the game is to get as close to 9 as possible");
        System.out.println("Have fun!");


        money = Casino.playersCash;  // User starts with $100.

        while (true) {
            System.out.println("You have " + money + " dollars.");
            do {
                System.out.println("How much money do you want to bet?  (Enter 0 to end.)");
                System.out.println();
                bet = scanner.nextInt();

                if (bet < 0 || bet > money) {
                    System.out.println("Your answer must be between 0 and " + money + '.');
                }
            } while (bet < 0 || bet > money);
            if (bet == 0) {
                System.out.println("EXITING BACCARAT");

                break;
            }
            userWins = playBacarat();
            if (userWins) {
                money = money + bet;
            } else {
                money = money - bet;
            }
            System.out.println();
            if (money == 0) {
                System.out.println("Looks like you are out of money!");
                System.out.println("The first step to recovery is admitting you have a problem " + Casino.playersName + ". The national problem gambling helpline is 1-800-522-4700.");
                break;
            }
        }
        System.out.println("\nYou leave with $" + money + '.');

        Casino.playersCash = money;
    }

    private boolean playBacarat() {
        // Let the user play one game.
        // Return true if the user wins, false if the user loses.

        ArrayList<Card> dealerHand = new ArrayList<Card>();   // The dealer's hand.
        ArrayList<Card> userHand = new ArrayList<Card>();     // The user's hand.

        dealerHand.add(poc.dealCard());
        dealerHand.add(poc.dealCard());
        userHand.add(poc.dealCard());
        userHand.add(poc.dealCard());

        /* Check if one of the players has a natural.
        The player with Blackjack wins the game.  Dealer wins ties.
         */
        int userHandValue, dealerHandValue;

        userHandValue = value(userHand);
        dealerHandValue = value(dealerHand);

        if (dealerHandValue >= 8 || userHandValue >= 8) {
            System.out.println(Casino.playersName + "  has the following hand:");

            printhand(userHand);

            System.out.println("Dealer has the following hand:");

            printhand(dealerHand);

            if (dealerHandValue > userHandValue) {
                System.out.println("Dealer wins! Dealer has " + dealerHandValue + " and " + Casino.playersName + " has " + userHandValue + ".");
                return false;
            } else if (dealerHandValue < userHandValue) {
                System.out.println(Casino.playersName + " wins! Dealer has " + dealerHandValue + " and " + Casino.playersName + " has " + userHandValue + ".");
                return true;
            } else {
                System.out.println("Dealer wins on a draw! Dealer and " + Casino.playersName + " both have " + userHandValue + ".");
                return false;
            }
        }

        System.out.println("\nYour cards are:");

        printhand(userHand);

        System.out.println("\nDealer is showing the following hand:");
        printhand(dealerHand);

        System.out.println("Neither player has a natural.");

        if (userHandValue <= 5) {
            System.out.println("\n" + Casino.playersName + " has a hand worth less than 5. Press and return any number to draw your third card.");
            int test = scanner.nextInt();
            userHand.add(poc.dealCard());

            System.out.println("\nYour cards are now:");

            printhand(userHand);
        } else {
            System.out.println(Casino.playersName + " stands with a hand value of " + userHandValue);
        }

        if (userHand.size() == 2) {
            if (dealerHandValue <= 5) {
                System.out.println("\nDealer has a hand worth less than 5. Press and return any number to see the dealer draw.");
                int test = scanner.nextInt();
                dealerHand.add(poc.dealCard());

            } else {
                System.out.println("Dealer stands with a hand value of " + dealerHand);
            }
        } else {
            if (dealerHandValue <= 2) {
                dealerHand.add(poc.dealCard());
            } else if (dealerHandValue == 3 && (userHand.get(2).getValue().ordinal() + 1 != 8)) {
                dealerHand.add(poc.dealCard());
            } else if (dealerHandValue == 4 && (userHand.get(2).getValue().ordinal() + 1 < 8 && userHand.get(2).getValue().ordinal() + 1 != 1)) {
                dealerHand.add(poc.dealCard());
            } else if (dealerHandValue == 5 && (userHand.get(2).getValue().ordinal() + 1 < 8 && userHand.get(2).getValue().ordinal() + 1 > 3)) {
                dealerHand.add(poc.dealCard());
            } else if (dealerHandValue == 6 && (userHand.get(2).getValue().ordinal() + 1 == 6 || userHand.get(2).getValue().ordinal() + 1 == 7)) {

            } else if (dealerHandValue == 7) {
                System.out.println("Dealer stands with a hand value of " + dealerHandValue + ".");
            }
        }

        System.out.println(Casino.playersName + "  has the following hand:");

        printhand(userHand);
        System.out.println("\nDealer has the following hand:");

        printhand(dealerHand);

        if (dealerHandValue > userHandValue) {
            System.out.println("Dealer wins! Dealer has " + dealerHandValue + " and " + Casino.playersName + " has " + userHandValue + ".");
            return false;
        } else if (dealerHandValue < userHandValue) {
            System.out.println(Casino.playersName + " wins! Dealer has " + dealerHandValue + " and " + Casino.playersName + " has " + userHandValue + ".");
            return true;
        } else {
            System.out.println("Dealer wins on a draw! Dealer and " + Casino.playersName + " both have " + userHandValue + ".");
            return false;
        }
    }

    public int value(ArrayList<Card> hand) {
        // Returns the value of this hand for the
        // game of Blackjack.

        int cardVal;  // The value of each card

        int val = 0;      // The value computed for the hand.

        int cards = hand.size();    // Number of cards in the hand.

        for (int i = 0; i < cards; i++) {
            cardVal = hand.get(i).getValue().ordinal() + 1;  // The normal value, 1 to 13.
            if (cardVal < 11) {
                val += cardVal;
            }
        }

        return val % 10;
    }

}
