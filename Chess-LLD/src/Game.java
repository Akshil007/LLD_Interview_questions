import java.time.Instant;
import java.time.Period;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import Enum.Color;

public class Game {
    Board board;
    Queue<Player> players;
    boolean isGameOver;

    public Game(){
        board = new Board(8);
        players = new ArrayDeque<>();
        players.add(new Player("player1", Color.WHITE));
        players.add(new Player("player2", Color.BLACK));
        isGameOver = false;
    }

    public void start(){
        while (!isGameOver){
            // take turn one by one
            Player currPlayer = players.poll();

            boolean selectMove = false;
            while(!selectMove){
                // take input from user
                int row = 1;
                int col = 1;
                try {
                    Piece peice = board.getPiece(row, col, currPlayer);
                    // get all possible moves
                    List<int[]> allMoves = peice.getAllPossibleMoves(new int[]{row, col});

                    // select a move
                    int index = 0;  // take input: -1 if want to change the choice
                    if(index == -1)
                        continue;
                    int newRow = allMoves.get(index)[0];
                    int newCol = allMoves.get(index)[1];
                    peice.changePos(new int[]{newRow, newCol});
                    selectMove = true;
                } catch (IllegalArgumentException e){
                    continue;
                }

            }


            // check for winner
            isGameOver = gameOver();
            System.out.println(currPlayer.name+" won");
        }
    }

    private boolean gameOver(){
        // check logic of checkmat
        return true;
    }

}
