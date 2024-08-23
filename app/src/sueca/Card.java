package sueca;


public class Card{
    private char suit;
    private char rank;
    private int points;
    private int orderRank;
    private int playerId;
    

    public Card(String cardName, int playerId){
        this.rank = cardName.charAt(0);
        this.suit = cardName.charAt(1);
        this.points = cardPoints(this.rank);
        this.orderRank = cardOrderRank(this.rank);
        this.playerId = playerId;
        
    }

    public char getSuit(){
        return this.suit;
    }

    public char getRank(){
        return this.rank;
    }


    public int getPlayerId(){
        return this.playerId;
    }

    public int cardPoints(char rank){
        switch(rank){
            case 'A': return 11; 
            case '7': return 10;
            case 'K': return 4;
            case 'J': return 3;
            case 'Q': return 2;
            default: return 0;
        }
    }

    public int getCardPoints(){
        return this.points;
    }

    public int cardOrderRank(char rank){
        switch(rank){
            case 'A': return 10;
            case '7': return 9;
            case 'K': return 8;
            case 'J': return 7;
            case 'Q': return 6;
            case '6': return 5;
            case '5': return 4;
            case '4': return 3;
            case '3': return 2;
            case '2': return 1;
            default: return 0;
        }
    }

    public int getCardOrderRank(){
        return this.orderRank;
    }

}
