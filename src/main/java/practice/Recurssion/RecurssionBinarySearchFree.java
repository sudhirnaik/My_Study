package practice.Recurssion;

import java.util.Arrays;

public class RecurssionBinarySearchFree {

 // youtube videos free code by alvin

    public static void main(String[] args) {
        // String reversal
        String input = "Hello world, i am an engineer";
       // StringBuilder res = new StringBuilder();
        System.out.println(stringReverse(input));

        String palidrime = "kayak1";

        System.out.println(isPalindrome(palidrime));

        Integer number = 255 ;

        System.out.println(numberToBinary(number));

        int[] arr ={-1, 0, 2, 4 ,6 ,6, 7, 9, 30};

        //System.out.println(binarySearch(arr, 0, arr.length, 6));
        System.out.println("frist occurance of : "+binarySearchFirstOccurance(arr, 0, arr.length, 6));
        System.out.println("find upper bound: "+findUpperBound(arr, 0, arr.length, 5memo));
        /*
        order of O(root n)  if we loop through all number for(int i =1; i*i<=n; i++)
        order of O(log(n)) using binary search
        */
        System.out.println("SquareRoot: " + squareRoot(24));

        int[] sortedRotataed ={5, 6, 7, -1 ,1 ,2, 4};
        System.out.println("rotated indx: "+findInSorted(sortedRotataed, 1));




        int[] unsorted = {0, 4, 10, 3, -12, 100, 90};

        mergeSort(unsorted, 0, unsorted.length-1);

        System.out.println(Arrays.toString(unsorted));




        //System.out.println(res.toString());
    }

    public static int squareRoot(int n) {
        int left = 1;
        int right = n;
        int ans =1;

        while (left <=right) {
            int mid = left +(right-left)/2;
            if (n ==mid*mid) return mid;
            if (n > mid*mid) {
                ans =mid;
                left = mid+1;
            } else if (mid*mid > n){
                right = mid-1;
            }
        }
        return ans;
    }

   public static void mergeSort(int[] data, int start, int end) {
        if (start<end) {
            int mid = (start+end)/2;
            mergeSort(data, start, mid);
            mergeSort(data, mid+1, end);
            merge(data, start, mid, end);
        }
    }

    //linear merge
    public static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int k = 0;
        int i = start;
        int j = mid+1;
        while(i<=mid && j<=end){
            if (data[i] < data[j]) {
                temp[k] = data[i];
                k++;
                i++;
            } else {
                temp[k] = data[j];
                k++;
                j++;
            }
        }

        while (i<=mid) {
            temp[k++] = data[i++];
        }

        while (j<=end) {
            temp[k++] = data[j++];
        }

        for (int m = 0; m<k; m++) {
            data[start+m] = temp[m];
        }
    }

    public static boolean isPalindrome(String str) {
        if (str.length()<=1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindrome(str.substring(1, str.length()-1));
        } else {
            return false;
        }
    }

    public static int binarySearchFirstOccurance(int[] arr, int left, int right, int target) {
        int res = -1;
       while (left <= right) {
           int mid = left + (right-left)/2;
           if (target < arr[mid]) {
               right = mid-1;
           } else if (target > arr[mid]) {
               left = mid+1;
           } else {
               res = mid;
               right  = mid-1;
           }
       }
       return res;
    }

    public static int findInSorted(int[] arr, int target) {
        //int[] sortedRotataed ={5, 6, 7, 9 ,1 ,2, 4};
       /*
       1
       cases
       1. arr[mid] < target ans has to be right
       2. arr[mid] > target
          right if arr[left] > target
          else left

        */
        int left = 0;
        int right = arr.length-1;
        int ans = -1;
        while (left<=right) {
            int mid = left +(right-left)/2;

            if (arr[mid] < target) {
                left = mid+1;
            } else if (arr[mid] > target) {
                if (arr[left] > target) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else {
                return mid;
            }

        }
      return ans;
    }

    public static int findUpperBound(int[] arr, int left, int right, int target) {
        /*
        target >  mid
          go right
        target < mid
          might be and
          but go left
        targte == mid
          go right
         */
        int ans = arr.length;
        while (left<=right) {
            int mid = (left+right)/2;
            if (target >= arr[mid]) {
                left = mid+1;
            } else {
                ans = mid;
                right = mid-1;
            }
        }
        return ans;
    }


    // find the last occurance of it and add 1
    /*public static int findUpperBound(int[] arr, int left, int right, int target) {
      int ans = arr.length;
      *//*
      cases:
      1.arr[mid] is > target might be ans but then move left
      2. arr[mid] is < target ans is on right
      3. mid == target ans is on right
       */
        /*
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (arr[mid] <= target) {
                left = mid+1;
            } else if (arr[mid] > target) {
                ans = arr[mid];
                right = mid-1;
            }
        }
        return ans;
    }*/



    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left> right ) {
            return -1;
        }

        int mid = (left+right)/2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target<arr[mid]) {
            return binarySearch(arr, left, mid-1, target);
        }

        return binarySearch(arr, mid+1, right, target);
    }

    public static String stringReverse(String str) {
        if (str.isEmpty()) {
            return "";
        }

        return stringReverse(str.substring(1))+str.charAt(0);
    }

    public static String numberToBinary(int number) {
        // base case
        //stop when the number after divided is 0
        if (number==0) {
            return "";
        }
        int divided = number/2;
        int remainder = number%2;
        return numberToBinary(divided) + remainder;
    }
}
