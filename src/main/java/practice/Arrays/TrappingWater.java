package practice.Arrays;
//find the max height from the left for any index
// find thw lm height from the right for any index

import java.util.Arrays;

/// formula : Math.min(left[i], right[i])-arr[i]
public class TrappingWater {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        int[] rightMax = new int[arr.length];
        rightMax[arr.length-1] = arr[arr.length-1];
        for (int i = 1; i<arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
            rightMax[arr.length-1-i] = Math.max(rightMax[arr.length-i], arr[arr.length-1-i]);
        }
        int res = 0;
        for (int i =0 ; i < arr.length; i++) {
            res = res + (Math.min(leftMax[i], rightMax[i])-arr[i]);
        }
        System.out.println(res);
    }
}
