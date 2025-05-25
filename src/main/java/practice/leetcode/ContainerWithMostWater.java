package practice.leetcode;
//Container With Most Water
/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

        Find two lines that together with the x-axis form a container, such that the container contains the most water.

        Return the maximum amount of water a container can store.*/
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public static int maxWater(int[] heights){
        int result = 0;
        int left = 0;
        int right = heights.length-1;
        while(left < right) {
            int cuurwater = Math.min(heights[left],heights[right])*(right - left);
            if (result<cuurwater) {
                result = cuurwater;
            }
            if (heights[left] < heights[right]) {
                    left ++;
            }else {
                right--;
            }
        }
        return result;
    }
}
