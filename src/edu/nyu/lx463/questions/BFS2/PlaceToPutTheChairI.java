package edu.nyu.lx463.questions.BFS2;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by LyuXie on 6/27/17.
 */
public class PlaceToPutTheChairI {
    private static final char OB = 'O';
    private static final char EQUIP = 'E';

    static class Cell {
        int i;
        int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<Integer> putChair(char[][] gym) {
        List<Integer> result = null;
        int[][] cost = new int[gym.length][gym[0].length];

        for (int row = 0; row < gym.length; row++) {
            for (int column = 0; column < gym[0].length; column++) {
                if (gym[row][column] == EQUIP) {
                    if (!addCost(cost, gym, row, column)) {
                        return null;
                    }
                }
            }
        }

        for (int row = 0; row < gym.length; row++) {
            for (int column = 0; column < gym[0].length; column++) {
                if (gym[row][column] != OB && gym[row][column] != EQUIP) {
                    if (result == null) {
                        result = Arrays.asList(row, column);
                    } else if (cost[row][column] < cost[result.get(0)][result.get(1)]) {
                        result.set(0, row);
                        result.set(1, column);
                    }
                }
            }
        }

        return result;
    }

    private boolean addCost(int[][] cost, char[][] gym, int row, int column) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        visited[row][column] = true;
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(row, column));
        int pathCost = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                List<Cell> neis = generate(cell, gym);
                for (Cell curr : neis) {
                    if (!visited[curr.i][curr.j]) {
                        queue.offer(curr);
                        cost[curr.i][curr.j] += pathCost;
                        visited[curr.i][curr.j] = true;
                    }
                }
            }
            pathCost++;
        }

        for (int m = 0; m < gym.length; m++) {
            for (int l = 0; l < gym[0].length; l++) {
                if (gym[m][l] == EQUIP && !visited[m][l]) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<Cell> generate(Cell cell, char[][] gym) {
        int row = gym.length;
        int column = gym[0].length;
        int i = cell.i;
        int j = cell.j;
        List<Cell> neis = new ArrayList<>();

        if (i + 1 < row && gym[i + 1][j] != OB) {
            neis.add(new Cell(i + 1, j));
        }

        if (i - 1 >= 0 && gym[i - 1][j] != OB ) {
            neis.add(new Cell(i - 1, j));
        }

        if (j + 1 < column && gym[i][j + 1] !=  OB) {
            neis.add(new Cell(i, j + 1));
        }

        if (j - 1 >= 0 && gym[i][j - 1] !=  OB) {
            neis.add(new Cell(i, j - 1));
        }

        return neis;

    }

    public static void main(String[] args) {
        PlaceToPutTheChairI ptp = new PlaceToPutTheChairI();
        char[][] chars = new char[][]{{ 'E', 'O', 'C'},
                                {'C', 'E',  'C'},
                                {'C',  'C',  'C'} };
        List<Integer> result = ptp.putChair(chars);
        for (Integer i : result) {
            System.out.print(i);
        }
    }

}


