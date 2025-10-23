import PieceMoveStrategy.MoveFactory;
import PieceMoveStrategy.MoveStrategy;
import Enum.*;

import java.util.List;

public class Piece {
    int row;
    int col;
    PieceType pieceType;
    Color color;
    MoveStrategy moveStrategy;

    public Piece(int initRow, int initCol, Color color, PieceType pieceType1){
        row = initRow;
        col = initCol;
        this.color = color;
        pieceType = pieceType1;
        moveStrategy = MoveFactory.getMove(pieceType1);
    }

    List<int[]> getAllPossibleMoves(int[] currPos){
        return moveStrategy.move(currPos);
    }

    synchronized void changePos(int[] newPos){
        // add validation of possible moves
        row = newPos[0];
        col = newPos[1];
    }



}
