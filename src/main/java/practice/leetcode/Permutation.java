package practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String[] args) {
        int[] test = {1,2,3};
        System.out.println(allPermutaion(test));
    }

    public static List<List<Integer>> allPermutaion (int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];

        recurPerm(nums, result, combination, freq);
        return result;

    }
    // 1 2 3
    //i = 2, com = [1,2, 3],      fre[0 T,1 F, 2 T]
    // i = 1, rem 1 com 1, 3
    // i=2, com 1, 3,2

    //i=1 rem 2  com 1,2
    //
    //

    private static void recurPerm(int[] nums, List<List<Integer>> result,
                                  List<Integer> combination, boolean[] freq) {
        if (combination.size() == nums.length) {
            List<Integer> miniresult = new ArrayList<>(combination);
            result.add(miniresult);
            return;
        }
        for (int i = 0; i<nums.length ; i++){
            if (!freq[i]) {
                freq[i]=true;
                combination.add(nums[i]);
                recurPerm(nums, result,combination, freq);
                int remindx = combination.indexOf(nums[i]);
                combination.remove(remindx);
                freq[i] = false;
            }
        }

    }
}
