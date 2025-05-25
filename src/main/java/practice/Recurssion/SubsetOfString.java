package practice.Recurssion;

public class SubsetOfString {
    /*
    Problem Statement
Given a string, write a program to output every non-empty substring of the given string in a Lexographically sorted order.

Note: Here we will not consider an empty string as the subset of a String
Example 1:
Input: s = abc
Output: [a, ab, abc, ac, b, bc, c]
     */
    public static void main(String[] args) {
        // create the subset of String
        fun(new Integer(4));

    }

    static void fun (&Integer n) {
        if (n>0) {
            System.out.println(n);
            fun(n - 1);
        }
    }
}
