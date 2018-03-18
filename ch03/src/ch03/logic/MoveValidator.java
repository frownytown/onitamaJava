package ch03.logic;

public class MoveValidator {

    private OnitamaGame onitamaGame;
    private Piece sourcePiece;
    private Piece targetPiece;

    public MoveValidator(OnitamaGame onitamaGame){
        this.onitamaGame = onitamaGame;
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
        if (sourcePiece == null){
            System.out.println("There is no source piece");
            return false;
        }

        // source piece correct color
        if(sourcePiece.getColor() == Piece.COLOR_WHITE && this.onitamaGame
                .getGameState()
                == OnitamaGame.GAME_STATE_WHITE) {
            //ok
        }
        else if(sourcePiece.getColor() == Piece.COLOR_BLACK && this.onitamaGame
                .getGameState()
                == OnitamaGame.GAME_STATE_BLACK) {
            // ok
        }
        else {
            System.out.println("It's not your turn");
            return false;
        }

        // check if target within bounds of board
        if (targetRow < Piece.ROW_1 || targetRow > Piece.ROW_5 || targetColumn < Piece.COLUMN_A
                || targetColumn > Piece.COLUMN_E) {
            System.out.println("Target row or column out of scope");
            return false;
        }

        return true;
    }
}
