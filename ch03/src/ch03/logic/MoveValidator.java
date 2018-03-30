package ch03.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MoveValidator {

    private OnitamaGame onitamaGame;
    private Piece sourcePiece;
    private Piece targetPiece;
    private Player player_1;
    private Player player_2;
    private Player player_3;

    public MoveValidator(OnitamaGame onitamaGame, Player player_1, Player
            player_2, Player player_3){
        this.onitamaGame = onitamaGame;
        this.player_1 = player_1;
        this.player_2 = player_2;
        this.player_3 = player_3;
    }

    // Function for checking if the specified move is valid
    // return true if valid, false if not
    public boolean isMoveValid(Move move) {
        int sourceRow = move.sourceRow;
        int sourceColumn = move.sourceColumn;
        int targetRow = move.targetRow;
        int targetColumn = move.targetColumn;

        sourcePiece = onitamaGame.getNonCapturedPieceAtLocation(sourceRow, sourceColumn);
        targetPiece = this.onitamaGame.getNonCapturedPieceAtLocation(targetRow,
                targetColumn);

        // check if source piece does not exist
        if (sourcePiece == null) {
            System.out.println("There is no source piece");
            return false;
        }

        // source piece correct color
        if (sourcePiece.getColor() == Piece.COLOR_WHITE && this.onitamaGame
                .getGameState()
                == OnitamaGame.GAME_STATE_WHITE) {
            //ok
        } else if (sourcePiece.getColor() == Piece.COLOR_BLACK && this.onitamaGame
                .getGameState()
                == OnitamaGame.GAME_STATE_BLACK) {
            // ok
        } else {
            System.out.println("It's not your turn");
            return false;
        }

        // check if target within bounds of board
        if (targetRow < Piece.ROW_1 || targetRow > Piece.ROW_5 || targetColumn < Piece.COLUMN_A
                || targetColumn > Piece.COLUMN_E) {
            System.out.println("Target row or column out of scope");
            return false;
        }

        // validate game movement rules via the card the player has selected?
        // going to need to call card movement validation here

        boolean validPieceMove = false;
        switch (sourcePiece.getColor()) {
            case Piece.COLOR_WHITE:
                // TODO
                //validPieceMove = isValidCardMove(sourceRow, sourceColumn,
                //        targetRow, targetColumn, player_1, )
        }
        // validation of valid card move()
        return true;
    }
        // checking validity of the space (non card rules)
        // space free // space captureable

    private boolean isTargetLocationCaptureable() {
        if(targetPiece == null){
            return false;
        }
        else if (targetPiece.getColor() != sourcePiece.getColor()){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isTargetLocationFree() {
        return targetPiece == null;
    }
    // function for getting the cardMovesList into smaller pieces
    private int[] individualPair (ArrayList movementArr, int iterator) {
        return (int[])movementArr.get(iterator);
    }
    // function for getting X,y value of pair from individualPair()
    private ArrayList validMoves (int sourceRow, int sourceColumn, ArrayList
            cardMoves){
        ArrayList listOfValidMoves = new ArrayList<ArrayList<Integer>>();

        int j = 0;
        while(cardMoves.size() > j) {
            int[] pair = individualPair(cardMoves,j);
            listOfValidMoves.add(j,sourceRow+ pair[0]);
            listOfValidMoves.add(j+1, sourceColumn +
                    pair[1]);
            j++;
        }
        System.out.println(listOfValidMoves);
        return listOfValidMoves;
    }

    // function for checking the cards the player has and then if the
    // move is valid based on those cards
    private boolean isValidCardMove(int sourceRow, int sourceColumn, int
            targetRow, int targetColumn, Player currentPlayer, String
            playerNumber){
        // use logic to check with both of the cards movement
        // first is target location possible
        if(isTargetLocationFree() ||isTargetLocationCaptureable()){
            // ok
        }else{
            System.out.println("Target location not possible");
            return false;
        }
        // get the cards that the currentPlayer object has in their "hand"
        Card firstCard = currentPlayer.playerCards.get(0);
        Card secondCard = currentPlayer.playerCards.get(1);
        // get the list of movements that each card enable from the two cards
        // in the current player hand
        ArrayList movementArr_1 = firstCard.cardMovesList(playerNumber);
        ArrayList movementArr_2 = secondCard.cardMovesList(playerNumber);
        // create a list for each of the cards that indicates the possible
        // valid movements from the selected source piece
        ArrayList validMovementArr_1 = validMoves(sourceRow, sourceColumn,
                movementArr_1);
        ArrayList validMovementArr_2 = validMoves(sourceRow, sourceColumn,
                movementArr_2);
        // compare the target row and target column to the pairs in the valid
        // movements lists
        if (validMovementArr_1.contains(targetRow) &&
                validMovementArr_1.contains(targetColumn)){
            return true;
        }
        else if(validMovementArr_2.contains(targetRow) &&
                validMovementArr_2.contains(targetColumn)){
            return true;
        }
        else {
            return false;
        }



    }


    }

