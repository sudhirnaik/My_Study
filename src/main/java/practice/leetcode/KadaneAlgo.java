package practice.leetcode;

/*
Largest Sum Contiguous Subarray (Kadane’s Algorithm)
Last Updated : 22 May, 2024
Given an array arr[] of size N. The task is to find the sum of the contiguous subarray within a arr[] with the largest sum.
 */
public class KadaneAlgo {
    public static void main(String[] args) {
        Integer[] arr = {-2,-3,4,-1,-2,1,5,-3} ; // output Output: 7
        //Explanation: The subarray {4,-1, -2, 1, 5} has the largest sum 7.

        System.out.println(largestSumContigous(arr));
    }

    public static int largestSumContigous(Integer[] arr) {
        int MaxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i =0 ; i<arr.length; i++) {
            currSum = Math.max(currSum+arr[i], arr[i]);
            if (MaxSum < currSum) {
                MaxSum = currSum;
            }
        }
        return MaxSum;
    }

}
