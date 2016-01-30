/**
 * Created by wscown on 1/29/16.
 */
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerSpec extends Player{


    @Test

    public void testPlayerAttributes(){
        Player testPlayer1 = new Player("Josie", 9);
        assertEquals("Testing return attributes for Player.", "Josie", 9);
    }

    @Test

    public void testPrintHand(){
        Player testPlayer2 = new Player();
        assertEquals("Testing printing the hand", 2);
    }


}
