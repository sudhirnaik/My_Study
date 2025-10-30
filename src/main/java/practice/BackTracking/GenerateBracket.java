package practice.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBracket {
    public static void main(String[] args) {
        genBrackets(2);
    }

    public static void genBrackets(int n) {
        List<String> res = genBracketsHelper(n, 0 , 0, "", new ArrayList<String>());
        System.out.println(res);
    }

    public static List<String> genBracketsHelper(int n , int open, int closed, String curr, List<String> res) {
        if (open+closed == n*2) {
            res.add(curr);
            return res;
        }

        if (open < n) {
            genBracketsHelper(n, open+1, closed, curr+"(", res);
        }

        if (closed < n && closed < open) {
            genBracketsHelper(n, open, closed+1, curr+")", res);
        }
        return res;
    }


   /* public static List<String> genBracketsHelper(int n, int open, int closed, String curr, List<String>  res) {
        if (closed == n && open == n)  {
            res.add(curr);
            return res;
        }
        if (open<n) {
            genBracketsHelper(n, open + 1, closed, curr + "(", res);
        }
        if (closed<n && closed <open) {
            genBracketsHelper(n , open, closed +1 ,curr+")", res);
        }
        return res;
    }*/
}
