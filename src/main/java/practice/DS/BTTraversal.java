package practice.DS;

import java.util.*;

public class BTTraversal {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

/*       1
       /  \
      2     5
     /  \    \
     3   4    6*/

        System.out.println(depthFirst(node1));
        //System.out.println(depthFirstRec(node1));
        //System.out.println(breadthFirst(node1));
        //System.out.println(treeContainsRec(node1, 10));
        //System.out.println(treeContains(node1 ,5));
        //System.out.println(treeSum(node1));
        //printLeaves(node1);
      }











    /*public static void printLeaves(BinaryTreeNode head) {
        if (head==null){
            return;
        }

        if (head.left==null && head.right==null) {
            System.out.print(head.data+", ");
            return;
        }
        if (head.left!=null){
            printLeaves(head.left);
        }
        if (head.right!=null) {
            printLeaves(head.right);
        }
    }*/

      // output 1,2,3,4,5,6
    public static List<Integer> depthFirst(BinaryTreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head==null) return result;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.pop();
            result.add(curr.data);
            if (curr.right !=null) stack.push(curr.right);
            if (curr.left !=null) stack.push(curr.left);
        }
        return result;
    }

    public static List<Integer> depthFirstRec(BinaryTreeNode head) {
        if (head == null) return new ArrayList<>();
        List<Integer> leftVal = depthFirstRec(head.left);
        List<Integer> rightVal  = depthFirstRec(head.right);
        List<Integer> result = new ArrayList<>();
        result.add(head.data);
        result.addAll(leftVal);
        result.addAll(rightVal);
        return result;
    }

    // output 1,2,5,3,4,6
    public static List<Integer> breadthFirst (BinaryTreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head==null) return result;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            result.add(curr.data);
            if (curr.left != null ) q.add(curr.left);
            if (curr.right != null ) q.add(curr.right);
        }
        return result;
    }

    public static boolean treeContainsRec(BinaryTreeNode head, Integer target) {
        if (head == null) return false;
        if (head.data == target) return true;

        return (treeContainsRec(head.left, target) || treeContainsRec(head.right, target));
    }

    public static boolean treeContains(BinaryTreeNode head, Integer target) {
        if (head == null) return false;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(head);
        while(!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            if(curr.data == target) {
                return true;
            } else {
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

        }
        return false;
    }

    public static Integer treeSum(BinaryTreeNode head) {
        if (head == null) return 0;
        Integer leftSum = treeSum(head.left);
        Integer rightSum = treeSum(head.right);
        return head.data+leftSum+rightSum;
    }
}
