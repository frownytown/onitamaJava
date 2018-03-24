package ch03.logic;


import java.util.ArrayList;

// This class is for setting up the player hands as well as
// getting player turns and passing the neutral player card to replace the
// card that the player used for their turn
public class GameManager {

    private String player_1_color = "WHITE";
    private String player_2_color = "BLACK";
    private String player_3_color = "NEUTRAL";
    private ArrayList<Card> playerCardsDefault = new ArrayList<Card>();

    // instantiate player objects
    Player playerOne = new Player(player_1_color, playerCardsDefault);
    Player playerTwo = new Player(player_2_color, playerCardsDefault);
    Player playerThree = new Player(player_3_color, playerCardsDefault);

    // give players cards
    private void CreateHands() {
        playerOne.GiveCard(new RabbitCard());
        playerOne.GiveCard(new TigerCard());
        playerTwo.GiveCard(new EelCard());
        playerTwo.GiveCard(new MonkeyCard());
        playerThree.GiveCard(new DogCard());
    }
}
