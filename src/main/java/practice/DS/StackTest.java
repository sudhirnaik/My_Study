package practice.DS;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> intElementSt = new Stack();
        intElementSt.push(2);
        intElementSt.push(1);
        System.out.println(intElementSt);
        System.out.println(intElementSt.peek());




        reverseStack(intElementSt);
        System.out.println(intElementSt);

        Stack<String> strElementSt = new Stack();
        strElementSt.push("Sudhir");
        strElementSt.push("Naik");
        System.out.println(strElementSt);
        System.out.println(strElementSt.peek());
        reverseStack(strElementSt);
        System.out.println(strElementSt);
    }

    public static <T> Stack<T> reverseStack (Stack<T> stack) {
        if (stack.isEmpty()) return null;
        if (stack.size() == 1) {
            return stack;
        }

        T temp = stack.pop();
        insertEtoBottm(reverseStack(stack), temp);
        return stack;
        //stack.push(reverseStack())

    }
    public static <T> void insertEtoBottm (Stack<T> stack , T data) {
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }

        T temp = stack.pop();
        insertEtoBottm(stack, data);
        stack.push(temp);
    }
}
