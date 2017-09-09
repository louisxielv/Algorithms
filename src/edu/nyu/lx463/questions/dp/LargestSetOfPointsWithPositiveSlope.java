package edu.nyu.lx463.questions.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by LyuXie on 7/7/17.
 */
public class LargestSetOfPointsWithPositiveSlope {
    static class Point{
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    public int largest(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.x == b.x) {
                    if (a.y == b.y) {
                        return 0;
                    }
                    return a.y < b.y ? -1 : 1;
                }

                return a.x < b.x ? -1 : 1;
            }
        });

        int result = longest2(points);
        return result == 1 ? 0 : result;
    }

    public int longest2(Point[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] refine = new int[array.length];
        refine[0] = array[0].y;
        int result = 1;
        int pointer = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].y > refine[pointer]) {
                refine[++pointer] = array[i].y;
                result = Math.max(result, pointer + 1);
            }else {
                int index = firstBiggerEqual(refine, pointer, array[i].y);
                refine[index] = array[i].y;
            }
        }

        return result;
}

    private int firstBiggerEqual(int[] array, int pointer, int target){
        int start = 0, end = pointer;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < target) {
                start = mid;
            }else if (array[mid] == target) {
                return mid;
            }
            else {
                end = mid;
            }
        }

        if (array[start] >= target) {
            return start;
        }else {
            return end;
        }
    }

    public static void main(String[] args) {
        LargestSetOfPointsWithPositiveSlope lsop = new LargestSetOfPointsWithPositiveSlope();
        Point[] array = new Point[9];
        array[0] = new Point(0, 1);
        array[1] = new Point(1, 3);
        array[2] = new Point(2, 3);
        array[3] = new Point(3,1);
        array[4] = new Point(3,3);
        array[5] = new Point(4,2);
        array[6] = new Point(5,2);
        array[7] = new Point(5,5);
        array[8] = new Point(6,1);
        System.out.print(lsop.largest(array));
    }
}
