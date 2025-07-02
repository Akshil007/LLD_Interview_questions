import java.util.*;

public class Game {
    Deque<Player> playerList;
    Dice dice;
    Map<Integer, Component> cMap;
    int m,n;
    Move move;
    int total;

    void initialize(){
        m = 10;
        n = 10;
        total = m*n;
        playerList = new ArrayDeque<>();
        cMap = new HashMap<>();
        for(int i=0;i<5;i++){
            playerList.add(new Player("player-"+i, 0));
        }
        addComponent(Ladder.getInstance(2,20));
        addComponent(Ladder.getInstance(12,90));
        addComponent(Ladder.getInstance(30,40));
        addComponent(Ladder.getInstance(20,2));
        addComponent(Snake.getInstance(99,1));
        addComponent(Snake.getInstance(2,1));


        dice = new Dice(12);
        move = new Move();

    }

    void addComponent(Component c){
        if(c == null){
            System.out.println("Got wrong component");
            return;
        }
        cMap.put(c.getStartingPosition(), c);
    }

    void run(){
        boolean gotWinner = false;

        while(!gotWinner) {
            Player p = playerList.poll();

            System.out.println("Turn: " + p.getName());

            int n = dice.rollDice();

            move.move(p, n);

            if(cMap.containsKey(p.getCurrentPosition())) {
                Component c = cMap.get(p.getCurrentPosition());
                move.move(p, c);
            }

            if(p.currentPosition >= (total)){
                System.out.println("Winner: " + p.getName());
                gotWinner = true;
            }

            playerList.offer(p);
        }
    }


}
