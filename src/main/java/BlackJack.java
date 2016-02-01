import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends Game{

    BlackJack(){
        scanner = new Scanner(System.in);
        poc = new PackOfCards();
        poc.shuffle();
        run();
    }

    public void run()
    {
        int money;          // Amount of money the user has.
        int bet;            // Amount user bets on a game.
        boolean userWins;   // Did the user win the game?

        System.out.println("Welcome " + Casino.playersName + " to the game of blackjack.");
        System.out.println("\nThe objective of the game is to get to 21 or as close to as possible");
        System.out.println("Have fun!");


        money = Casino.playersCash;  // User starts with $100.

        while (true)
        {
            System.out.println("You have " + money + " dollars.");
            do
            {
                System.out.println("How much money do you want to bet?  (Enter 0 to end.)");
                System.out.println();
                bet = scanner.nextInt();

                if (bet < 0 || bet > money)
                {
                    System.out.println("Your answer must be between 0 and " + money + '.');
                }
            } while (bet < 0 || bet > money);
            if (bet == 0)
            {
                System.out.println("EXITING BLACK JACK");

                break;
            }
            userWins = playBlackJack();
            if (userWins)
            {
                money = money + bet;
            } else
            {
                money = money - bet;
            }
            System.out.println();
            if (money == 0)
            {
                System.out.println("Looks like you are out of money!");
                System.out.println("The first step to recovery is admitting you have a problem " + Casino.playersName + ". The national problem gambling helpline is 1-800-522-4700.");
                break;
            }
        }
        System.out.println("\nYou leave with $" + money + '.');

        Casino.playersCash = money;

    } // end main()

    private boolean playBlackJack()
    {
        // Let the user play one game of Blackjack.
        // Return true if the user wins, false if the user loses.

        ArrayList<Card> dealerHand = new ArrayList<Card>();   // The dealer's hand.
        ArrayList<Card> userHand = new ArrayList<Card>();     // The user's hand.

        dealerHand.add(poc.dealCard());
        dealerHand.add(poc.dealCard());
        userHand.add(poc.dealCard());
        userHand.add(poc.dealCard());

        /* Check if one of the players has Blackjack (two cards totaling to 21).
        The player with Blackjack wins the game.  Dealer wins ties.
         */

        if (value(dealerHand) == 21)
        {
            System.out.println("Dealer has the following hand:");

            printhand(dealerHand);

            System.out.println(Casino.playersName + "  has the following hand:");

            printhand(userHand);
            System.out.println();
            System.out.println("Dealer has Blackjack. Dealer wins.");
            return false;
        }

        if (value(userHand) == 21)
        {

            System.out.println("Dealer has the following hand:");

            printhand(dealerHand);

            System.out.println(Casino.playersName + " has the following hand:");

            printhand(userHand);
            System.out.println();
            System.out.println("You have Blackjack.  You win.");
            return true;
        }

        /*  If neither player has Blackjack, play the game.  The user gets a chance
        to draw cards (i.e., to "Hit").  The while loop ends when the user
        chooses to "Stand" or when the user goes over 21.
         */

        while (true)
        {
            /* Display user's cards, and let user decide to Hit or Stand. */

            System.out.println("\nYour cards are:");

            printhand(userHand);

            System.out.println("\nDealer is showing the following hand:");
            printhand(dealerHand);
            System.out.print("\nHit (H) or Stand (S)? ");
            char userAction;  // User's response, 'H' or 'S'.
            do
            {
                userAction = Character.toUpperCase(scanner.next().charAt(0));
                if (userAction != 'H' && userAction != 'S')
                {
                    System.out.print("Please respond H or S:  ");
                }
            } while (userAction != 'H' && userAction != 'S');

            /* If the user Hits, the user gets a card.  If the user Stands, the
            dealer gets a chance to draw and the game ends.
             */

            if (userAction == 'S')
            {
                // Loop ends; user is done taking cards.
                break;
            } else
            {  // userAction is 'H'.
                // Give the user a card.  If the user goes over 21, the user loses.
                Card newCard = poc.dealCard();
                userHand.add(newCard);
                System.out.println("\n" + Casino.playersName + " hits.");

                if (value(userHand) > 21)
                {
                    printhand(userHand);
                    System.out.println("\nYou busted by going over 21.  You lose.");

                    System.out.println("\nDealer's hand was as follows:");

                    printhand(dealerHand);
                    return false;
                }
            }

        } // end while loop

        /* If we get to this point, the user has Stood with 21 or less.  Now, it's
        the dealer's chance to draw.  Dealer draws cards until the dealer's total is > 16.
         */

        System.out.println();
        System.out.println(Casino.playersName + "  stands.");
        System.out.println("Dealer's cards are");

        printhand(dealerHand);

        while (value(dealerHand) <= 16 || ((value(userHand) <= 21)) && (value(userHand) > value(dealerHand)))
        {
            Card newCard = poc.dealCard();

            dealerHand.add(newCard);

            System.out.println("Dealer hits and now has the following hand");

            printhand(dealerHand);
        }

        /* Now, the winner can be declared. */

        System.out.println();
        if (value(dealerHand) > 21)
        {
            System.out.println("Dealer busted by going over 21.  You win.");
            return true;
        } else
        {
            if (value(dealerHand) == value(userHand))
            {
                System.out.println("Dealer wins on a tie.  You lose.");
                return false;
            } else
            {
                if (value(dealerHand) > value(userHand))
                {
                    System.out.println("Dealer wins, " + value(dealerHand) + " points to " + value(userHand) + ".");
                    return false;
                } else
                {
                    System.out.println("You win, " + value(userHand) + " points to " + value(dealerHand) + ".");
                    return true;
                }
            }
        }

    }  // end playBlackjack()

    public int value(ArrayList<Card> hand)
    {
        // Returns the value of this hand for the
        // game of Blackjack.

        int cardVal;  // The blackjack value of the i-th card.

        int val = 0;      // The value computed for the hand.
        int acecounter = 0;
        int cards = hand.size();    // Number of cards in the hand.

        for (int i = 0; i < cards; i++)
        {
            cardVal = hand.get(i).getValue().ordinal() + 1;  // The normal value, 1 to 13.
            if (cardVal == 1)
            {
                acecounter++;
            }else if (cardVal > 10){
                val += 10;
            }else{
                val += cardVal;
            }
        }

        for(int i = 0; i < acecounter; i++){
            if(val + 11 + (acecounter - (i+1)) <= 21){
                val+= 11;
            }else{
                val+= (acecounter - i);
                return val;
            }
        }

        return val;
    }
}
