public class Board {
    public Cell[] board;
    int size;

    Board(int n){
//        System.out.println(n);
        size = n+1;
//        System.out.println(size);
        board = new Cell[size];
//        System.out.println(board.length);
        initialize();
    }

    public void initialize(){
        for(int i=0;i<size;i++){
            board[i] = new NormalCell();
        }
    }

    public void addLadder(int start, int end){
        if(start < end) // can add more validation between 0 to n
        {
            board[start] = new Ladder(start, end);
        } else {
            throw new RuntimeException("unsupporetd operation");
        }
    }

    public void addSnake(int start, int end){
        if(start > end) // can add more validation between 0 to n
        {
            board[start] = new Snake(start, end);
        } else {
            throw new RuntimeException("unsupporetd operation");
        }
    }

    public Cell getCell(int pos){
        return board[pos];
    }
}
