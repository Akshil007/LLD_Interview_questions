import Example.Model.Consumer;
import Example.Model.Message;
import Example.Model.Topic;
import Example.MsgQueueSystem;

public class Main {
    public static void main(String[] args){
        MsgQueueSystem messageQueue = MsgQueueSystem.getInstance();

        Topic topic1 = messageQueue.createTopic("topic1");
        Topic topic2 = messageQueue.createTopic("topic2");

        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();

        consumer1.subscribeToTopic("topic1");
        consumer2.subscribeToTopic("topic2");

        topic1.publishMsg(new Message("Hello"));
        topic1.publishMsg(new Message("world"));

        consumer1.getMsg();
        consumer2.getMsg();

        topic2.publishMsg(new Message("Hi there"));

        consumer1.getMsg();
        consumer2.getMsg();

        consumer1.getMsg();
    }
}
