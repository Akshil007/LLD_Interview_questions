public class Snake implements Cell{
    int startPos;
    int endPos;
    Snake(int x, int y){
        startPos = x;
        endPos = y;

    }
    @Override
    public int move() {
        return endPos;
    }
}
