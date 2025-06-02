package practice.Recurssion;

import practice.Timpass.Bird;

import java.math.BigDecimal;
import java.util.List;

public class Recurssionnew {
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
        //System.out.println(sumOfNumbers(3));
        //System.out.println(nCr(5,3));
        //System.out.println(isPalindrome("cc"));
        System.out.println(countOfString("babdab","ab"));

    }
    static int sumOfNumbers(int n) {
        if (n == 1) {
            return 1;
        }
        return sumOfNumbers(n-1)+n;
    }

    static boolean isPalindrome(String str) {
        if (str.length()<=1) return true;
        if (str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindrome(str.substring(1, str.length()-1));
        }else {
            return false;
        }
    }

    static BigDecimal nCr(int n, int r) {
        if (n==r) return new BigDecimal(1);
        BigDecimal a = new BigDecimal(n);
        BigDecimal b = new BigDecimal(n-r);
        BigDecimal multiply =  a.divide(b, 10, BigDecimal.ROUND_HALF_UP);
        return multiply.multiply(nCr(n-1, r));
    }

    //Count of string in givrn string
    static int countOfString(String main, String child) {
        if (main.length()<child.length()) return 0;
        if (main.substring(0, child.length()).equals(child)) {
            return 1+countOfString(main.substring(1),child);
        } else {
            return countOfString(main.substring(1),child);
        }
    }







}
