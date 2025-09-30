public class Dice {
    int max;
    Dice(int n){
        max = n;
    }

    public int getRandom(){
        int number = 0;
        while(number == 0){
            number = (int)(Math.random()*max);
        }
        return number;
    }
}
