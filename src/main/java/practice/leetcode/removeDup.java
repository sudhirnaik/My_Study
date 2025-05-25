package practice.leetcode;

import java.util.Arrays;

//Remove Duplicates from Sorted Array
public class removeDup {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        //System.out.println(arr);
        removeDuplicates(arr);
        for (int i =0 ; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

        //System.out.println(Arrays.asList(removeDuplicates(arr)));
        //Arrays.stream(arr).limit(removeDuplicates(arr)).forEach(System.out::println);
    }



   /* public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }*/

    public static int[] removeDuplicates(int[] arr){
        int j = 0;
        for (int i = 1; i<arr.length; i++) {
            if (arr[j] != arr[i]){
                j++;
                arr[j] = arr[i];
            }
        }
        return arr;
    }





}
