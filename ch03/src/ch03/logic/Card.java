package ch03.logic;
import java.util.*;

public class Card {

    // Name of card / Movement logic?
    private String name;
    private int[][] moves;
    public int owner;
    //private int color;

//    public static ArrayList<Card> allCards = new ArrayList<>();
//
//    public static Card tiger;
//    public static Card dragon;
//    public static Card frog;
//    public static Card rabbit;
//    public static Card crab;
//    public static Card elephant;
//    public static Card goose;
//    public static Card rooster;
//    public static Card monkey;
//    public static Card mantis;
//    public static Card horse;
//    public static Card ox;
//    public static Card crane;
//    public static Card boar;
//    public static Card eel;
//    public static Card cobra;





//    public Card(int[][] moves, String name, int owner) {
//        tiger    = new Card(new int[][]{{0,2},  {0,-1}}                 ,
//                "Tiger", 3);
//        dragon   = new Card(new int[][]{{-2,1}, {-1,-1}, {1,-1}, {2,1}} ,
//                "Dragon", 3);
//        frog     = new Card(new int[][]{{-2,0}, {-1,1},  {1,-1}}        ,
//                "Frog", 3);
//        rabbit   = new Card(new int[][]{{1,1},  {-1,-1}, {2,0}}         ,
//                "Rabbit", 3);
//        crab     = new Card(new int[][]{{2,0},  {-2,0},  {0,1}}         ,
//                "Crab", 3);
//        elephant = new Card(new int[][]{{1,0},  {-1,0},  {1,1},  {-1,1}},
//                "Elephant", 3);
//        goose    = new Card(new int[][]{{-1,1}, {1,-1},  {-1,0}, {1,0}} ,
//                "Goose", 3);
//        rooster  = new Card(new int[][]{{-1,-1},{1,1},   {-1,0}, {1,0}} ,
//                "Rooster", 3);
//        monkey   = new Card(new int[][]{{1,1},  {-1,-1}, {1,-1}, {-1,1}},
//                "Monkey", 3);
//        mantis   = new Card(new int[][]{{0,-1}, {-1,1},  {1,1}}         ,
//                "Mantis", 3);
//        horse    = new Card(new int[][]{{-1,0}, {0,1},   {0,-1}}        ,
//                "Horse", 3);
//        ox       = new Card(new int[][]{{1,0},  {0,1},   {0,-1}}        ,
//                "Ox", 3);
//        crane    = new Card(new int[][]{{-1,-1},{1,-1},  {0,1}}         ,
//                "Crane", 3);
//        boar     = new Card(new int[][]{{-1,0}, {1,0},   {0,1}}         ,
//                "Boar", 3);
//        eel      = new Card(new int[][]{{-1,1}, {-1,-1}, {1,0}}         ,
//                "Eel", 3);
//        cobra    = new Card(new int[][]{{1,1},  {1,-1},  {-1,0}}        ,
//                "Cobra", 3);
//    }

    public String toString() {
        return name;
    }

}
