/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent
houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [1,2,3,1]
Output: 4
 */

import org.springframework.util.AutoPopulatingList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test");
        int [] nums = {3,5,4,9,2,7,9};
        int maxMoney = 0;

        System.out.println(maxMoney(nums, 0, maxMoney, 0));
    }

    public static boolean isValidHouse(int i, int j) {
        return j - i >1;
    }

    public static int maxMoney(int[] nums, int currIndx, int maxMoney, int currMoney ) {
        if (nums.length<=2) {
            if (nums.length==1) {
                maxMoney = nums[0];
            } else {
                maxMoney = Math.max(nums[0], nums[1]);
            }
            return maxMoney;
        }
        if (currIndx >= nums.length-2) {
            if (maxMoney < currMoney) {
                maxMoney = currMoney;
            }
            return maxMoney;
        }
        int newIndx = currIndx;
        currMoney = currMoney+nums[currIndx]; // cur 0  cuurMoney 1
        while (newIndx < nums.length-1) {
            newIndx++;// 3
            if (isValidHouse(currIndx, newIndx)) {
                return maxMoney(nums, newIndx, maxMoney, currMoney+nums[newIndx]); // curr 4
            }
        }

        return maxMoney;
    }


    /*public static boolean isRepeatable (String str) {
        char[] charArr = str.toCharArray();
        List<Character> characterList = new ArrayList<>();
        characterList.add(charArr[0]);
        for (int i = 1; i<str.length()/2; i++) {
            characterList.add(charArr[i]);
            if (charArr[i] == charArr[0]) {
                int len = i;

                str.substring(i, i+(i));
                // compare with the character list
            }
        }
    }*/
}
