import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created by wscown on 1/29/16.
 */
public class BlackJackSpec {
    @Test
    public void valueTest(){
        BlackJack testBlackJack = new BlackJack("test");
        ArrayList<Card> testHand = new ArrayList();
        Card kingOfSpades = new Card(Suit.SPADES, Value.KING);
        Card aceOfSpades = new Card(Suit.SPADES, Value.ACE);
        testHand.add(kingOfSpades);
        testHand.add(aceOfSpades);

        int expected = 21;
        int actual = testBlackJack.value(testHand);
        assertEquals("asserting that the value of this hand is worth 21", expected, actual);

        ArrayList<Card> testHand2 = new ArrayList();
        Card aceOfHearts = new Card(Suit.HEARTS, Value.ACE);
        Card aceOfDiamonds = new Card(Suit.DIAMONDS, Value.ACE);
        Card jackOfSpades = new Card(Suit.SPADES, Value.JACK);
        testHand2.add(aceOfHearts);
        testHand2.add(aceOfDiamonds);
        testHand2.add(jackOfSpades);

        int expected2 = 12;
        int actual2 = testBlackJack.value(testHand2);
        assertEquals("asserting that this handis worth 12", expected2, actual2);

    }


}
