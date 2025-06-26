package practice.Arrays;

import sun.reflect.generics.tree.ClassSignature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Given an array of positive integers A and a positive integer K, return the minimal length of a Subarray whose sum is greater than or equal to the target. If there is no such subarray, return 0 instead.

Example 1:
Input:
target = 7
nums = [2,3,1,2,4,3]
Output:
2
Explanation:
The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,2,4,3};
        int target = 7;
        System.out.println(minSubArray(arr, target));
    }

    public static List<Integer> minSubArray(int[] arr, int target) {
        int left = 0;
        int right = 1;
        Integer leftInx = 0;
        Integer rightInx = 0;
        int sum = arr[left];
        int minSize = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        if (sum >= target) {
            res.add(arr[left]);
            return res;
        }

        while (left <= right && right < arr.length) {
            sum = sum+arr[right];
            if (sum >= target){
                if (minSize>right-left+1) {
                    leftInx = left;
                    rightInx = right;
                }
                sum = sum-arr[left]-arr[right];
                left = left+1;
            } else {
                right++;
            }
        }
        for (int i = leftInx; i <=rightInx; i++) {
        res.add(arr[i]);
        }

        return res;
    }
}
