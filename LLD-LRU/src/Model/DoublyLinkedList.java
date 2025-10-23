package Model;

public class DoublyLinkedList {
    ListNode head;
    ListNode tail;

    private static DoublyLinkedList instance;

    private DoublyLinkedList(){
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public static DoublyLinkedList getInstance(){
        if(instance == null){
            instance = new DoublyLinkedList();
        }
        return instance;
    }

    public void delete(ListNode node){
        // delete node from whereever it is
    }

    public void addAfterHead(ListNode node){
        // add node after head
    }

    public ListNode getTail() {
        return tail;
    }

    public void setTail(ListNode tail) {
        this.tail = tail;
    }
}
