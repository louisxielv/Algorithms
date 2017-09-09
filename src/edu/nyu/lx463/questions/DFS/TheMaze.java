package edu.nyu.lx463.questions.DFS;

import java.util.Arrays;

/**
 * Created by LyuXie on 7/25/17.
 */
public class TheMaze {
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int column = maze[0].length;
        boolean[][] startedHere = new boolean[row][column];
        return dfs(maze, startedHere, start, destination, row, column);
    }

    private boolean dfs(int[][] maze, boolean[][] startedHere, int[] start, int[] destination, int row, int column) {
        if (startedHere[start[0]][start[1]]) {
            return false;
        }
        if (Arrays.equals(start, destination)) {
            return true;
        }

        startedHere[start[0]][start[1]] = true;

        for (int i = 0; i < directions.length; i++) {
            int[] temp = roll(start[0], start[1], directions[i][0], directions[i][1], maze, row, column);
            if (dfs(maze, startedHere, temp, destination, row, column)) {
                return true;
            }
        }

        return false;
    }

    private int[] roll(int i, int j, int rowAdd, int columnAdd, int[][] maze, int row, int column) {
        while (canRoll(i + rowAdd, j + columnAdd, maze, row, column)) {
            i += rowAdd;
            j += columnAdd;
        }

        return new int[]{i, j};
    }

    private boolean canRoll(int i, int j, int[][] maze, int row, int column) {
        return i >= 0 && i < row && j >= 0 && j < column &&  maze[i][j] != 1;
    }

    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();
        int[][] maze = new int[][] {{0,0,1,0,0},
                                    {0,0,0,0,0},
                                    {0,0,0,1,0},
                                    {1,1,0,1,1},
                                    {0,0,0,0,0}};

        int[] start = new int[]{0, 4};
        int[] des = new int[]{4, 4};
        System.out.print(theMaze.hasPath(maze,start,des));


    }
}
