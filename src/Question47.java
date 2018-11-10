public class Question47 {
    /*
     * 最小路径和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        return grid[m-1][n-1];
    }

    /*
     * 最大路径和
     */
    public int maxPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        return grid[m-1][n-1];

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
