package ch03.logic;

import java.util.ArrayList;
import java.util.HashMap;

public class MonkeyCard extends Card {
    public HashMap<String, ArrayList<Integer>> Monkey_player = new HashMap<>();
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
        Monkey_player.put("Player_1", monkey_player_move_1);
        // add values to player two list
        monkey_player_move_2.add(new int[]{-1,-1});
        monkey_player_move_2.add(new int[]{1,1});
        monkey_player_move_2.add(new int[]{-1,1});
        monkey_player_move_1.add(new int[]{1,-1});
        // add values to player two HashMap ("key", value(list))
        Monkey_player.put("Player_2", monkey_player_move_2);
    }
}
