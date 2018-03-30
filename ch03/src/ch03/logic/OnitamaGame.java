package ch03.logic;

import java.util.ArrayList;
import java.util.List;

public class OnitamaGame {
	
	private int gameState = GAME_STATE_WHITE;
	public static final int GAME_STATE_WHITE = 0;
	public static final int GAME_STATE_BLACK = 1;
	public static final int GAME_STATE_END = 2;
	
	// 0 = bottom, size = top
	private List<Piece> pieces = new ArrayList<Piece>();
	// player hands
    private ArrayList<Card> playerCards_1 = new ArrayList<Card>();
    private ArrayList<Card> playerCards_2 = new ArrayList<Card>();
    private ArrayList<Card> playerCards_3 = new ArrayList<Card>();

	private MoveValidator moveValidator;
	private Player player_1;
	private Player player_2;
	private Player player_3;
	/**
	 * initialize game
	 */
	public OnitamaGame(){

		this.player_1 = new Player("WHITE", playerCards_1);
		this.player_2 = new Player("BLACK", playerCards_2);
		this.player_3 = new Player("NEUTRAL", playerCards_3);
        this.moveValidator = new MoveValidator(this, player_1,
                player_2, player_3);

        // create and place pieces
		// pawn and king
		createAndAddPiece(Piece.COLOR_WHITE, Piece.TYPE_PAWN, Piece.ROW_1, Piece.COLUMN_A);
		createAndAddPiece(Piece.COLOR_WHITE, Piece.TYPE_PAWN, Piece.ROW_1, Piece.COLUMN_B);
		createAndAddPiece(Piece.COLOR_WHITE, Piece.TYPE_KING, Piece.ROW_1, Piece.COLUMN_C);
		createAndAddPiece(Piece.COLOR_WHITE, Piece.TYPE_PAWN, Piece.ROW_1, Piece.COLUMN_D);
		createAndAddPiece(Piece.COLOR_WHITE, Piece.TYPE_PAWN, Piece.ROW_1, Piece.COLUMN_E);

		createAndAddPiece(Piece.COLOR_BLACK, Piece.TYPE_PAWN, Piece.ROW_5, Piece.COLUMN_A);
		createAndAddPiece(Piece.COLOR_BLACK, Piece.TYPE_PAWN, Piece.ROW_5, Piece.COLUMN_B);
		createAndAddPiece(Piece.COLOR_BLACK, Piece.TYPE_KING, Piece.ROW_5, Piece.COLUMN_C);
		createAndAddPiece(Piece.COLOR_BLACK, Piece.TYPE_PAWN, Piece.ROW_5, Piece.COLUMN_D);
		createAndAddPiece(Piece.COLOR_BLACK, Piece.TYPE_PAWN, Piece.ROW_5, Piece.COLUMN_E);

	}

	/**
	 * create piece instance and add it to the internal list of pieces
	 * 
	 * @param color on of Pieces.COLOR_..
	 * @param type on of Pieces.TYPE_..
	 * @param row on of Pieces.ROW_..
	 * @param column on of Pieces.COLUMN_..
	 */
	private void createAndAddPiece(int color, int type, int row, int column) {
		Piece piece = new Piece(color, type, row, column);
		this.pieces.add(piece);
	}

	/**
	 * Move piece to the specified location. If the target location is occupied
	 * by an opponent piece, that piece is marked as 'captured'
	 */
	public boolean movePiece(Move move) {

	    if (!this.moveValidator.isMoveValid(move)) {
	        System.out.println("Invalid");
	        return false;
        }

		Piece piece = getNonCapturedPieceAtLocation(move.sourceRow,
                move.sourceColumn);
		
		//check if the move is capturing an opponent piece
		int opponentColor = (piece.getColor()==Piece.COLOR_BLACK ? Piece
                .COLOR_WHITE: Piece.COLOR_BLACK);
		if( isNonCapturedPieceAtLocation(opponentColor, move.targetRow,
                move.targetColumn)){
			Piece opponentPiece = getNonCapturedPieceAtLocation( move
                    .targetRow, move.targetColumn);
			opponentPiece.isCaptured(true);
		}
		
		piece.setRow(move.targetRow);
		piece.setColumn(move.targetColumn);

		if (isGameEndConditionReached()) {
		    this.gameState = GAME_STATE_END;
        } else {
		    this.changeGameState();
        }

		return true;
	}

	// check to see if the end game condition has been reached
	private boolean isGameEndConditionReached() {
	    for (Piece piece : this.pieces) {
	        if (piece.getType() == Piece.TYPE_KING && piece.isCaptured()){
	            return true;
            }else {
	            // continue iterating
            }
        }
        return false;
    }

	/**
	 * returns the first piece at the specified location that is not marked
	 * as 'captured'.
	 * @param row one of Piece.ROW_..
	 * @param column one of Piece.COLUMN_..
	 * @return the first not captured piece at the specified location
	 */
	public Piece getNonCapturedPieceAtLocation(int row, int column) {
		for (Piece piece : this.pieces) {
			if( piece.getRow() == row
					&& piece.getColumn() == column
					&& piece.isCaptured() == false ){
				return piece;
			}
		}
		return null;
	}

	/**
	 * Checks whether there is a piece at the specified location that is not
	 * marked as 'captured' and has the specified color.
	 * @param color one of Piece.COLOR_..
	 * @param row one of Piece.ROW_..
	 * @param column on of Piece.COLUMN_..
	 * @return true, if the location contains a not-captured piece of the
	 *         specified color
	 */
	private boolean isNonCapturedPieceAtLocation(int color, int row, int column) {
		for (Piece piece : this.pieces) {
			if( piece.getRow() == row
					&& piece.getColumn() == column
					&& !piece.isCaptured()
					&& piece.getColor() == color){
				return true;
			}
		}
		return false;
	}

	public boolean isNonCapturedPieceAtLocation(int row, int column) {
	    for(Piece piece : this.pieces) {
	        if (piece.getRow() == row && piece.getColumn() == column && !piece
                    .isCaptured()) {
	            return true;
            }
        }
        return false;
    }

	/**
	 * @return current game state (one of OnitamaGame.GAME_STATE_..)
	 */
	public int getGameState() {
		return this.gameState;
	}

	/**
	 * @return the internal list of pieces
	 */
	public List<Piece> getPieces() {
		return this.pieces;
	}

	/**
	 * switches the game state from OnitamaGame.GAME_STATE_WHITE to
	 * OnitamaGame.GAME_STATE_BLACK and vice versa.
	 */
	public void changeGameState() {

	    // check to see if the end game condition has been reached
        if (this.isGameEndConditionReached()) {

            if (this.gameState == OnitamaGame.GAME_STATE_BLACK) {
                System.out.println("Game over! Black wins!");
            }else {
                System.out.println("Game over! White wins!");
            }

            this.gameState = OnitamaGame.GAME_STATE_END;
            return;
        }
		switch (this.gameState) {
			case GAME_STATE_BLACK:
				this.gameState = GAME_STATE_WHITE;
				break;
			case GAME_STATE_WHITE:
				this.gameState = GAME_STATE_BLACK;
				break;
			default:
				throw new IllegalStateException("unknown game state:" + this.gameState);
		}
	}

	public MoveValidator getMoveValidator(){
		return this.moveValidator;
	}

}
