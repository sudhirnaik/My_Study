package practice.DS;

import javax.sound.midi.Soundbank;
import java.util.*;

public class BSTInsertTraversal {
    public static Stack<BinaryTreeNode> stack = new Stack<>();
    public static void main(String[] args) {
        // insert element into a binary Search tree
        /*
            100
         /      \
        80       108
       /  \         \
      70   90       110
             \
             95

         */
        int [] data = {100, 80, 70, 90, 95, 108, 110};
        BinaryTreeNode res = null;
        for (int i = 0;  i< data.length ; i++) {
            res = insertNode(res, data[i]);
        }
        // show the way of insert
        //depthFirstStack(res);

        /*
        same as above using recurssion
        pre order traversal (data -> left -> right)
        gives insertion order
         */
        //System.out.println(depthFirstRecPreOrder(res));

        /*
        In order traversal (left -> data -> right)
        gives sorted data
        */
        //System.out.println(depthFirstRecInOrder(res));

        /*
        breadth first only done using queue
         */
        //breadthFirst(res);

        /*
        check if target is present in a tree
         */
        //System.out.println(ispresent(res, 101));
        //System.out.println(getMin(res));
        //System.out.println(getMinBreadthFirst(res));
        System.out.println(treeHeight(res));
        //System.out.println(maxRootToLeafSum(res));
        //BTTraversal.printLeaves(res);

    }

    public static int treeHeight (BinaryTreeNode head) {
        if (head ==null) {
            return 0;
        }
        if (head.left == null && head.right==null) {
            return 0;
        }
        int leftHeight = treeHeight(head.left);
        int rightHeight = treeHeight(head.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public static int maxRootToLeafSum (BinaryTreeNode head) {
        if (head == null) {
            return 0;
        }

        int leftSum = maxRootToLeafSum(head.left);
        int righSum = maxRootToLeafSum(head.right);
        return Math.max(leftSum, righSum)+ head.data;
    }

    public static boolean ispresent(BinaryTreeNode head, int target) {
        if (head==null) return false;
        if (head.data == target) {
            return true;
        }
        return (ispresent(head.left, target) || ispresent(head.right, target));
    }

    public static int getMin(BinaryTreeNode head ) {
        if (head == null) return Integer.MAX_VALUE;

        int minleaf = Math.min(getMin(head.left), getMin(head.right));
        return Math.min(head.data, minleaf);
    }

    public static int getMinBreadthFirst(BinaryTreeNode head ) {
       Deque<BinaryTreeNode> queue = new LinkedList<>();
       int result = Integer.MAX_VALUE;
       queue.offer(head);
       while (!queue.isEmpty()) {
           BinaryTreeNode curr = queue.poll();
           if (result>curr.data) {
               result = curr.data;
           }

           if (curr.left!=null) {
               queue.offer(curr.left);
           }
           if (curr.right!=null) {
               queue.offer(curr.right);
           }
       }
       return result;
    }

    public static BinaryTreeNode insertNode(BinaryTreeNode head, int data) {
        if (head == null) {
            BinaryTreeNode node = new BinaryTreeNode(data);
            return node;
        }

        if (head.data > data) {
            head.left = insertNode(head.left, data);
        }
        if (head.data < data) {
            head.right = insertNode(head.right, data);
        }
        return head;
    }

    //traverse in a way that the insert happened
    // node, left, right
    // pre order traversal
    // used for copying the tree
    public static void depthFirstStack(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        stack.push(head);
        while(!stack.isEmpty()) {
            BinaryTreeNode curr = stack.pop();
            System.out.println(curr.data+", ");
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    public static List<Integer> depthFirstRecPreOrder(BinaryTreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        
        List<Integer> leftValues = depthFirstRecPreOrder(head.left);
        List<Integer> rightValues = depthFirstRecPreOrder(head.right);
        List<Integer> res = new ArrayList<>();
        res.add(head.data);
        res.addAll(leftValues);
        res.addAll(rightValues);
        return res;
    }

    // gives the sorted order (left -> data -> right)
    public static List<Integer> depthFirstRecInOrder(BinaryTreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> leftValues = depthFirstRecInOrder(head.left);
        List<Integer> rightValues = depthFirstRecInOrder(head.right);
        List<Integer> res = new ArrayList<>();
        res.addAll(leftValues);
        res.add(head.data);
        res.addAll(rightValues);
        return res;
    }

    // breadth first traversal
    public static void breadthFirst(BinaryTreeNode head) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while(queue.peek() !=null) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.data+", ");
            if (node.left!=null) {
                queue.offer(node.left);
            }
            if (node.right!=null) {
                queue.offer(node.right);
            }
        }

    }


}
