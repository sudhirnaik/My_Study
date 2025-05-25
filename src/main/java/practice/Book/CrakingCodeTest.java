package practice.Book;

import practice.ListNode;

import java.util.LinkedList;

public class CrakingCodeTest {
    public static void main(String[] args) {
        //int[][] matrix = new int[3][3];
        /*int[][] matrix = {{1,2,3},
                {4,5,6},
                {7,8,9}};


        traverse2d(matrix);
        traverse2d(rotateMatrix(matrix));*/
        //System.out.println(stringCompress("abc"));
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        ListNode.printList(n1);
        ListNode.printList(copyLinkedList(n1));
        ListNode.printList(n1);

        ListNode.printList(reverseLinkedList(n1));
        //ListNode.printList(n1);

    }

    //Is linked list a palindrome
    // palidrome if the reverse is the same
    /*public static boolean isLLPalindrome(ListNode node) {
        ListNode dup = copyLinkedList(node);
        ListNode rev = reverseLinkedList(dup);
        for ()
    }*/
    /*=================Reverse linked list========*/

    private static ListNode reverseLinkedList(ListNode head) {
        if (head.getNext() == null ){
            return head;
        }

        ListNode result = reverseLinkedList(head.getNext());
        ListNode nxt= head.getNext();
        nxt.setNext(head);
        head.setNext(null);

        return result;
    }

    public static ListNode copyLinkedList(ListNode head) {
        ListNode prev= null;
        ListNode res = null;
        while (head !=null) {
            ListNode node = new ListNode(head.getData());
            head = head.getNext();
            if (prev == null) {
                res = node;
            }
            if (prev != null) {
                prev.setNext(node);
                prev = node;
            } else {
                prev = node;
            }


        }
        return res;
    }

    public static void traverse2d (int[][] matrix){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            str.append("[");
            for (int j = 0; j < matrix[0].length ; j++) {
                str.append(matrix[i][j] + ",");
            }
            str.append("]" + "\n");
        }
        System.out.println(str.toString());
    }

    public static String stringCompress(String str) {
        StringBuilder compResult = new StringBuilder();
        int compCount = 0;
        for (int i=0; i<str.length(); i++) {
            compCount++;
            if (i+1 > str.length()-1 || str.charAt(i) != str.charAt(i+1)) {
                compResult.append(String.valueOf(str.charAt(i)) + compCount);
                compCount = 0;
            }
        }
        if (compResult.toString().length() < str.length()){
            return compResult.toString();
        }else{
            return str;
        }
    }

    //rotate a NXN matrix by 90
    //[1, 2, 3]         [7, 4, 1]
    //[4, 5, 6]   =>    [8, 5, 2]
    //[7, 8, 9]         [9, 6, 3]
    //===>  0,0 => 0,2
    //      0,1 => 1,2
    //      0,2 => 2,2

    //==>   1,0 => 0,1
    //      1,1 => 1,1
    //      1,2 => 2,1

    //==>   2,0 => 0,0
    //      2,1 => 1,0
    //      2,2 => 2,0
    public static int[][] rotateMatrix (int[][] matrix) {
        // first transpose and then chante the column values
        if (matrix.length ==0 || matrix.length != matrix[0].length) {
            System.out.println("error");
            int[][] result= new int[0][0];
            return result;
        }
        for (int i=0; i < matrix.length; i++) {
            for (int j = i+1; j< matrix.length; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =temp;
            }
        }
        // movethe columns around
        for (int i=0; i < matrix.length/2; i++){
            for (int j = 0; j< matrix.length; j++ ){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i] = temp;
            }
        }

        return matrix;

    }
}
