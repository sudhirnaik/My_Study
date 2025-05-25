package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Recussion {


    public static void main(String[] args) {

        //String testStr = "bqmamqb";
        /*Palindrome pr = new Palindrome();*/
        //System.out.println(isPalidrome(testStr));
        //System.out.println(isPalindromeRecurssive(testStr));
       // System.out.println(sumNaturalNum(10));

        //List<Integer> intList = Arrays.asList(1,2,3,4,5);

        //System.out.println(countOccurance("abbbabccdab", "ab"));

        // find all subsets... eg: abc = '',a,b,c,ab,ac,bc,abc
        // for string of size n 2^n subset possible
        // abc  -> 3
        // i =0      ''
        //          /    \
        //         a        ''
        // i= 1   / \      /   \
        //       ab   a    b   ''
        // i=2   /\   /\   /\   /\
        //    abc ab ac a bc b c  ''
        // edge case when last i
        findSubstrings("abc");



        //Reverse linkedList
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        ListNode.printList(n1);
        ListNode.printList(reverseLinkedList(n1));*/

        //printNaturalNums(4);

    }

    public Recussion(){

    }

    public static void findSubstrings(String str) {
       findSubstringsHelper(str,"",0);

    }

    public static void findSubstringsHelper(String str, String curr, int i) {
        if (i == str.length()) {
            System.out.print(curr);
            System.out.print(",");
            return;
        }
        findSubstringsHelper(str, curr+str.charAt(i), i+1);
        findSubstringsHelper(str, curr, i+1);
    }

    // sprint out number
    public static void printNaturalNums(Integer n) {
        if (n>0) {
            System.out.println(n);
            printNaturalNums(n-1);
            System.out.println(n);
        }
    }

    public static int countOccurance(String text, String word) {
        //You can code here
        return countOccuranceHelper(text, word, 0);
    }

    public static int countOccuranceHelper(String text, String word, int i) {
        if (i > text.length()-word.length()) {
            return 0;
        }

        int subCnt = countOccuranceHelper(text, word, i+1);
        if (text.substring(i, i+word.length()).equals(word)){
            return subCnt+1;
        } else {
            return subCnt;
        }
    }



    public static boolean isPalidrome(String str) {
        char[] charArray = str.toCharArray();
        for (int i =0; i < str.length()/2; i++) {
            if (charArray[i] != charArray[str.length()-1]){
                return false;
            }
        }
        return true;

    }

    public static boolean isPalindromeRecurssive (String str) {
        if (str.length() <=1 ){
            return true;
        }
        else {
            if (str.charAt(0) == str.charAt(str.length()-1)) {
                return isPalindromeRecurssive(str.substring(1, str.length()-1));
            } else {
                return false;
            }
        }
    }



    //Sum of natural numbers
    public static int sumNaturalNum(int n){
        if (n == 1 ){
            return n;
        }
        else {
            return n+sumNaturalNum(n-1);
        }
    }

    /*=================Reverse linked list========*/

    private static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.getNext() == null) return head;
        ListNode p = reverseLinkedList(head.getNext());
        //p is 5 which will be the head that needs to be returned
        // 1->2->3->4->5 during first return the node is 4 now we are changing its next such that it becomes cyclic
        // head.next.next = head;
        head.getNext().setNext(head);
        //remove the connection between 4->5
        // head. next = null
        head.setNext(null);
        return p;
    }


   // ============ merge sorted list
    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }else if (list2 == null){
            return list1;
        }

        if (list1.getData() < list2.getData()) {
            list1.setNext(mergeTwoList(list1.getNext(), list2));
            return list1;
        } else {
            list2.setNext(mergeTwoList(list1, list2.getNext()));
            return list2;
        }
    }


}
