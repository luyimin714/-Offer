public class Question12 {
    /**
     *                      矩阵中的路径
     *  请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     *  路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     *  如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     *  例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
     *  但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
     *  路径不能再次进入该格子。
     */
    // LeetCode
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

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
        if(pathLength == w.length) return true;
        if(row < 0 || col < 0 || row == board.length || col == board[row].length)
            return false;
        if(board[row][col] != w[pathLength]) //board[row * cols + col]
            return false;
        // board[y][x] is in range [0, 255].
        // Any number in this range ^256 should fall in a range of [256, 511].
        // This result should not be any valid character in "word".
        board[row][col] ^= 256;
        boolean exist = exist(board, w, row+1, col, pathLength+1) ||
                        exist(board, w, row-1, col, pathLength+1) ||
                        exist(board, w, row, col+1, pathLength+1) ||
                        exist(board, w, row, col-1, pathLength+1);
        board[row][col] ^= 256;
        return exist;
    }

    //剑指Offer
    public boolean exist2(char[][] board, String word) {
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
        if (pathLength == w.length) return true;

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
            board[row][col] == w[pathLength] && !visited[row][col]) {
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

    public static void main(String[] args) {
        //char在Java中占用2字节
        System.out.println((int) 'a');  //  0110 0001
        System.out.println((int) 'z');  //  0111 1010
        System.out.println((int) 'A');  //  0100 0001
        System.out.println((int) 'Z');  //  0101 1010
        System.out.println((char) 256); //1 0000 0000

        System.out.println(('a' ^ 256)); //1 0110 0001
        System.out.println((char) ('a' ^ 256));
        System.out.println(('z' ^ 256)); //1 0111 1010
        System.out.println((char) ('z' ^ 256));
    }
}
