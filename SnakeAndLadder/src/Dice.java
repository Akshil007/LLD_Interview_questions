public class Dice {
    int maxLimit;

    Dice(int limit){
        maxLimit = limit;
    }

    public int rollDice(){
        int n = (int)(Math.random() * maxLimit);
        System.out.println("Rolling dice got: " + n);
        return n;
    }
}
