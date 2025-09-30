package models;

import java.util.List;

public class ScoreBoard {
    Match matchDetails;
    List<Over> pastOver;
    Over currentOver;

//    public void initialize(){
//        for(int i=0;i<5;i++){
//
//        }
//    }
    void updateOver(Ball ball){
        if(currentOver == null){
            currentOver = new Over();
            currentOver.addBall(ball);
        } else {
            currentOver.addBall(ball);
            if(currentOver.getBallList().size() == 6){
                pastOver.add(currentOver);
                currentOver = null;
            }
        }
    }
}
