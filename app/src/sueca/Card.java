package sueca;


public class Card{
    private char suit;
    private char rank;
    private int points;
    

    public Card(String cardName){
        this.rank = cardName.charAt(0);
        this.suit = cardName.charAt(1);
        this.points = cardPoints(this.rank);
    }

    public char getSuit(){
        return this.suit;
    }

    public char getRank(){
        return this.rank;
    }

    public int getcardPoints(){
        return this.points;
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

}
