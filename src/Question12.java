public class Question12 {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        char[] w = word.toCharArray();

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (exist(board, w, row, col, pathLength))
                    return true;
            }
        }

        return false;
    }
    private boolean exist(char[][] board, char[] w, int row, int col, int pathLength) {
        if(pathLength == w.length)
            return true;
        if(row < 0 || col < 0 || row == board.length || col == board[row].length)
            return false;
        if(board[row][col] != w[pathLength])
            return false;
        board[row][col] ^= 256;
        boolean exist = exist(board, w, row+1, col, pathLength+1) ||
                        exist(board, w, row-1, col, pathLength+1) ||
                        exist(board, w, row, col+1, pathLength+1) ||
                        exist(board, w, row, col-1, pathLength+1);
        board[row][col] ^= 256;
        return exist;
    }

    public boolean existNaive(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        char[] w = word.toCharArray();

        if (board == null || rows < 1 || cols < 1 || word == null)
            return false;

        boolean[][] visited = new boolean[rows][cols];

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(board, rows, cols, row, col, w, pathLength, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean hasPathCore(char[][] board, int rows, int cols, int row, int col,
                                char[] w, int pathLength, boolean[][] visited) {
        if (pathLength == w.length)
            return true;

        boolean hasPath = false;
        if (row >= 0 && row < rows &&
                col >= 0 && col < cols &&
                board[row][col] == w[pathLength]
                && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;

            hasPath = hasPathCore(board, rows, cols, row, col - 1, w, pathLength, visited) ||
                    hasPathCore(board, rows, cols, row - 1, col, w, pathLength, visited) ||
                    hasPathCore(board, rows, cols, row, col + 1, w, pathLength, visited) ||
                    hasPathCore(board, rows, cols, row + 1, col, w, pathLength, visited);

            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
