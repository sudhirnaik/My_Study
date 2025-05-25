package practice;

public class ListNode {
    private int data;
    private ListNode next;

    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    //Traversing a linked list for finding length
    public int ListLength(ListNode headNode) {
        int count = 0;
        ListNode currNode = headNode;
        while (currNode != null) {
            currNode = currNode.getNext();
            count++;
        }
        return count;
    }

    //Traversing a linked list for finding length
    public static int printList(ListNode headNode) {
        int count = 0;
        ListNode currNode = headNode;
        while (currNode != null) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
            count++;
        }
        return count;
    }



}



