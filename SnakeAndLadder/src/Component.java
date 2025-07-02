import java.util.Map;

public abstract class Component {
    private int startingPosition;
    private int endingPosition;

    protected Component(int startingPosition, int endingPosition) {
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
    }


    abstract void display(Player p);

    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    public int getEndingPosition() {
        return endingPosition;
    }

    public void setEndingPosition(int endingPosition) {
        this.endingPosition = endingPosition;
    }
}
