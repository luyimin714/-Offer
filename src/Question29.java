import java.util.ArrayList;
import java.util.List;

public class Question29 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length <= 0)
            return list;

        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        while (cols > start * 2 && rows > start * 2) {
            helper(matrix, list, cols, rows, start);
            start++;
        }

        return list;
    }

    private void helper(int[][] matrix, List<Integer> list, int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                list.add(matrix[i][start]);
            }
        }
    }
}
