import practice.ListNode;

public class TestLinkedList {
    public static void main (String[] str) {
        LinkedListSudhir list = new LinkedListSudhir();
        list.insertAtBegin(new ListNode(1));
        list.insertAtBegin(new ListNode(2));
        list.insertAtEnd(new ListNode(3));
        list.insertAtEnd(new ListNode(4));
        list.insertAtEnd(new ListNode(5));
        ListNode.printList(list.getHead());
    }


}
