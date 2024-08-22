package sueca;

public class Scoreboard{
    private int round;
    private int white;
    private int black;

    public Scoreboard(){

    }

    public String getScoreboard(){
        return this.round + " " + this.white + " " + this.black; 
    }

}
