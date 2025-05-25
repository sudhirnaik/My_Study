package practice.DS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackNew {

    public static void main(String[] args) {
        Stack<String> test =new Stack<>();
        test.push("Sudhir");
        test.push("naik");

        /*
        * Naik
        * SUdhir
        * */
        System.out.println(test);
        System.out.println(test.peek());
        reverseStack(test);
        System.out.println(test);
        System.out.println(test.peek());
    }

    /*public static void reverseStack(Stack<String> stack) {
        Queue<String> q = new LinkedList<>();
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        while(!q.isEmpty()){
            stack.add(q.remove());
        }
    }*/

    public static void reverseStack(Stack<String> stack) {
        if (stack.isEmpty()) {
            return;
        }
        String elem = stack.pop();
        reverseStack(stack);
        insertToBottom(stack, elem);
    }

    private static void insertToBottom(Stack<String> stack, String elem) {
       if (stack.isEmpty()) {
           stack.add(elem);
           return;
       }
       String existing = stack.pop();
       insertToBottom(stack, elem);
       stack.add(existing);
    }


}
