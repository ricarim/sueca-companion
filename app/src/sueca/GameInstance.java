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
    private int[] score;
    private boolean[] cards;

    public RunPythonScript runPythonScript = new RunPythonScript();

    public GameInstance(Player[] players){
        this.players = players;
        this.trump = null;
        this.score = new int[2];
        this.cards = new boolean[40];

    }

    /*
     * TIP: If you have 5 cards detected and one of them is the initial trump, then ignore the trump.
     *
     */


    /*
     * TODO: 
     *      Trumps rules.
     *      Detect multiple cards at once.
     *
     */

    public int[] match(){
        int firstPlayer = 0;
        String[] cardDetected = runPythonScript.getCardDetected();
        this.trump = new Card(cardDetected[0],firstPlayer);
        this.players[firstPlayer].addCard(trump);
        this.cards[Integer.parseInt(cardDetected[1])] = true;


        for(int round=0; round <10; round++){
            hand();
        }

        int winnerTeam = winnerTeam();
        int[] winner = {winnerTeam, winnerPoints(winnerTeam)};
  
        return winner;
    }


    public void hand(){
        Card bestCard = null;
        int count = 0;
        char suit = '\0';

        for(int i=1; i<5; i++){
            String[] cardDetected;
            Card card;

            while(true){
                cardDetected = runPythonScript.getCardDetected();
                card = new Card(cardDetected[0],i-1);

                if(!this.cards[Integer.parseInt(cardDetected[1])]) break;
                System.out.println("ATTENTION: "+ card.getRank()+""+card.getSuit() + " already played!"); 
            }

            this.players[i%4].addCard(card);
            this.cards[Integer.parseInt(cardDetected[1])] = true;
            count += card.getCardPoints();

            if(bestCard == null) {
                bestCard = card;
                suit = card.getSuit();
            }
            else if(card.getCardOrderRank() >= bestCard.getCardOrderRank() && card.getSuit() == suit) {
                bestCard = card;
            }
        }

        //System.out.println(bestCard.getRank()+""+bestCard.getSuit() + " "+ players[bestCard.getPlayerId()].getName());
        if(players[bestCard.getPlayerId()].getTeam() == "blue") 
            this.score[0] += count;
        else if(players[bestCard.getPlayerId()].getTeam() == "red")
            this.score[1] += count;
    }

    public int winnerTeam(){
        if(this.score[0] > this.score[1]){
            return 0;
        }else if(this.score[1] > this.score[0]){
            return 1;
        }else return 2; // no one wins -> draw

    }

    public int winnerPoints(int winner){
        if(winner==2) return 0; // draw

        winner = this.score[winner];
        if(winner > 90){
            return 2;
        }else if(winner == 120){
            return 4;
        }else return 1;

    }

    public static void main(String[] args){
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
