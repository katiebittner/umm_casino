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

    public char[][] toCharGraphic(){
        char[][] output = new char[5][6];

        output[0][0] = ' ';
        output[0][1] = '-';
        output[0][2] = '-';
        output[0][3] = '-';
        output[0][4] = '-';
        output[0][5] = ' ';

        output[1][0] = '|';
        output[1][1] = ' ';
        output[1][2] = ' ';
        output[1][3] = ' ';
        output[1][4] = ' ';
        output[1][5] = '|';

        output[2][0] = '|';
        output[2][1] = ' ';
        output[2][2] = ' ';
        output[2][3] = ' ';
        output[2][4] = ' ';
        output[2][5] = '|';

        output[3][0] = '|';
        output[3][1] = ' ';
        output[3][2] = ' ';
        output[3][3] = ' ';
        output[3][4] = ' ';
        output[3][5] = '|';

        output[4][0] = ' ';
        output[4][1] = '-';
        output[4][2] = '-';
        output[4][3] = '-';
        output[4][4] = '-';
        output[4][5] = ' ';

        if(suit == Suit.CLUBS){
            output[1][4] = '\u2663';
            output[3][1] = '\u2663';
        }else if(suit == Suit.SPADES){
            output[1][4] = '\u2660';
            output[3][1] = '\u2660';
        }else if(suit == Suit.DIAMONDS){
            output[1][4] = '\u2666';
            output[3][1] = '\u2666';
        }else if(suit == Suit.HEARTS){
            output[1][4] = '\u2665';
            output[3][1] = '\u2665';
        }

        if(value != Value.ACE && value != Value.TEN && value != Value.JACK && value != Value.QUEEN && value != Value.KING){
            output[1][1] = ((Integer)value.ordinal()).toString().charAt(0);
            output[3][4] = ((Integer)value.ordinal()).toString().charAt(0);
        }else if(value == Value.ACE){
            output[1][1] = 'A';
            output[3][4] = 'A';
        }else if(value == Value.JACK){
            output[1][1] = 'J';
            output[3][4] = 'J';
        }else if(value == Value.QUEEN){
            output[1][1] = 'Q';
            output[3][4] = 'Q';
        }else if(value == Value.KING){
            output[1][1] = 'K';
            output[3][4] = 'K';
        }else if(value == Value.TEN){
            output[1][1] = '1';
            output[1][2] = '0';
            output[3][4] = '0';
            output[3][3] = '1';
        }

        return output;
    }
}
