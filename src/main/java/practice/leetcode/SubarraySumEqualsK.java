package practice.leetcode;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(subarraySum(nums, 3));
    }

    public static int subarraySum(int[] nums, int target) {
        //int j = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            int sum = nums[j];
            if (sum == target) {
                count++;
            }
            for (int i = j + 1; i < nums.length; i++) {
                sum = sum + nums[i];
                if (sum > target) {
                    break;
                } else if (sum == target) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
