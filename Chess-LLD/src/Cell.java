public class Cell {
    int row;
    int col;
    Piece Piece;

    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        Piece = piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Piece getPiece() {
        return Piece;
    }

    public void setPiece(Piece piece) {
        Piece = piece;
    }
}
