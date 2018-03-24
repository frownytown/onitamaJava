package ch03.logic;

import java.util.ArrayList;


public class EelCard extends Card {
    // HashMap for tiger player one
    public EelCard() {
        ArrayList eel_player_move_1 = new ArrayList<ArrayList<Integer>>();
        ArrayList eel_player_move_2 = new ArrayList<ArrayList<Integer>>();
        // add values to player one List
        eel_player_move_1.add(new int[]{-1,1});
        eel_player_move_1.add(new int[]{-1,-1});
        eel_player_move_1.add(new int[]{1,0});
        // add values to player one HashMap ("key", value(list))
        moves.put("Player_1", eel_player_move_1);
        // add values to player two list
        eel_player_move_2.add(new int[]{1,-1});
        eel_player_move_2.add(new int[]{1,1});
        eel_player_move_2.add(new int[]{-1,0});
        // add values to player two HashMap ("key", value(list))
        moves.put("Player_2", eel_player_move_2);
    }
}