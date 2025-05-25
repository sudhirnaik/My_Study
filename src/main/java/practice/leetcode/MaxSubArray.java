package practice.leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // 4,-1,2,1
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray (int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (maxSoFar < currSum) {
                maxSoFar = currSum;
            }
            if (currSum <= 0) {
                currSum = 0;
            }
        }
        return maxSoFar;
    }
}
