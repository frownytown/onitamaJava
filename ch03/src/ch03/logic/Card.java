package ch03.logic;
import java.util.*;

public class Card {

    // Hashmap that all cards inherit where their movement data is stored
    HashMap<String, ArrayList<Integer>> moves = new HashMap<>();

    // function for helping to get the move list for the appropriate player
    public ArrayList cardMovesList (String playerNumber){
        return this.moves.get(playerNumber);
    }



    public static ArrayList<Card> allCards = new ArrayList<>();

    public static Card tiger;
    public static Card dog;
//    public static Card dragon;
//    public static Card frog;
    public static Card rabbit;
//    public static Card crab;
//    public static Card elephant;
//    public static Card goose;
//    public static Card rooster;
    public static Card monkey;
//    public static Card mantis;
//    public static Card horse;
//    public static Card ox;
//    public static Card crane;
//    public static Card boar;
    public static Card eel;
//    public static Card cobra;




}
