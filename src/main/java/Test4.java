/*
Given a string, find if it has duplicates or not, without using collections or streams API.

Example:

Input : "abcd"
Output: false

Input: "adcde"
Output:  true
has context menu
 */

import org.springframework.util.AutoPopulatingList;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        //System.out.println(hasDup("Acb1A"));
        int[] arr = new int[] {1,1,2,2,3};
        System.out.println(freqSorted(arr));
    }

    public static boolean hasDup(String str) {
        char[] charArr = str.toCharArray();
        boolean[] arr = new boolean[256];
        for (int i = 0; i < charArr.length; i++) {
            if (arr[charArr[i]]) return true;
            arr[charArr[i]] = true;
        }
        return false;
    }



/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency,
sort them in decreasing order.

Return the sorted array.

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
has context menu
 */

    public static List<Integer> freqSorted(int[] arr) {
        int[] result = new int[arr.length];
        Map<Integer, List<Integer>> freq = new HashMap<>();
        for (int i =0; i< arr.length; i++) {
            if (freq.containsKey(arr[i])) {
                List<Integer> existingList = freq.get(arr[i]);
                existingList.add(arr[i]);

                freq.put(arr[i], existingList);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                freq.put(arr[i], list);
            }
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, List<Integer>> map: freq.entrySet()) {
            int key = map.getValue().size();
            if (treeMap.containsKey(key)) {
                List<Integer> existingMapEntry= treeMap.get(key);
                existingMapEntry.addAll(map.getValue());
                Collections.sort(existingMapEntry, Comparator.reverseOrder());
                treeMap.put(key, existingMapEntry);
            } else {
                treeMap.put(key, map.getValue());
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> list : treeMap.values()){
            resultList.addAll(list);
        }
        return resultList;

    }


}