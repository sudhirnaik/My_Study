package practice.DS.New;

import practice.ListNode;

public class LinkedList {

    public LinkedList(){
        length = 0;
    }

    ListNode head;

    private int length = 0;

    // return first node
    public synchronized ListNode getHead(){
        return head;
    }
    // insert at the beginning
    public void insertAtBegin (int data) {
        ListNode newNode = new ListNode(data);
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    //insert at end
    public void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
            length++;
        } else {
            ListNode curr = head;
            while (curr.getNext() !=null) {
                curr = curr.getNext();
            }
            curr.setNext(node);
            length++;
        }
    }


}
