package Example;

public class Item {
    private Enum<Soda> type;
    private int code;
    private int price;

    public Item(Enum<Soda> type, int code, int price) {
        this.type = type;
        this.code = code;
        this.price = price;
    }

    public Enum<Soda> getType() {
        return type;
    }

    public void setType(Enum<Soda> type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
