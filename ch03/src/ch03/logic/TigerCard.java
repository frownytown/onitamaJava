package ch03.logic;

import java.util.ArrayList;


public class TigerCard extends Card {
    // HashMap for tiger player one
    public TigerCard() {
        ArrayList tiger_player_move_1 = new ArrayList<ArrayList<Integer>>();
        ArrayList tiger_player_move_2 = new ArrayList<ArrayList<Integer>>();
        // add values to player one List
        tiger_player_move_1.add(new int[]{0,2});
        tiger_player_move_1.add(new int[]{0,-1});
        // add values to player one HashMap ("key", value(list))
        moves.put("Player_1", tiger_player_move_1);
        // add values to player two list
        tiger_player_move_2.add(new int[]{0,-2});
        tiger_player_move_2.add(new int[]{0,-1});
        // add values to player two HashMap ("key", value(list))
        moves.put("Player_2", tiger_player_move_2);
    }
}

