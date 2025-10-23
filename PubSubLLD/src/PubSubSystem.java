import Model.Message;
import Model.Topic;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PubSubSystem {
    Map<String, Topic> topicRegistery;
    private static PubSubSystem instance;
    private ExecutorService broadcastExecutor;

    private PubSubSystem(){
        topicRegistery = new ConcurrentHashMap<>();
        broadcastExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubSystem getInstance(){
        if(instance == null){
            instance = new PubSubSystem();
        }
        return instance;
    }

    void createTopic(String name){
        topicRegistery.put(name, new Topic(name, broadcastExecutor));
    }

    public void publish(String topicName, Message msg){
        if(!topicRegistery.containsKey(topicName))
            throw new RuntimeException("Illeagl topic name");

        Topic topic = topicRegistery.get(topicName);

        topic.broadcast(msg);
    }

    Topic getTopic(String name){
        if(topicRegistery.containsKey(name))
            return topicRegistery.get(name);
        throw new RuntimeException("Illelagl topic name");
    }


}
