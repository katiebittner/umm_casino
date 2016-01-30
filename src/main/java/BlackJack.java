import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends PackOfCards{

    private static Scanner scanner = new Scanner(System.in);
    private int[] deck;   // An array of 52 Cards, representing the deck.
    private int currentPosition; // Current position in the deck
    private ArrayList hand;   // The cards in the hand.

    public static void main(String[] args)
    {
        new BlackJack().run();
    }

    public void run()
    {



        int money;          // Amount of money the user has.
        int bet;            // Amount user bets on a game.
        boolean userWins;   // Did the user win the game?

        System.out.println("Welcome to the game of blackjack.");
        System.out.println();
        System.out.println("The objective of the game is to get to 21 or as close to as possible");
        System.out.println("Have fun!");


        money = 100;  // User starts with $100.

        while (true)
        {
            System.out.println("You have " + money + " dollars to start.");
            do
            {
                System.out.println("How much money do you want to bet?  (Enter 0 to end.)");
                System.out.print("? ");
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
                Casino casino = new Casino();
                  casino.options();
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
                System.out.println("Looks like you've are out of money!");
                break;
            }
        }

        System.out.println();
        System.out.println("You leave with $" + money + '.');

    } // end main()

    private boolean playBlackJack()
    {
        // Let the user play one game of Blackjack.
        // Return true if the user wins, false if the user loses.

        ArrayList dealerHand;   // The dealer's hand.
        ArrayList userHand;     // The user's hand.

        // Create an unshuffled deck of cards.
        deck = new int[52];
        int cardCt = 0; // How many cards have been created so far.
        for (int suit = 0; suit <= 3; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                deck[cardCt] = value;
                cardCt++;
            }
        }
        currentPosition = 0;

        dealerHand = new ArrayList();
        userHand = new ArrayList();

        /*  Shuffle the deck, then deal two cards to each player. */

        shuffle();

        dealerHand.add(dealCard());
        dealerHand.add(dealCard());
        userHand.add(dealCard());
        userHand.add(dealCard());

        System.out.println();
        System.out.println();

        /* Check if one of the players has Blackjack (two cards totaling to 21).
        The player with Blackjack wins the game.  Dealer wins ties.
         */

        if (value(dealerHand) == 21)
        {
            System.out.println("Dealer has the " + showCard(getCard(dealerHand, 0)) + " and the " + showCard(getCard(dealerHand, 1)) + ".");
            System.out.println("User has the " + showCard(getCard(userHand, 0)) + " and the " + showCard(getCard(userHand, 1)) + ".");
            System.out.println();
            System.out.println("Dealer has Blackjack.  Dealer wins.");
            return false;
        }

        if (value(userHand) == 21)
        {
            System.out.println("Dealer has the " + showCard(getCard(dealerHand, 0)) + " and the " + showCard(getCard(dealerHand, 1)) + ".");
            System.out.println("User has the " + showCard(getCard(userHand, 0)) + " and the " + showCard(getCard(userHand, 1)) + ".");
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

            System.out.println();
            System.out.println();
            System.out.println("Your cards are:");
            for (int i = 0; i < userHand.size(); i++)
            {
                System.out.println("    " + showCard(getCard(userHand, i)));
            }
            System.out.println("Your total is " + value(userHand));
            System.out.println();
            System.out.println("Dealer is showing the " + showCard(getCard(dealerHand, 0)));
            System.out.println();
            System.out.print("Hit (H) or Stand (S)? ");
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
                int newCard = dealCard();
                userHand.add(newCard);
                System.out.println();
                System.out.println("User hits.");
                System.out.println("Your card is the " + showCard(newCard));
                System.out.println("Your total is now " + value(userHand));
                if (value(userHand) > 21)
                {
                    System.out.println();
                    System.out.println("You busted by going over 21.  You lose.");
                    System.out.println("Dealer's other card was the " + showCard(getCard(dealerHand, 1)));
                    return false;
                }
            }

        } // end while loop

        /* If we get to this point, the user has Stood with 21 or less.  Now, it's
        the dealer's chance to draw.  Dealer draws cards until the dealer's total is > 16.
         */

        System.out.println();
        System.out.println("User stands.");
        System.out.println("Dealer's cards are");
        System.out.println("    " + showCard(getCard(dealerHand, 0)));
        System.out.println("    " + showCard(getCard(dealerHand, 1)));
        while (value(dealerHand) <= 16)
        {
            int newCard = dealCard();
            System.out.println("Dealer hits and gets the " + showCard(newCard));
            dealerHand.add(newCard);
        }
        System.out.println("Dealer's total is " + value(dealerHand));

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

    public int value(ArrayList hand)
    {
        // Returns the value of this hand for the
        // game of Blackjack.

        int val;      // The value computed for the hand.
        boolean ace;  // This will be set to true if the
        //   hand contains an ace.
        int cards;    // Number of cards in the hand.

        val = 0;
        ace = false;
        cards = hand.size();

        for (int i = 0; i < cards; i++)
        {
            // Add the value of the i-th card in the hand.
            int card;    // The i-th card;
            int cardVal;  // The blackjack value of the i-th card.
            card = getCard(hand, i);
            cardVal = getCardValue(card);  // The normal value, 1 to 13.
            if (cardVal > 10)
            {
                cardVal = 10;   // For a Jack, Queen, or King.
            }
            if (cardVal == 1)
            {
                ace = true;     // There is at least one ace.
            }
            val = val + cardVal;
        }

        // Now, val is the value of the hand, counting any ace as 1.
        // If there is an ace, and if changing its value from 1 to
        // 11 would leave the score less than or equal to 21,
        // then do so by adding the extra 10 points to val.

        if (ace == true && val + 10 <= 21)
        {
            val = val + 10;
        }

        return val;

    }





    public int getCard(ArrayList hand, int position)
    {
        // Get the card from the hand in given position, where positions
        // are numbered starting from 0.  If the specified position is
        // not the position number of a card in the hand, then null
        // is returned.
        if (position >= 0 && position < hand.size())
        {
            return ((Integer)hand.get(position)).intValue();
        } else
        {
            return 0;
        }
    }




    public void shuffle()
    {
        // Put all the used cards back into the deck, and shuffle it into
        // a random order.
        for (int i = 51; i > 0; i--)
        {
            int rand = (int) (Math.random() * (i + 1));
            int temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        currentPosition = 0;
    }





    public int dealCard()
    {
        // Deals one card from the deck and returns it.
        if (currentPosition == 52)
        {
            shuffle();
        }
        currentPosition++;
        return deck[currentPosition - 1];
    }




    public int getCardValue(int card)
    {
        int result = card;
        switch (card)
        {
            case 11:
            case 12:
            case 13:
                result =  10;
        }
        return result;
    }



    public String showCard(int card)
    {
        switch (card)
        {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "??";
        }
    }

}