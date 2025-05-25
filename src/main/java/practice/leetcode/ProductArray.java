package practice.leetcode;

/*Product of Array Except Self
 */
public class ProductArray {
    public static void main(String[] args) {

    }

    public static int[] productArr(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        suf[n-1] = 1;
        for (int i= 1; i<n; i++) {
            pre[i] = nums[i-1]*pre[i-1];
        }
        for (int k= n-2; k>=0; k--) {
            suf[k] = nums[k+1]*suf[k+1];
        }
        int[] result = new int[n];
        for (int j= 0; j<n; j++) {
            result[j] = pre[j]*suf[j];
        }
        return result;
    }
}
