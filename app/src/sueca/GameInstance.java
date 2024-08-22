package sueca;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import sueca.Card;
import sueca.Player;
import sueca.RunPythonScript;

public class GameInstance{
    private Player[] players;
    private Card trump; 
    private int score;

    public RunPythonScript runPythonScript = new RunPythonScript();

    public GameInstance(Player[] players){
        this.players = players;

    }

    public int match(){
        trump = new Card(runPythonScript.getCardDetected());
        this.players[0].addCard(trump);


        for(int round=0; round <= 10; round++){
            int handScore = hand();
        }

        return this.score;
    }


    public int hand(){
        int count = 0;
        for(int i=1; i<5; i++){
            Card card = new Card(runPythonScript.getCardDetected());
            if(card.equals(trump)) continue;
            this.players[i%4].addCard(card);
            count += card.getcardPoints();
        }

        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        Player[] players= {
            new Player("bob"), 
            new Player("mickey"),
            new Player("joe"),
            new Player("alice")
        };

        GameInstance gameInstance = new GameInstance(players);
        System.out.println(gameInstance.match());
    }

}
