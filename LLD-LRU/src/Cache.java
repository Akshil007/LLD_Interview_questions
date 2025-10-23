import Model.DoublyLinkedList;
import Model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
    int MAX_CAP;
    Map<K, ListNode> map;
    DoublyLinkedList doublyLinkedList;

    Cache(int capacity){
        map = new HashMap<>();
        MAX_CAP = capacity;
        doublyLinkedList = DoublyLinkedList.getInstance();
    }

    void put(K key, V val){
        if(map.containsKey(key)){
            ListNode listNode = map.get(key);
            listNode.updateVal(val);
            doublyLinkedList.delete(listNode);
            doublyLinkedList.addAfterHead(listNode);
        } else {
            if(map.size() == MAX_CAP){
                doublyLinkedList.delete(doublyLinkedList.getTail().getPrev());
            }
            ListNode listNode = new ListNode(key, val);
            map.put(key, listNode);
            doublyLinkedList.addAfterHead(listNode);
        }
    }

    V get(K key){
        if(!map.containsKey(key))
            return null;
        return (V)map.get(key).getVal();
    }

}
