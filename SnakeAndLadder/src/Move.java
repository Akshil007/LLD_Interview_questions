public class Move {
    void move(Player p, int steps){
        System.out.println("Player " + p.getName() + " moved " + steps + " steps");
        System.out.println("Position: "+ p.currentPosition +" -> " + (p.currentPosition + steps));
        p.updatePosition(p.getCurrentPosition() + steps);
    }
     void move(Player p, Component c){
        c.display(p);
         System.out.println("Position: "+ p.currentPosition +" -> " + c.getEndingPosition());
        p.updatePosition(c.getEndingPosition());
     }
}
