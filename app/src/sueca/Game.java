package sueca;

import sueca.GameInstance;
import sueca.Player;
import sueca.Scoreboard;

public class Game{
    private Scoreboard scoreboard;
    private Player[] players= {
            new Player("ricardo"), 
            new Player("manuel"),
            new Player("teresa"),
            new Player("susana")
        };

    public Game(){
        this.scoreboard = new Scoreboard();
    }

    public String getGameScoreboard(){
        return this.scoreboard.getScoreboard();
    }

    public void startGame(){
        GameInstance gameInstance = new GameInstance(this.players);
        gameInstance.match();

    }
}
