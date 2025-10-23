package PieceMoveStrategy;

import Enum.PieceType;
public class MoveFactory {

    public static MoveStrategy getMove(PieceType pieceType){
        switch (pieceType){
            case PAWN -> {
                return new PawnMove();
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }
}
