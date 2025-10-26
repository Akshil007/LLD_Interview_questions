package Example.Model;

public class ConsumerRecord {
    Message msg;
    int offset;

    public ConsumerRecord(Message msg, int offset) {
        this.msg = msg;
        this.offset = offset;
    }

    public Message getMsg() {
        return msg;
    }

    public int getOffset() {
        return offset;
    }
}
