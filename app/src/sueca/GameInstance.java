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

    public RunPythonScript runPythonScript = new RunPythonScript();

    public GameInstance(Player[] players){
        this.players = players;
        this.trump = null;
        this.score = new int[2];

    }

    public int[] match(){
        int firstPlayer = 0;
        this.trump = new Card(runPythonScript.getCardDetected(),firstPlayer);
        this.players[firstPlayer].addCard(trump);


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
            Card card = new Card(runPythonScript.getCardDetected(),i-1);

            if(bestCard == null) {
                bestCard = card;
                suit = card.getSuit();
            }
            else if(card.getCardOrderRank() >= bestCard.getCardOrderRank() && card.getSuit() == suit) {
                bestCard = card;
            }
            if(card.equals(trump)) continue;
            this.players[i%4].addCard(card);
            count += card.getCardPoints();
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
