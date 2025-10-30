package practice.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main (String[] args){
        System.out.println(AllParenthesis(3));
    }

    public static List<String> AllParenthesis(int n) {
        List<String> res = new ArrayList<>();
        AllParenthesisHelper ("" , res, n, 0 ,0);
        return res;
    }

    public static void AllParenthesisHelper(String curr, List<String> res, int n , int open, int closed) {
        int count = open+closed;
        if (count == 2*n) {
            res.add(curr);
            return;
        }

        if (open < n){
            curr = curr+"(";
            AllParenthesisHelper (curr, res, n, open+1, closed);
            curr = curr.substring(0, curr.length()-1);
        }

        if (closed < open) {
            curr = curr+")";
            AllParenthesisHelper (curr, res, n, open, closed+1);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}
