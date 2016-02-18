import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {

    protected Scanner scanner;

    protected PackOfCards poc;

    public void printhand(ArrayList<Card> hand) {

        int size = hand.size();

        char[][] output = hand.get(0).toCharGraphic();

        for (int i = 1; i < size; i++) {
            output = poc.makeArt(output, hand.get(i).toCharGraphic());
        }

        poc.printArt(output);
    }
}
