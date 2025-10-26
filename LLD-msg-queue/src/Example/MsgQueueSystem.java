package Example;

import Example.Model.Message;
import Example.Model.Topic;

public class MsgQueueSystem {
    TopicManager topicManager;
    private static MsgQueueSystem instance;

    private MsgQueueSystem(){
        topicManager = new TopicManager();
    }

    public static MsgQueueSystem getInstance(){
        if(instance == null){
            synchronized (MsgQueueSystem.class){
                if(instance == null){
                    instance = new MsgQueueSystem();
                }
            }
        }
        return instance;
    }

    public Topic createTopic(String topicName){
        return topicManager.createTopic(topicName);
    }

    public Topic getTopic(String topicName){
        return topicManager.getTopic(topicName);
    }

    public void publishMessage(String topicName, Message message){
        Topic topic = topicManager.getTopic(topicName);
        topic.publishMsg(message);
    }

}
