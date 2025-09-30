package models;

import java.util.List;

public class Over {
    List<Ball> ballList;

    public void setBallList(List<Ball> ballList) {
        this.ballList = ballList;
    }

    public void addBall(Ball b){
        ballList.add(b);
    }

    public List<Ball> getBallList() {
        return ballList;
    }
}
