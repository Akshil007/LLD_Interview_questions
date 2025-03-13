package Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    Board b;
    Deque<Player> players;

    public void initialize(){
        b = new Board(3);
        Player p1 = new Player(new Piece0(), "P1");
        Player p2 = new Player(new PieceX(), "P2");

        players = new ArrayDeque<>();
        players.add(p1);
        players.add(p2);
    }

    public void startGame(){
        initialize();
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while(!gameOver) {

            if(printBoard(b)){
                System.out.println("Game is Tie!!");
                break;
            }

            Player p = players.poll();
            System.out.println("Player "+ p.getName() + " turn:");
            System.out.println("Pleas enter coordinate x:");
            int x = sc.nextInt();
            System.out.println("Pleas enter coordinate y:");
            int y = sc.nextInt();

            if(b.addPiece(x,y,p.getPiece())){
                if(isWinner(b, x, y)){
                    printBoard(b);
                    System.out.println("Winner: " + p.getName());
                    gameOver = true;
                }
                players.addLast(p);
            } else {
                players.addFirst(p);
            }

        }
    }



    public boolean isWinner(Board b, int x,int y){
        PieceType pt = b.getPlayingBoard()[x][y].pieceType;
        Piece[][] board = b.getPlayingBoard();
        // check row
        int count = 0;
        for(int i=0;i<b.size;i++){
            if(board[x][i] == null || board[x][i].pieceType != pt){
                break;
            }
            count++;
        }
        if(count == b.size)
            return true;

        // check column
        count = 0;
        for(int i=0;i<b.size;i++){
            if(board[i][y] == null || board[i][y].pieceType != pt){
                break;
            }
            count++;
        }
        if(count == b.size)
            return true;

        // check daigonal
        count = 0;
        for(int i=0;i<b.size;i++){
            if(board[i][i] == null || board[i][i].pieceType != pt){
                break;
            }
            count++;
        }
        if(count == b.size)
            return true;

        // check anti-daigonal
        count = 0;
        for(int i=0;i<b.size;i++){
            if(board[i][b.size - i - 1] == null || board[i][b.size - i - 1].pieceType != pt){
                break;
            }
            count++;
        }
        if(count == b.size)
            return true;

        return false;
    }

    public boolean printBoard(Board b){
        Piece[][] board = b.getPlayingBoard();
        boolean isBoardFull  = true;
        for(int i=0;i<b.size;i++){
            for(int j=0;j<b.size;j++){
                if(board[i][j] == null){
                    isBoardFull = false;
                    System.out.print(" \t|");
                } else{
                    System.out.print(board[i][j].pieceType +"\t|");
                }
            }
            System.out.println();
        }
        return isBoardFull;
    }
}
