import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Game {
    Board board;
    Deque<Player> playerQ;
    Dice dice;
    private static Game game;


    private Game(){}

    public static Game getInstance(int playerSize, int boardSize, int maxDice){
        if(game == null) {
            game = new Game();
            game.initialize(playerSize, boardSize, maxDice);
        }
        return game;
    }

    public void initialize(int playerSize, int boardSize, int maxDice){
        System.out.println("Initializing boardsize "+ boardSize);

        playerQ = new ArrayDeque<>();
        for(int i=0;i<playerSize;i++){
            playerQ.add(new Player("p"+Integer.toString(i)));
        }

        board = new Board(boardSize);
        System.out.println(board.board.length);


        board.addLadder(2, 20);
        board.addLadder(21, 99);
        board.addSnake(98, 1);

        dice = new Dice(maxDice);
    }

    public void play(){
        boolean gameOver = false;

        while(!gameOver){
            Player player = playerQ.poll();

            System.out.println("Turn of: " + player.name + " currPos:" + player.currPos);

            int move = dice.getRandom();
            System.out.println("dice got: " + move);

            int latestPos = player.currPos + move;
            player.currPos = Math.min(latestPos, board.size);

            System.out.println("player move to: "+ player.currPos);

            boolean isPlayerWon = playerWon(player);
            if(isPlayerWon) {
                System.out.println(player.name + " won!!!");
                gameOver = true;
                continue;
            }


            Cell latestCell = board.getCell(player.currPos);


            if(latestCell instanceof Ladder){
                System.out.println(player.name +" got ladder!! to pos:" + ((Ladder) latestCell).endPos);
                player.currPos = ((Ladder) latestCell).endPos;
            } else if (latestCell instanceof Snake){
                System.out.println(player.name +" got snake!! to pos:" + ((Snake) latestCell).endPos);
                player.currPos = ((Snake) latestCell).endPos;
            }


            playerQ.offer(player);
        }

    }

    private boolean playerWon(Player p){
        if(p.currPos == board.size)
            return true;
        return false;
    }

}
