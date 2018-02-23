package ch03.logic;

public class MoveValidator {

    // Function for checking if the specified move is valid
    // return true if valid, false if not
    public boolean isMoveValid(int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
        sourcePiece = chessGame.getNonCapturedPieceAtLocation(sourceRow, sourceColumn);
        targetPiece = this.chessGame.getNonCapturedPieceAtLocation(targetRow, targetColumn);

        // source piece correct color
        if(sourcePiece.getColor() == Piece.COLOR_WHITE && this.chessGame.getGameState()
                == ChessGame.GAME_STATE_WHITE) {
            //ok
        }
        else if(sourcePiece.getColor() == Piece.COLOR_BLACK && this.chessGame.getGameState()
                == ChessGame.GAME_STATE_BLACK) {
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

    }
}
