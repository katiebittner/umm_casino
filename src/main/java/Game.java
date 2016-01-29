import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wscown on 1/29/16.
 */
public class Game {
    ArrayList<String> players = new ArrayList<String>();
    boolean[] inOut = new boolean[players.size()];
    int userScore;
    String player;

    public void addPlayer(String player){

        players.add(player);

    }

    public void removePlayer(String player){

        for ( int i = 0;  i < players.size(); i++){
            String tempName = players.get(i);
            if(tempName.equals(player)) {
                players.remove(i);
            }
    }
    }


    public void printScore(){
        System.out.println(userScore);

    }

    private String getPlayers(){
        return player;

    }

    public static void main(String[] args) {

    }
}





