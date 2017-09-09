package edu.nyu.lx463.questions.BFS2;

import edu.nyu.lx463.questions.dp.MaxWatterTrappedI;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by LyuXie on 6/28/17.
 */
public class MaxWatterTrappedII {
    static class Cell implements Comparable<Cell>{
        int x;
        int y;
        int height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(Cell cell) {
            if (cell.height == this.height) {
                return 0;
            }

            return this.height < cell.height ? -1 : 1;
        }
    }

    public int maxTrapped(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows < 3 || columns < 3) {
            return 0;
        }

        PriorityQueue<Cell> minHeap= new PriorityQueue<>();
        boolean[][] visited = new boolean[rows][columns];
        processBorder(minHeap, visited, rows, columns, matrix);
        int result = 0;

        while (!minHeap.isEmpty()) {
            Cell curr = minHeap.poll();
            List<Cell> neis = getNeis(curr, rows, columns, matrix);
            for (Cell nei : neis) {
                if(visited[nei.x][nei.y]) {
                    continue;
                }

                result += Math.max(0, curr.height - nei.height);
                nei.height = Math.max(curr.height, nei.height);
                visited[nei.x][nei.y] = true;
                minHeap.offer(nei);
            }
        }

        return result;
    }

    private List<Cell> getNeis(Cell curr, int rows, int columns, int[][] matrix) {
        List<Cell> neis = new ArrayList<>();
        if (curr.x + 1 < rows) {
            neis.add(new Cell(curr.x + 1, curr.y, matrix[curr.x + 1][curr.y]));
        }
        if (curr.x - 1 >= 0) {
            neis.add(new Cell(curr.x - 1, curr.y, matrix[curr.x - 1][curr.y]));
        }

        if (curr.y + 1 < columns) {
            neis.add(new Cell(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
        }

        if (curr.y - 1 >= 0) {
            neis.add(new Cell(curr.x, curr.y - 1, matrix[curr.x][curr.y - 1]));
        }

        return neis;
    }


    private void processBorder(PriorityQueue<Cell> minHeap, boolean[][] visited, int rows, int columns, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            minHeap.offer(new Cell(i, 0, matrix[i][0]));
            minHeap.offer(new Cell(i, columns - 1, matrix[i][columns - 1]));
            visited[i][0] = true;
            visited[i][columns - 1] = true;
        }

        for (int i = 0; i < columns; i++) {
            minHeap.offer(new Cell(0, i, matrix[0][i]));
            minHeap.offer(new Cell(rows - 1, i, matrix[rows - 1][i]));
            visited[0][i] = true;
            visited[rows - 1][i] = true;
        }
    }


    public static void main(String[] args) {
        MaxWatterTrappedII maxw = new MaxWatterTrappedII();
        int result = maxw.maxTrapped(new int[][]{{ 2, 3, 4, 2},

                { 3, 1, 2, 3 },

                {4, 3, 5, 4} });

        System.out.print(result);
    }


}
