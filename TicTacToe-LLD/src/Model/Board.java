package Model;

public class Board {
    int size;
    Piece[][] playingBoard;

    Board(int size){
        this.size = size;
        playingBoard = new Piece[size][size];
    }

    boolean addPiece(int x, int y, Piece p){
        if(!isValid(x,y) || playingBoard[x][y]!=null){
            System.out.println("wrong coordinates");
            return false;
        }
        playingBoard[x][y] = p;
        return true;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getPlayingBoard() {
        return playingBoard;
    }

    public void setPlayingBoard(Piece[][] playingBoard) {
        this.playingBoard = playingBoard;
    }
}
