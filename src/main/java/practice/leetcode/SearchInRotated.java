package practice.leetcode;

import com.sun.org.apache.xerces.internal.util.XMLInputSourceAdaptor;
/*
Input: nums = [4,5,6,7,0,1,2], target = 2
Output: 4
 */
public class SearchInRotated {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchRotated(nums, 2));
    }

    public static int searchRotated(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }//left side is sorted
            else if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }// right is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid +1;
                }else {
                    right = mid-1;
                }

            }
        }
        return -1;
    }
}
