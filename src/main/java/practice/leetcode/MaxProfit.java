package practice.leetcode;

public class MaxProfit {
    public static void main(String[] args) {
        int[] inout = {7, 1, 5, 3, 6, 4};
        //int[] res = maxProfit(inout);
        int res = maxProfitUsingLeast(inout);
        System.out.println("data : " + res);
    }
    // retrun the days
    // get the least so far
    public static int[] maxProfit(int[] arr) {
        int[] result = new int[2];
        int max = 0;
        for (int i =0 ; i < arr.length-1; i++ ){
            for (int j = i+1; j< arr.length; j++) {
                if (arr[j] > arr[i]){
                    if (max < arr[j]-arr[i]) {
                        max = arr[j]-arr[i];
                        result[0]= i;
                        result[1]= j;
                    }
                }
            }
        }
        return result;
    }

    public static int maxProfitUsingLeast (int[] arr) {
        int lsf = Integer.MAX_VALUE;
        int profit = 0;
        int maxPro = 0;
        int[] result= new int[2];
        for (int i = 0; i< arr.length; i++) {
            if (arr[i] < lsf) {
                lsf = arr[i];

            }
            profit = arr[i]- lsf;
            if (maxPro < profit) {
                maxPro = profit;

            }
        }
        return maxPro;
    }
}
