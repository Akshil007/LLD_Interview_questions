package Example.Model;

import Example.MsgQueueSystem;
import Example.Observer.TopicObserver;

import java.util.Optional;
import java.util.UUID;

public class Consumer implements TopicObserver {
    String id;
    int currentOffset;
    Topic topic;


    public Consumer() {
        this.id = UUID.randomUUID().toString();
        currentOffset = 0;
        this.topic = null;
    }

    public void getMsg(){
        if(topic == null){
            System.out.println("Not subscribed to any topic");
        }
        // If there is no msg to process then lock the consumer un till there is new msg published
        if(!topic.isNextMsgAvailable(id)){
            System.out.println("No msg to read");
            return;
        }

        Optional<ConsumerRecord> record = topic.getMsg(id);
        // process msg
        Message message = record.get().getMsg();
        System.out.println("Consumer-"+id);
        message.printMessage();
        // ack to topic
        currentOffset = record.get().getOffset();
        topic.ack(id, currentOffset);
    }

    public void subscribeToTopic(String topicName){
        if(topic != null){
            topic.unSubscribe(this);
        }
        MsgQueueSystem msgQ = MsgQueueSystem.getInstance();
        Topic topic1 = msgQ.getTopic(topicName);
        topic = topic1;
        topic.subscribe(this);
    }

    @Override
    public void notifyForNewMessage() {
        System.out.println("New msg got published in topic: " + topic.getTopicName() +" for consumer: "+id);
    }
}
