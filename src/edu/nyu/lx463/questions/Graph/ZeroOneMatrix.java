package edu.nyu.lx463.questions.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by LyuXie on 4/16/17.
 */
public class ZeroOneMatrix {
    public List<List<Integer>> updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visited ;

        for (int i = 0; i < rows; i++) {
            int[] list = matrix[i];
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                if (list[j] == 0) {
                    newList.add(0);
                }
                else {
                    visited = new boolean[rows][columns];
                    int count = bfs(matrix, i, j, visited);
                    newList.add(count);
                }
            }
            result.add(newList);
        }

        return result;
    }

    private int bfs (int[][] matrix, int row, int column, boolean[][] visited) {
        Cell root = new Cell(row, column, 0);
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(root);
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            int m = curr.row;
            int n = curr.column;
            int count = curr.count;

            if (m - 1 >= 0) {
                if (matrix[m - 1][n] == 0) {
                    return count + 1;
                }
                if (!visited[m - 1][n]) {
                    queue.offer(new Cell(m - 1, n, count + 1));
                    visited[m - 1][n] = true;
                }
            }

            if (n - 1 >= 0) {
                if (matrix[m][n - 1] == 0) {
                    return count + 1;
                }
                if (!visited[m][n - 1]) {
                    queue.offer(new Cell(m, n - 1, count + 1));
                }
                visited[m][n - 1] = true;
            }

            if (m + 1 < matrix.length) {
                if (matrix[m + 1][n] == 0) {
                    return count + 1;
                }
                if (!visited[m + 1][n]) {
                    queue.offer(new Cell(m + 1, n, count + 1));
                }

                visited[m + 1][n] = true;
            }

            if (n + 1 < matrix[0].length) {
                if (matrix[m][n + 1] == 0) {
                    return count + 1;
                }
                if (!visited[m][n + 1]) {
                    queue.offer(new Cell(m, n + 1, count + 1));
                }

                visited[m][n + 1] = true;
            }
        }

        return 0;
    }

    static class Cell {
        int row;
        int column;
        int count;
        public Cell(int row, int column, int count) {
            this.row = row;
            this.column = column;
            this.count = count;
        }
    }
}
