import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by wscown on 1/29/16.
 */
public class PackOfCardsSpec {

    @Test
    public void testPackOfCardsConstructor(){
        int hearts = 0, diamonds = 0, clubs = 0, spades = 0;
        Card sample;

        //With
        PackOfCards poc =  new PackOfCards();
        ArrayList<Card> sampleDeck = poc.getDeck();

        //Then
        assertEquals("52 cards should have been created but this has not occured.", 52, poc.getSize());

        for(int i = 0; i < 52; i++){
            sample = poc.dealCard();

            if(sample.getSuit() == Suit.CLUBS){
                clubs++;
            }else if(sample.getSuit() == Suit.SPADES){
                spades++;
            }else if(sample.getSuit() == Suit.DIAMONDS){
                diamonds++;
            }else if(sample.getSuit() == Suit.HEARTS){
                hearts++;
            }
        }

        //Then
        assertEquals("52 cards should have been dealt with the dealCard method. The pack should now be empty but this has not occured.", 0, poc.getSize());
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, hearts);
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, clubs);
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, diamonds);
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, spades);
    }

    @Test
    public void testShuffle(){
        int hearts = 0, diamonds = 0, clubs = 0, spades = 0;
        Card sample;

        //With
        PackOfCards poc =  new PackOfCards();

        //When
        poc.shuffle();

        ArrayList<Card> sampleDeck = poc.getDeck();

        //Then
        assertEquals("52 cards were shuffled. There should still be 52 cards in the deck.", 52, poc.getSize());

        for(int i = 0; i < 52; i++){
            sample = poc.dealCard();

            if(sample.getSuit() == Suit.CLUBS){
                clubs++;
            }else if(sample.getSuit() == Suit.SPADES){
                spades++;
            }else if(sample.getSuit() == Suit.DIAMONDS){
                diamonds++;
            }else if(sample.getSuit() == Suit.HEARTS){
                hearts++;
            }
        }

        //Then
        assertEquals("52 cards should have been dealt with the dealCard method. The pack should now be empty but this has not occured.", 0, poc.getSize());
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, hearts);
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, clubs);
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, diamonds);
        assertEquals("Hearts have been counted out of the deck and should equal 13 cards but this was not achieved.", 13, spades);
    }

}
/*

public class PackOfCards {


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
} */