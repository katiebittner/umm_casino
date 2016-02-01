/**
 * Created by wscown on 1/29/16.
 */

import java.util.*;

public class NumberGame extends Game {

    private static Scanner scanner = new Scanner(System.in);
    int money ;
    int bet;

    public static void main(String[] args){

    NumberGame numberGame = new NumberGame();
    }

    NumberGame() {

        printInstructions();
        run();

    }

    public void printInstructions() {

        System.out.println("Welcome to Unemployed Murder Monkey's House Card Game!");
        System.out.println();
        System.out.println("Your goal is to guess the card that we are hiding from you. Pretty simple right?");
        System.out.println("Let's get started!"); //Detective Pikachu art

    }

    public void run() {

        money = 100;  // User starts with $100.

        while (true) {
            System.out.println("You have " + money + " dollars to start.");
            do {
                System.out.println("How much money do you want to bet?  (Enter 0 to end.)");
                System.out.print("? ");
                System.out.println();
                bet = scanner.nextInt();


                if (bet < 0 || bet > money) {
                    System.out.println("Your answer must be between 0 and " + money + '.');
                }
            } while (bet < 0 || bet > money);
            if (bet == 0) {
                System.out.println("EXITING RANDOMNUMBERGAME");
                Casino casino = new Casino();
                casino.options();
            }
        }
    }

        public boolean HighAndLow() {

            PackOfCards poc = new PackOfCards();
            ArrayList<Card> discard = new ArrayList<Card>();
            Scanner question = new Scanner(System.in);
            Card newCard = poc.dealCard();
            discard.add(newCard);

            PackOfCards.printArt(newCard.toCharGraphic());

            System.out.println("Do you think the next card is Higher (H) or Lower (L)?");
            System.out.println();
            String guess = question.nextLine().toUpperCase();

            Card card2 = poc.dealCard();
            PackOfCards.printArt(card2.toCharGraphic());

            if ((newCard.getValue().ordinal() < card2.getValue().ordinal()) && guess.equals("h")) {
                System.out.println("Wow, you don't actually suck." + (money + bet));
                return true;

            }
            if ((newCard.getValue().ordinal() == card2.getValue().ordinal()) && guess.equals("higher") || guess.equals("lower"));
            System.out.println("It's a draw, and we still keep your money. Sorry!" + (money - bet));

            if ((newCard.getValue().ordinal() > card2.getValue().ordinal()) && guess.equals("lower")) {
            System.out.println("You suck." + (money - bet));
                return false;
            }
            else {
            System.out.println("Wow, you don't actually suck. I guess that means you cheated like you do with everything in life." + (money + bet));
                return true;

    }

            while (true) {

                System.out.println();
                System.out.println();
                System.out.println(money + " is what you have to bet with.");

                //The user's action is H

                System.out.println("You have selected that the next card will be Higher.");
                System.out.println("The cards being compared are: " + newCard + "" + card2);
                if (newCard.getValue().ordinal() > card2.getValue().ordinal() && guess.equals("H")) {
                    System.out.println("You suck." + (money - bet));
                    return false;
                }

                //The user's action is L

                System.out.println("You have selected that the next card will be Lower.");
                System.out.println("The cards being compared are: " + newCard + "" + card2);
                if (newCard.getValue().ordinal() > card2.getValue().ordinal() && guess.equals("L")) {
                    System.out.println("");
                    return false;
                }
            }//End of While loop

            //The user still has money and has not incorrectly guessed a card or lost all of their money, so it goes to the next conditional loop

            System.out.println();
            System.out.println("You have " + money+ ". Would you like to bet double or nothing? (Y/N) ");
            System.out.println();



    }





}