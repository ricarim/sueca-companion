package sueca;

import sueca.GameInstance;
import sueca.Player;
import sueca.Scoreboard;

public class Game{
    private Scoreboard scoreboard;
    private Player[] players= {
        new Player("bob"), 
        new Player("mickey"),
        new Player("joe"),
        new Player("alice")
    };


    public Game(){
        this.scoreboard = new Scoreboard();

        players[0].setTeam("blue");
        players[1].setTeam("red");
        players[2].setTeam("blue");
        players[3].setTeam("red");
    }


    public void startGame(){
        int[] winner = new int[2];

        GameInstance gameInstance = new GameInstance(this.players);
        winner= gameInstance.match();

        if(winner[0] == 0) this.scoreboard.changeScore(winner[1],0);
        if(winner[0] == 1) this.scoreboard.changeScore(0,winner[1]);
        this.scoreboard.printScoreboard();
        

    }

    public static void main(String[] args){
        Game game = new Game();
        game.startGame();
    }
}
