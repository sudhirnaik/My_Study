package practice.leetcode;

public class LongestSubPalidrome {
    public static int subPalLength = 0;
    public static int subPalStartIndx = 0;

    public static void main(String[] args) {
        String s = "babaddacadd";
        System.out.println(longestPalidrome(s));
    }

    public static String longestPalidrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() -1; i++) {
            isPalidromeSub(s, i, i);
            isPalidromeSub(s, i, i+1);
        }
        return s.substring(subPalStartIndx, subPalStartIndx+subPalLength);
    }

    public static void isPalidromeSub(String s, int startIndx, int endIndx) {
        while (startIndx >=0 && endIndx < s.length()
                && s.charAt(startIndx) == s.charAt(endIndx)) {
            startIndx--;
            endIndx++;
        }

        int tempsubPalLength = (endIndx -1) - (startIndx + 1)  + 1;
        if (tempsubPalLength > subPalLength) {
            subPalLength = tempsubPalLength;
            subPalStartIndx = startIndx +1;
        }

    }
}
