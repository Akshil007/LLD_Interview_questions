import java.util.Map;

public class Snake extends Component{

    private Snake(int startingPosition, int endingPosition) {
        super(startingPosition, endingPosition);
    }

    @Override
    void display(Player p) {
        System.out.println("player " + p.getName() +" got snake!");
    }

    public static Snake getInstance (int startingPosition, int endingPosition){
        if(startingPosition < endingPosition) {
            System.out.println("This can not be added");
            return null;
        }
       return new Snake(startingPosition, endingPosition);
    }

}
