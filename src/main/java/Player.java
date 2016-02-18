import java.util.*;

public class Player {


    private String name;
    private int score;


    private void Player(String name, int score) {
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
}