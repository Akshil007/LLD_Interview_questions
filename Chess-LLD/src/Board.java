import java.util.List;

public class Board {
    Cell[][] Cells;
    int size;
    public Board(int size){
        this.size = size;

        Cells = new Cell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                Cells[i][j] = new Cell(i,j, null);
            }
        }

        initBoard();
    }

    private void initBoard(){
        // init white and black pieces accordingly
    }

    Piece getPiece(int row, int col, Player player){
        if(Cells[row][col].Piece == null)
            throw new IllegalArgumentException("No peice present");
        Piece piece = Cells[row][col].Piece;
        if(!piece.color.equals(player.color)){
            throw new IllegalArgumentException("wrong piece selected");
        }
        return Cells[row][col].getPiece();
    }

    void selectMove(int row, int col, Piece piece){

    }
}
