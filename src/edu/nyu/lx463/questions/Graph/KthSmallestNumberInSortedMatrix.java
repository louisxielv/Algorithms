package edu.nyu.lx463.questions.Graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by LyuXie on 4/16/17.
 */
public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here.
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] visited = new boolean[rows][columns];

        PriorityQueue<Cell> minHeap = new PriorityQueue<>(2*k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }

                return c1.value < c2.value ? -1 : 1;
            }
        });

        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            int m = curr.row;
            int n = curr.column;
            if (m + 1 < rows && !visited[m + 1][n]) {
                minHeap.offer(new Cell(m + 1, n, matrix[m + 1][n]));
                visited[m + 1][n] = true;
            }

            if (n + 1 < columns && !visited[m][n + 1]) {
                minHeap.offer(new Cell(m, n + 1, matrix[m][n + 1]));
                visited[m][n + 1] = true;
            }
        }

        return minHeap.poll().value;

    }

    static class Cell {
        int row;
        int column;
        int value;
        public Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
