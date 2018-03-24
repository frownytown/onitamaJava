package ch03.logic;

import java.util.ArrayList;


public class MonkeyCard extends Card {

    // HashMap for tiger player one
    public MonkeyCard() {
        ArrayList monkey_player_move_1 = new ArrayList<ArrayList<Integer>>();
        ArrayList monkey_player_move_2 = new ArrayList<ArrayList<Integer>>();
        // add values to player one List
        monkey_player_move_1.add(new int[]{1,1});
        monkey_player_move_1.add(new int[]{-1,-1});
        monkey_player_move_1.add(new int[]{1,-1});
        monkey_player_move_1.add(new int[]{-1,1});
        // add values to player one HashMap ("key", value(list))
        moves.put("Player_1", monkey_player_move_1);
        // add values to player two list
        monkey_player_move_2.add(new int[]{-1,-1});
        monkey_player_move_2.add(new int[]{1,1});
        monkey_player_move_2.add(new int[]{-1,1});
        monkey_player_move_1.add(new int[]{1,-1});
        // add values to player two HashMap ("key", value(list))
        moves.put("Player_2", monkey_player_move_2);
    }
}
