package ch03.logic;

import java.util.ArrayList;
import java.util.HashMap;


public class DogCard extends Card {
    public HashMap<String, ArrayList<Integer>> Dog_player = new HashMap<>();
    // HashMap for tiger player one
    public DogCard() {
        ArrayList dog_player_move_1 = new ArrayList<ArrayList<Integer>>();
        ArrayList dog_player_move_2 = new ArrayList<ArrayList<Integer>>();
        // add values to player one List
        dog_player_move_1.add(new int[]{-1,1});
        dog_player_move_1.add(new int[]{-1,0});
        dog_player_move_1.add(new int[]{-1,-1});
        // add values to player one HashMap ("key", value(list))
        Dog_player.put("Player_1", dog_player_move_1);
        // add values to player two list
        dog_player_move_2.add(new int[]{1,-1});
        dog_player_move_2.add(new int[]{1,0});
        dog_player_move_2.add(new int[]{1,1});
        // add values to player two HashMap ("key", value(list))
        Dog_player.put("Player_2", dog_player_move_2);
    }
}
