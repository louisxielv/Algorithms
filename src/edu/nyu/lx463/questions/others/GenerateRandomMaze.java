package edu.nyu.lx463.questions.others;

/**
 * Created by LyuXie on 7/7/17.
 */
public class GenerateRandomMaze {
    enum Dir {
        UP(0, 1),
        DOWN(0, -1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        int dirX;
        int dirY;

        Dir(int dirX, int dirY) {
            this.dirX = dirX;
            this.dirY = dirY;
        }

        public int moveX(int x, int times) {
            return x + dirX * times;
        }

        public int moveY(int y, int times) {
            return y + dirY * times;
        }
    }

    public int[][] maze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maze[i][j] = 0;
                }else {
                    maze[i][j] = 1;
                }
            }
        }

        generate(maze, 0, 0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX = dir.moveX(x, 2);
            int nextY = dir.moveY(y, 2);

            if (isValidWall(maze, nextX, nextY, maze.length)) {
                maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
                maze[nextX][nextY] = 0;
                generate(maze, nextX,nextY);
            }
        }
    }

    private boolean isValidWall(int[][] maze, int nextX, int nextY, int n) {
        return nextX < n && nextX >= 0 && nextY >=0 && nextY < n && maze[nextX][nextY] == 1;
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int index = (int)(Math.random() * (dirs.length - i));
            Dir temp = dirs[i];
            dirs[i] = dirs[i + index];
            dirs[i + index] = temp;
        }
    }


}
