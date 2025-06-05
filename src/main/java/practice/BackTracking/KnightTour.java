package practice.BackTracking;

public class KnightTour {

    public static void main(String[] args) {
        int n = 5;
        int m =5;
        int[][] res= knightTour(n, m);
        for (int i = 0 ; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] knightTour(int n, int m) {
        //You can code here
        int[][] board = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};//row
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};// column

        if (knightTourHelper(board, moveX, moveY, 0, 0, 0)){
            return board;
        } else {
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    board[i][j] = -1;
                }
            }
            return board;
        }
    }

    public static boolean isValid(int[][] board, int newRow, int newCol) {
        if (newRow>=0 && newRow < board.length && newCol >=0 && newCol < board[0].length && board[newRow][newCol] == -1){
            return true;
        } else {
            return false;
        }
    }

    public static boolean knightTourHelper(int[][] board, int[] moveX, int[] moveY, int row, int col, int step) {
        if (step == (board.length*board[0].length)-1) return true;

        for (int i = 0; i<8; i++) {
            int newRow = row+moveX[i];
            int newCol = col+moveY[i];
            if (isValid(board, newRow, newCol)) {
                board[newRow][newCol] = step+1;
                if (!knightTourHelper(board, moveX, moveY, newRow, newCol, step+1)){
                    board[newRow][newCol] = -1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
