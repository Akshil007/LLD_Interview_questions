package Model;

public class ListNode<K,V> {
    ListNode next;
    ListNode prev;
    K key;
    V val;

    public ListNode(K k, V v){
        key = k;
        val = v;
    }

    ListNode(){
    }

    public void updateVal(V val){
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public V getVal() {
        return val;
    }

    public K getKey() {
        return key;
    }
}
