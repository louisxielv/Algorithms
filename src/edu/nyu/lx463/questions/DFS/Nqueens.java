package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 5/11/17.
 */

/*
    Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

    Assumptions

    N > 0
    Return

    A list of ways of putting the N Queens
    Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
    Example

    N = 4, there are two ways of putting 4 queens:

            [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

            [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
*/


public class Nqueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        boolean[] usedColumn = new boolean[n];
        boolean[] usedDiagonal = new boolean[n + n - 1];
        boolean[] usedRevDiagonal = new boolean[n + n - 1];

        List<Integer> list = new ArrayList<>();

        dfs(result, list, 0, n, usedColumn, usedDiagonal, usedRevDiagonal);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int index, int n, boolean[] usedColumn, boolean[] usedDiagonal, boolean[] usedRevDiagonal) {
        if (index == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(index, i, n, usedColumn, usedDiagonal, usedRevDiagonal)) {
                mark(index, i, n,usedColumn, usedDiagonal, usedRevDiagonal);
                list.add(i);
                dfs(result, list, index + 1, n, usedColumn, usedDiagonal, usedRevDiagonal);
                list.remove(list.size() - 1);
                unmark(index, i, n,usedColumn, usedDiagonal, usedRevDiagonal);
            }
        }
    }

    private void unmark(int row, int column, int n, boolean[] usedColumn, boolean[] usedDiagonal, boolean[] usedRevDiagonal) {
        usedColumn[column] = false;
        usedDiagonal[row + column] = false;
        usedRevDiagonal[row - column + n - 1] = false;
    }

    private void mark(int row, int column, int n, boolean[] usedColumn, boolean[] usedDiagonal, boolean[] usedRevDiagonal) {
        usedColumn[column] = true;
        usedDiagonal[row + column] = true;
        usedRevDiagonal[row - column + n - 1] = true;
    }

    private boolean isValid(int row, int column, int n, boolean[] usedColumn, boolean[] usedDiagonal, boolean[] usedRevDiagonal) {
        return !(usedColumn[column] || usedDiagonal[row + column] || usedRevDiagonal[row - column + n - 1]);
    }


}
