package edu.nyu.lx463.questions.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by LyuXie on 4/16/17.
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }


    private void bfs(char[][] grid, int row, int column, boolean[][] visited) {
        Cell root = new Cell(row, column);
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(root);
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            int m = curr.row;
            int n = curr.column;
            if (m - 1 >= 0 && !visited[m - 1][n] && grid[m - 1][n] == '1') {
                queue.offer(new Cell(m - 1, n));
                visited[m- 1][n] = true;
            }

            if (m + 1 < grid.length && !visited[m + 1][n] && grid[m + 1][n] == '1') {
                queue.offer(new Cell(m + 1, n));
                visited[m + 1][n] = true;
            }
            if (n + 1 < grid[0].length && !visited[m][n + 1] && grid[m][n + 1] == '1') {
                queue.offer(new Cell(m, n + 1));
                visited[m][n + 1] = true;
            }

            if (n - 1 >= 0 && !visited[m][n - 1] && grid[m][n - 1] == '1') {
                queue.offer(new Cell(m, n - 1));
                visited[m][n - 1] = true;
            }
        }
    }

    static class Cell {
        private int row;
        private int column;
        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}