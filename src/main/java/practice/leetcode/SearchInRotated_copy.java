package practice.leetcode;

/*
Input: nums = [4,5,6,7,0,1,2], target = 2
Output: 4
 */
public class SearchInRotated_copy {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchRotated(nums, 5));
        //System.out.println(findRoatateInx(nums));
    }

    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right -left)/2;
            if (target == nums[mid]) {
                return mid;
            }
            // left is soretec
            if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (target > nums[mid] && target<= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    static int findRoatateInx(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[left] && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else {
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return 0;
    }


}
