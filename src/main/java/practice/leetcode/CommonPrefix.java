package practice.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommonPrefix {
    /*public static void main(String[] args) {
        String[] str = {"flower","flow","flight","fln"};
        System.out.println(longestCommonPrefix(str));
    }*/
    public static String longestCommonPrefix(String[] strs) {
        List<String> arr = Arrays.asList(strs);
        StringBuilder result = new StringBuilder();
        Collections.sort(arr);
        String first = arr.get(0);
        String last = arr.get(arr.size()-1);
        for (int i =0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            result.append(first.charAt(i));
        }
        return result.toString();
        /*int index= 0;
        for (int i =0; i < arr.get(0).length()-1; i++) {

        }*/

    }
}
