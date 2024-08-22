package sueca;

import java.util.ArrayList;
import java.util.List;

import sueca.Card;

public class Player{
    private String name;
    private List<Card> cards;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
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


}
