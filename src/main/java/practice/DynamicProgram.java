package practice;

import java.sql.SQLDataException;
import java.util.HashMap;
import java.util.Map;

public class DynamicProgram {
    //public static HashMap<Integer, Integer> memoEmpty = new HashMap<>() ;
    public static void main(String[] args) {
        /*System.out.println(fib(8, new HashMap<>() ));
        System.out.println(fib(6, new HashMap<>() ));
        System.out.println(fib(7, new HashMap<>() ));*/

        /*System.out.println(gridTravel(2, 3, gridMap));
        System.out.println(gridMap.toString());*/

        System.out.println(canSum(7, new int[]{3, 4}));


    }

    public static Integer fib (int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <=2) {
            return  1;
        }else {
            memo.put(n,fib(n-1, memo)+ fib(n-2,memo)) ;
            return memo.get(n);
        }
    }

    private static Map<String, Integer> gridMap = new HashMap<>();

    public static int gridTravel (int m, int n, Map<String, Integer> map) {
        String key = String.valueOf(m) + ',' + String.valueOf(n);
        if (map.containsKey(key)) return map.get(key);
        if (m == 1 && n == 1) return 1;
        else if (m == 0 || n == 0) return 0;

        Integer result = gridTravel(m-1, n, map)  + gridTravel(m, n-1, map);
        map.put (key, result);
        return map.get(key);

    }

    public static boolean canSum (int target, int[] intArr) {
        if (target == 0) return true;
        if (target < 0) return false;

        for (int i=0 ; i < intArr.length; i++) {
            int remainder = target- intArr[i];
            if (canSum(remainder, intArr)){
                return  true;
            }
        }

        return false;
    }

}
