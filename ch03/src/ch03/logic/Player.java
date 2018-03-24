package ch03.logic;



import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerColor;
    // This class will contain the player hand of two cards and the pieces that
    // they "own", as well as an identified for whether or not it is a human or
    // ai player controlling it.
    // initialize player hands in the form of a list that holds 2 cards

    ArrayList<Card> playerCards = new ArrayList<Card>();
    // eventually GameManager.java will handle selecting 2 non repeating
    // cards for each players hand at the beginning of the game but for now
    // we will just hard code the hands.
    public Player(String playerColor, ArrayList<Card> playerCards){
        //nothing for now
        this.playerColor = playerColor;
        this.playerCards = playerCards;
    }
    public void GiveCard(Card c){
        this.playerCards.add(c);
    }



}
