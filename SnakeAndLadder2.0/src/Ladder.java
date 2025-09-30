public class Ladder implements Cell{
    int startPos;
    int endPos;
    Ladder(int x, int y){
        startPos = x;
        endPos = y;
    }

    @Override
    public int move() {
        return endPos;
    }
}
