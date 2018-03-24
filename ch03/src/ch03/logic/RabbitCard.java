package ch03.logic;

import java.util.ArrayList;


public class RabbitCard extends Card {

    // HashMap for tiger player one
    public RabbitCard() {
        ArrayList rabbit_player_move_1 = new ArrayList<ArrayList<Integer>>();
        ArrayList rabbit_player_move_2 = new ArrayList<ArrayList<Integer>>();
        // add values to player one List
        rabbit_player_move_1.add(new int[]{1,1});
        rabbit_player_move_1.add(new int[]{-1,-1});
        rabbit_player_move_1.add(new int[]{2,0});
        // add values to player one HashMap ("key", value(list))
        moves.put("Player_1", rabbit_player_move_1);
        // add values to player two list
        rabbit_player_move_2.add(new int[]{-1,-1});
        rabbit_player_move_2.add(new int[]{1,1});
        rabbit_player_move_2.add(new int[]{-2,0});
        // add values to player two HashMap ("key", value(list))
        moves.put("Player_2", rabbit_player_move_2);
    }
}
