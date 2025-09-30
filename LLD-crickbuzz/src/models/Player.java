package models;

public class Player {
    private String name;
    private PlayerType type;
    int runs;
    int wicketsTaken;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
}
