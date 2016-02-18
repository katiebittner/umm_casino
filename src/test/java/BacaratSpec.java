import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by wscown on 1/29/16.
 */
public class BacaratSpec {
    @Test
    public void valueTest() {
        Bacarat testBacarat = new Bacarat("test");
        ArrayList<Card> testHand = new ArrayList<Card>();
        Card aceOfSpades = new Card(Suit.SPADES, Value.ACE);
        Card eightOfSpades = new Card(Suit.SPADES, Value.EIGHT);
        testHand.add(aceOfSpades);
        testHand.add(eightOfSpades);

        int actual = testBacarat.value(testHand);
        int expected = 9;
        assertEquals("Asserting that the value of the test hand is equal to 9", expected, actual);

        ArrayList<Card> testHand2 = new ArrayList<Card>();
        Card tenOfSpades = new Card(Suit.SPADES, Value.TEN);
        Card twoOfSpades = new Card(Suit.SPADES, Value.TWO);
        testHand2.add(tenOfSpades);
        testHand2.add(twoOfSpades);

        int actual2 = testBacarat.value(testHand2);
        int expected2 = 2;
        assertEquals("Asserting that the value of the test hand is equal to 2", expected2, actual2);

    }

}


