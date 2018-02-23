package ch03.logic;
import java.util.ArrayList;

public class Card {

    // Name of card / Movement logic?
    private String name;
    private int[][] moves;
    //private int color;

    public static ArrayList<Card> allCards = new ArrayList<>();

    public static Card tiger;
    public static Card dragon;
    public static Card frog;
    public static Card rabbit;
    public static Card crab;
    public static Card elephant;
    public static Card goose;
    public static Card rooster;
    public static Card monkey;
    public static Card mantis;
    public static Card horse;
    public static Card ox;
    public static Card crane;
    public static Card boar;
    public static Card eel;
    public static Card cobra;

    public Card(int[][] moves, String name) {
        tiger    = new Card(new int[][]{{0,2},  {0,-1}}                 ,"Tiger");
        dragon   = new Card(new int[][]{{-2,1}, {-1,-1}, {1,-1}, {2,1}} ,"Dragon");
        frog     = new Card(new int[][]{{-2,0}, {-1,1},  {1,-1}}        ,"Frog");
        rabbit   = new Card(new int[][]{{1,1},  {-1,-1}, {2,0}}         ,"Rabbit");
        crab     = new Card(new int[][]{{2,0},  {-2,0},  {0,1}}         ,"Crab");
        elephant = new Card(new int[][]{{1,0},  {-1,0},  {1,1},  {-1,1}},"Elephant");
        goose    = new Card(new int[][]{{-1,1}, {1,-1},  {-1,0}, {1,0}} ,"Goose");
        rooster  = new Card(new int[][]{{-1,-1},{1,1},   {-1,0}, {1,0}} ,"Rooster");
        monkey   = new Card(new int[][]{{1,1},  {-1,-1}, {1,-1}, {-1,1}},"Monkey");
        mantis   = new Card(new int[][]{{0,-1}, {-1,1},  {1,1}}         ,"Mantis");
        horse    = new Card(new int[][]{{-1,0}, {0,1},   {0,-1}}        ,"Horse");
        ox       = new Card(new int[][]{{1,0},  {0,1},   {0,-1}}        ,"Ox");
        crane    = new Card(new int[][]{{-1,-1},{1,-1},  {0,1}}         ,"Crane");
        boar     = new Card(new int[][]{{-1,0}, {1,0},   {0,1}}         ,"Boar");
        eel      = new Card(new int[][]{{-1,1}, {-1,-1}, {1,0}}         ,"Eel");
        cobra    = new Card(new int[][]{{1,1},  {1,-1},  {-1,0}}        ,"Cobra");
    }

    public String toString() {
        return name;
    }

}
