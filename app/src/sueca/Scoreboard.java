package sueca;

public class Scoreboard{
    private int blueScore;
    private int redScore;

    public Scoreboard(){
        this.blueScore = 0;
        this.redScore = 0;
    }

    public void printScoreboard() {
        System.out.println("Scoreboard:");
        System.out.println("Blue: " + tallyMarks(this.blueScore));
        System.out.println("Red:  " + tallyMarks(this.redScore));
    }

    public void changeScore(int newBlueScore, int newRedScore){
        this.blueScore += newBlueScore;
        this.redScore += newRedScore;
    }

    public String tallyMarks(int score) {
        StringBuilder tally = new StringBuilder();
        int groups= score / 4;          // Calculate how many groups of 4 we have
        int remaining = score % 4;      // Calculate the remaining

        for (int i = 0; i < groups; i++) {
            tally.append("|||| ");
        }

        for (int i = 0; i < remaining; i++) {
            tally.append("|");
        }

        return tally.toString();
    }

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.changeScore(5,4);
        scoreboard.printScoreboard();
    }
}
