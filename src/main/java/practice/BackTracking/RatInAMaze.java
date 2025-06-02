package practice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMaze {
    /*
    In a square matrix of order N * N, imagine a rat placed at position (0, 0). The final location
    must be reached at (N - 1, N - 1). Find every route the rat might possibly take to go from point A to point B.
    The rat can move in the following directions: "U" (up), "D" (down), "L" (left), and "R" (right).
    Rats cannot move to a cell with a value of 0 in the matrix because it is blocked,
    while rats can pass through cells with a value of 1 in the matrix.
No cell can be visited more than once in a journey. The rat cannot go to any other cell if the originating cell is 0.

Complete the function findPath() which takes N and 2D array m[ ][ ] as input parameters
and returns the list of paths in lexicographically increasing order.

Example 1:
Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1},
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at
(3, 3) from (0, 0) by two paths - DRDDRR
and DDRDRR, when printed in sorted order
we get DDRDRR DRDDRR.
     */
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        System.out.println(findPath(arr, 4));
    }

    public static ArrayList<String> findPath(int[][] arr, int n) {
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> result = new ArrayList<>();
        findPathHelper(arr, n, 0, 0, visited, result,"");
        return result;
    }

    public static Boolean isValid(int i, int j, int n, boolean[][] visited, int[][] arr) {
        if (i<n && j<n && i>=0 && j>=0 && !visited[i][j] && arr[i][j]==1) {
            return true;
        } else {
            return false;
        }
    }

    public static void findPathHelper(int[][] arr, int n, int i, int j, boolean[][] visited, ArrayList<String> result, String str) {
        if (i == n-1 && j == n-1) {
            result.add(str);
            return;
        }

        if (isValid(i+1, j, n, visited, arr)) {
            visited[i+1][j] = true;
            findPathHelper(arr, n, i+1, j, visited, result, str+"D");
            visited[i+1][j] = false;
        }
        if (isValid(i, j-1, n, visited, arr)) {
            visited[i][j-1] = true;
            findPathHelper(arr, n, i, j-1, visited, result, str+"L");
            visited[i][j-1] = false;
        }
        if (isValid(i, j+1, n, visited, arr)) {
            visited[i][j+1] = true;
            findPathHelper(arr, n, i, j+1, visited, result, str+"R");
            visited[i][j+1] = false;
        }
        if (isValid(i-1, j, n, visited, arr)) {
            visited[i-1][j] = true;
            findPathHelper(arr, n, i-1, j, visited, result, str+"U");
            visited[i-1][j] = false;
        }

    }
}
