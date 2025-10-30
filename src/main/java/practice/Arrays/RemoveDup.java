package practice.Arrays;

import java.util.Arrays;

public class RemoveDup {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1,2, 2};
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                arr[k] = arr[i];
                k++;
            }
        }
        while(k< arr.length) {
            arr[k] = -1;
            k++;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
