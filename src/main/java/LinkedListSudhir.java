import practice.ListNode;

public class LinkedListSudhir {
    public LinkedListSudhir()  {
        length = 0;
    }

    //Length of the linked List
    private int length = 0;
    // This the only field of the class. It hold the head of the list
    public ListNode head;

    // Return the first node of the list
    public synchronized ListNode getHead(){
        return head;
    }

    // insert the node at the begin
    public synchronized void insertAtBegin (ListNode node) {
        node.setNext(head);
        head = node;
        length++;
    }

    // insert at the end
    public synchronized void insertAtEnd (ListNode node ) {
        ListNode currNode = head;
        ListNode temp;
        if (length > 0) {
            for (int i=0; i<=length-1; i++){
                if (currNode.getNext() == null) {
                    currNode.setNext(node);
                    length++;
                } else {
                    currNode = currNode.getNext();
                }
            }
        }else {
            head = node;
        }
    }
}
