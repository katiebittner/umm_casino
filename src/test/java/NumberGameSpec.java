import org.junit.Test;

import static org.junit.Assert.*;

public class NumberGameSpec {

    @Test
    public void highLowTest() {
        NumberGame testNumberGame = new NumberGame("test");
        Card card1 = new Card(Suit.DIAMONDS, Value.ACE);
        Card card2 = new Card(Suit.SPADES, Value.JACK);
        assertTrue("asserting that jack is higher than ace", testNumberGame.isHigher(card1, card2));
        assertFalse("asserting that the jack is not lower than the ace", testNumberGame.isHigher(card2, card1));

        Card card3 = new Card(Suit.SPADES, Value.KING);
        Card card4 = new Card(Suit.DIAMONDS, Value.KING);
        assertTrue("asserting that the two kings are equal", testNumberGame.isEqual(card3, card4));
        assertFalse("asserting that the ace and king are not equal", testNumberGame.isEqual(card1, card3));

    }

}
