import java.util.ArrayList;
import java.util.List;

public class Question29 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0)
            return list;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return list;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
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
