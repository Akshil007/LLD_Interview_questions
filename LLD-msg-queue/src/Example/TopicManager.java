package Example;

import Example.Model.Topic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicManager {
    Map<String, Topic> topics;

    public TopicManager() {
        topics = new ConcurrentHashMap<>();
    }

    public Topic createTopic(String topicName){
        if(topics.containsKey(topicName))
            throw new IllegalArgumentException("Topic name already exist");
        Topic topic = new Topic(topicName);
        topics.put(topicName, topic);
        return topic;
    }

    public Topic getTopic(String topicName){
        if(!topics.containsKey(topicName))
            throw new IllegalArgumentException("Topic name doesn't exist");
        return topics.get(topicName);
    }

}
