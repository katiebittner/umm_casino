import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wscown on 1/29/16.
 */
public class PackOfCards {

    //Main method used for testing

    public static void main(String[] args) {
        PackOfCards poc = new PackOfCards();

<<<<<<< HEAD
=======
        char [][] output = poc.dealCard().toCharGraphic();
        for(int i = 0; i < 4; i++){
            output = poc.makeArt(output, poc.dealCard().toCharGraphic());
        }

        poc.printArt(output);
>>>>>>> fcd664bd2a91b264a2f408c5133713bc5d60c8e3
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

        for(int i = 0; i < deck.size(); i++){
            rand = r.nextInt(deck.size() - i);
            deck.add(deck.remove(rand));
        }
    }

    //Remove and return card from "top" of deck
    public Card dealCard(){
        if(deck.size() != 0) {
            return deck.remove(0);
        }else{
            return null;
        }
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

    //Make ASCI art
    public char[][] makeArt(char[][] original, char[][] append){

        int oRows = original.length;
        int oWidth = original[0].length;
        int aWidth = append[0].length;
        int j;

        char[][] output = new char[original.length][original[0].length + 1 + append[0].length];

        for(int i = 0; i < oRows; i++){
            for(j = 0; j < oWidth; j++){
                output[i][j] = original[i][j];
            }
            output[i][j] = ' ';
            j++;
            for(int k = 0; k < aWidth; k++){
                output[i][j+k] = append[i][k];
            }
        }
        return output;
    }

    //Print ASCI art
    public static void printArt(char[][] cards){
        int rows = cards.length;
        int width = cards[0]. length;
        for(int i = 0; i < rows; i++){
            System.out.println(cards[i]);
        }
    }
}
