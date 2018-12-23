public class Question47 {
    /**
     *               leetcode 最小路径和
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
     * 使得路径上的数字总和为最小。说明：每次只能向下或者向右移动一步。
     */
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != 0 && j == 0)
                    grid[i][j] += grid[i-1][j];
                else if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j-1];
                else if (i == 0 && j == 0)
                    grid[i][j] = grid[i][j];
                else
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows-1][cols-1];
    }

    /**
     *                      剑指offer 礼物的最大值
     * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘
     * 的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
     */

    // f[i,j] = max(f[i-1,j],f[i,j-1]) + gift[i,j]
    public int maxPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != 0 && j == 0)
                    grid[i][j] += grid[i-1][j];
                else if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j-1];
                else if (i == 0 && j == 0)
                    grid[i][j] = grid[i][j];
                else
                    grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows-1][cols-1];

//        if (grid == null || grid.length == 0)
//            return 0;
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int[] maxSum = new int[cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                int left = 0;
//                int up = 0;
//
//                if (i > 0)
//                    up = maxSum[j];
//                if (j > 0)
//                    left = maxSum[j - 1];
//
//                maxSum[j] = Math.max(up, left) + grid[i][j];
//            }
//        }
//
//        return maxSum[cols - 1];
    }

    public int maxPathSumNaive(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] maxSum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;

                if (i > 0)
                    up = maxSum[i - 1][j];
                if (j > 0)
                    left = maxSum[i][j - 1];

                maxSum[i][j] = Math.max(up, left) + grid[i][j];
            }
        }

        return maxSum[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        Question47 test = new Question47();
        System.out.println(test.maxPathSumNaive(grid));
        System.out.println(test.maxPathSum(grid));
    }
}
