package practice.leetcode;

import practice.ListNode;

import java.util.List;

public class TwoSum {

    /*You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(9);


        n1.setNext(n2);
        n2.setNext(n3);

        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(9);


        n4.setNext(n5);
        n5.setNext(n6);


        //ListNode res = addTwoNumbers(n1, n4);
        ListNode res = addTwoNumbersRec(n1, n4);
        printLinkedList(res);

    }

    public static ListNode addTwoNumbersRec(ListNode l1, ListNode l2) {
        boolean carry = false;
        return addTwoNumbersRecHelper( l1,  l2, carry);
    }

    public static ListNode addTwoNumbersRecHelper(ListNode l1, ListNode l2, boolean carry) {
        if (l1==null && l2==null) {
            if (carry) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        int sum = ((carry)?1:0);
        if (l1!=null) {
            sum += l1.getData();
        }
        if (l2!=null) {
            sum += l2.getData();
        }
        int digit = sum%10;
        ListNode head = new ListNode(digit);
        head.setNext(addTwoNumbersRecHelper((l1!=null)?l1.getNext():null, (l2!=null)?l2.getNext():null, (sum>=10)? true:false));
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr!=null) {
            System.out.print(curr.getData());
            curr = curr.getNext();
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();

        int firstdegit = l1.getData() + l2.getData();
        int carry = 0;
        if (firstdegit > 10) {
            carry = 1;
        } else {
            carry = 0;
        }
        result.setData(firstdegit%10);
        l1 = l1.getNext();
        l2 = l2.getNext();
        ListNode tail = result;
        while (l1 != null || l2 != null) {
            int tempsum = l1.getData() + l2.getData() + carry;
            if (tempsum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode tempNode = new ListNode(tempsum%10);
            tail.setNext(tempNode);
            tail = tail.getNext();
            l1 = l1.getNext();
            l2 = l2.getNext();


        }
        return result;
    }
}
