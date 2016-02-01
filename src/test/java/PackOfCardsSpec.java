import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by wscown on 1/29/16.
 */
/*public class PackOfCardsSpec {

    @Test
    public void testPackOfCardsConstructor() {
        int hearts = 0, diamonds = 0, clubs = 0, spades = 0;
        Card sample;

        //With
        PackOfCards poc = new PackOfCards();
        ArrayList<Card> sampleDeck = poc.getDeck();

        //Then
        assertEquals("52 cards should have been created but this has not occured.", 52, poc.getSize());

        for (int i = 0; i < 52; i++) {
            sample = poc.dealCard();

            if (sample.getSuit() == Suit.CLUBS) {
                clubs++;
            } else if (sample.getSuit() == Suit.SPADES) {
                spades++;
            } else if (sample.getSuit() == Suit.DIAMONDS) {
                diamonds++;
            } else if (sample.getSuit() == Suit.HEARTS) {
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

<<<<<<< HEAD
    @Test
    public void testShuffle(){
=======
    //@Test
    public void testShuffle() {

>>>>>>> fcd664bd2a91b264a2f408c5133713bc5d60c8e3
        int hearts = 0, diamonds = 0, clubs = 0, spades = 0;
        Card sample;

        //With
        PackOfCards poc =  new PackOfCards();

        //When
        poc.shuffle();

        ArrayList<Card> sampleDeck = poc.getDeck();

        //Then
        assertEquals("52 cards were shuffled. There should still be 52 cards in the deck.", 52, poc.getSize());
<<<<<<< HEAD

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

=======
>>>>>>> fcd664bd2a91b264a2f408c5133713bc5d60c8e3

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
    public void testdealCardreturntoDeck(){
        //With
        PackOfCards poc =  new PackOfCards();

        for(int i = 0; i < 52; i++){
            assertEquals("Card object was not dealt on request", poc.dealCard().getClass(), new Card().getClass());
        }

        assertEquals("52 cards should have been dealt with the dealCard method. The pack should now be empty but this has not occured.", 0, poc.getSize());
        assertEquals("52 cards should have been dealt with the dealCard method. The pack should now be empty and null returned when the dealCard method is called.", null, poc.dealCard());

        for(int i = 0; i < 52; i++){
            poc.returntoDeck(new Card());
        }

        assertEquals("52 cards were added to an empty deck. The pack should now contain 52 cards.", 52, poc.getSize());
    }*/

