package Example.Model;

import Example.Observer.TopicObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Topic {
    String topicName;
    List<Message> q;
    List<TopicObserver> observers;
    Map<String, Integer> consumerToOffSetMap;
    ReentrantLock lock = new ReentrantLock();
    ExecutorService notifyExecutor = Executors.newCachedThreadPool();

    public Topic(String topicName) {
        this.topicName = topicName;
        q = new ArrayList<>();
        observers = new ArrayList<>();
        consumerToOffSetMap = new ConcurrentHashMap<>();
    }

    public synchronized boolean publishMsg(Message message){
        lock.lock();
        try {
            q.add(message);
        } finally {
            lock.unlock();
        }

        notifyObservers();
        return true;
    }

    public boolean isNextMsgAvailable(String consumerId){
        int offset = consumerToOffSetMap.getOrDefault(consumerId, -1);
        offset++;
        if(offset < q.size()){
            return true;
        }
        return false;
    }

    public  Optional<ConsumerRecord> getMsg(String consumerId){
        lock.lock();
        try {
            int offset = consumerToOffSetMap.getOrDefault(consumerId, -1);
            offset++;
            if (offset < q.size()) {
                return Optional.of(new ConsumerRecord(q.get(offset), offset));
            } else {
                return Optional.empty();
            }
        } finally {
            lock.unlock();
        }
    }

    public void ack(String consumerId, int lastProcessed){
        consumerToOffSetMap.put(consumerId, lastProcessed);
    }

    public void subscribe(TopicObserver observer){
        observers.add(observer);
    }

    public void unSubscribe(TopicObserver observer){
        observers.remove(observer);
    }

    void notifyObservers(){
        for (TopicObserver observer: observers){
            notifyExecutor.submit(() -> {
                observer.notifyForNewMessage();
            });
        }
    }

    public String getTopicName() {
        return topicName;
    }
}
