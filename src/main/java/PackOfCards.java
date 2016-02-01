import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wscown on 1/29/16.
 */
public class PackOfCards {

    //Main method used for testing

    public static void main(String[] args) {
        PackOfCards poc = new PackOfCards();

    }

    //Our deck of cards
    private ArrayList<Card> deck;

    //Constructor initialised deck to a full pack of cards
    PackOfCards(){
        deck = new ArrayList<Card>();

        //Makes the full deck of 52 cards
        for(Suit s: Suit.values()){
            for(Value v: Value.values()){
                deck.add(new Card(s, v));
            }
        }
    }

    //Shuffles the deck
    public void shuffle(){

        Random r = new Random();
        int rand;

        for(int i = 0; i < 52; i++){
            rand = r.nextInt(52 - i);
            deck.add(deck.remove(rand));
        }
    }

    //Remove and return card from "top" of deck
    public Card dealCard(){
        return deck.remove(0);
    }

    //Add card from the "base" of the deck and return the size of the current deck
    public int returntoDeck(Card card){
        deck.add(deck.size(), card);

        return deck.size();
    }

    //Prints out the deck to the screen
    public void print(){
        System.out.println(deck.toString());
    }

    //Returns the deck as a String representation
    public String toString(){
        return deck.toString();
    }

    //Return the size of the current deck
    public int getSize(){
        return deck.size();
    }

    //Return arraylist of cards for testing
    public ArrayList<Card> getDeck(){
        return deck;
    }
}
