package sueca;

import java.util.ArrayList;
import java.util.List;

import sueca.Card;

public class Player{
    private String name;
    private List<Card> cards;
    private String team;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
        this.team = null;
    }

    public String getName(){
        return this.name;
    }

    public List<Card> getCards(){
        return this.cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void setTeam(String team){
        this.team = team;
    }

    public String getTeam(){
        return this.team;
    }

}
