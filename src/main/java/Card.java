/**
 * Created by wscown on 1/29/16.
 */

//Enumerated type for all the suits in a deck of cards
enum Suit {HEARTS, DIAMONDS, SPADES, CLUBS;

    //Method to generated
    public static Suit getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}

//Enumerated type for all the values in a suit
enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public static Value getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}

public class Card {
    private Suit suit;
    private Value value;

    //Constructor of Card with the parameters giving the value of the card
    Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    //Constructor of Card without parameters that will give a random card
    Card(){
        this.suit = Suit.getRandom();
        this.value = Value.getRandom();
    }

    public Suit getSuit(){
        return suit;
    }

    public Value getValue(){
        return value;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    public void setValue(Value value){
        this.value = value;
    }

    public String toString(){
        char s = 'a';

        if(suit == Suit.CLUBS){
            s = '\u2663';
        }else if(suit == Suit.SPADES){
            s = '\u2660';
        }else if(suit == Suit.DIAMONDS){
            s = '\u2666';
        }else if(suit == Suit.HEARTS){
            s = '\u2665';
        }

        return s + " " + value;
    }
}