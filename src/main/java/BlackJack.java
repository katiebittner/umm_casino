import java.util.*;

/**
 * Created by wscown on 1/29/16.
 */


public class BlackJack extends Game{


    private int packofCards;

    public static void main(String[] args) {

    }

    PackOfCards blackjackDeck = new PackOfCards();


    public BlackJack(){
        blackjackDeck.getDeck();
        blackjackDeck.shuffle();

    }




    public  String printInstructions(){
        String instruction = ("The object is to draw cards until you reach 21, if you go over you bust.");
        return instruction;
    }

    public void playerList(){

        ArrayList<String>tempPlayers = new ArrayList<String>();
        tempPlayers.add("Player 1");
        tempPlayers.add("Player 2");
        tempPlayers.add("Player 3");
        tempPlayers.add("Player 4");

    }


    public void firstRound(){



    }


    public void dealHand(){



    }





    public void roundRobin() {

        while (true){
            for (int i = 0; i < inOut.length; i++ ) {
                if (!inOut[i]) return false;

                return true;

                for (int j = 0; j < players.size(); j++) {
                    System.out.println("Do you want to draw a card? Press H to get, S to stay");

                    if (userhand < 21) {


                    }
                    if (userHand > 21) {
                        System.out.println("Player" + "busted, you are out");
                        return false;
                    }
                }
            }

        }
    }


    public void declareResults(){

        System.out.println("Player " + " Wins ");
    }



