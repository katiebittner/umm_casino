/**
 * Created by wscown on 1/29/16.
 */
import java.util.*;

public class Player {


    public Player() {
    }

    private String name;
    private int score;



    public Player(String playerType, String name, int score) {
        this.name = name;
        this.score = score;
    }

    private ArrayList<Card> hand = new ArrayList<Card>(


    );

    public ArrayList<Card> printHand() {

        if (!hand.isEmpty()) {
            return hand;
        } else {
            return null;
        }
    }

    public void setCard(Card card) {


    }

    public void getCard() {

        if (hand.isEmpty()) {
            System.out.println("You do not have any cards in your hand.");
        } else {

            System.out.println();

        }
    }

    public void resetScore(){
        System.out.println("The score(s) have been reset to 0.");
        hand.clear();
    }
}
