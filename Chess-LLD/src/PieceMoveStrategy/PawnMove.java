package PieceMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class PawnMove implements MoveStrategy{
    @Override
    public List<int[]> move(int[] currPos) {
        List<int[]> allPossibleMoves = new ArrayList<>();
        for(int i=1;i<=2;i++){
            allPossibleMoves.add(new int[]{currPos[0]+i,currPos[1]});
        }
        return allPossibleMoves;
    }
}
