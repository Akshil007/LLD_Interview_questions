import Model.Message;
import Model.Topic;
import Sub.PrintSubscriber;
import Sub.Subscriber;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PubSubSystem pubSubSystem = PubSubSystem.getInstance();
        pubSubSystem.createTopic("topic1");
        pubSubSystem.createTopic("topic2");

        Subscriber sub1 = new PrintSubscriber();
        Topic topic1 = pubSubSystem.getTopic("topic1");
        topic1.addSubscriber(sub1);

        Subscriber sub2 = new PrintSubscriber();
        Topic topic2 = pubSubSystem.getTopic("topic2");
        topic2.addSubscriber(sub2);

        pubSubSystem.publish("topic1", new Message("hello"));
        pubSubSystem.publish("topic2", new Message("world"));


    }
}