package Model;

import Sub.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

public class Topic {
    int id;
    String name;
    List<Subscriber> subscriberList;
    ExecutorService broadcastExecutor;

    public Topic(String name, ExecutorService executorService){
        id = UUID.randomUUID().hashCode();
        this.name = name;
        subscriberList = new ArrayList<>();
        broadcastExecutor = executorService;
    }

    public void addSubscriber(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void broadcast(Message msg){
        for(Subscriber subscriber: subscriberList){
            broadcastExecutor.submit(() ->
                    subscriber.onReceivingMsg(msg)
            );

        }
    }



}
