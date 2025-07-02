import java.util.Map;

public class Ladder extends Component{

    public Ladder(int startingPosition, int endingPosition) {
        super(startingPosition, endingPosition);
    }

    @Override
    void display(Player p) {
        System.out.println("player " + p.getName() +" got Ladder!");
    }

    public static Ladder getInstance (int startingPosition, int endingPosition){
        if(startingPosition > endingPosition) {
            System.out.println("This can not be added");
            return null;
        }
        return new Ladder(startingPosition, endingPosition);
    }
}
