package edu.nyu.lx463.questions.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by LyuXie on 7/6/17.
 */
public class MostPointsOnALine {

    static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        double a;
        double b;
        Line(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }

            Line line = (Line) o;
            if (this.a != line.a) {
                return false;
            }
            if (this.b != line.b) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return (int)(31 * 31  * a + 31 * 31 * 31 *b);
        }

    }

    public int most(Point[] points) {
        Map<Line, Set<Point>> map = new HashMap<>();
        Map<Integer, Set<Point>> infinityMap = new HashMap<>();
        int biggest = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                if (points[i].x == points[j].x) {
                    Set<Point> infinitySet = infinityMap.get(points[i].x);
                    if (infinitySet == null) {
                        infinitySet = new HashSet<>();
                        infinitySet.add(points[i]);
                        infinitySet.add(points[j]);
                    }
                    biggest = Math.max(biggest, infinitySet.size());
                    infinityMap.put(points[i].x, infinitySet);

                }
                else {
                    double a = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    double b = points[i].y - a * points[i].x;
                    Line line = new Line(a, b);
                    Set<Point> set = map.get(line);
                    if (set == null) {
                        set = new HashSet<>();
                    }

                    set.add(points[i]);
                    set.add(points[j]);
                    biggest = Math.max(set.size(), biggest);
                    map.put(line, set);
                }
            }
        }

        return biggest;
    }

    public static void main(String[] args) {
        MostPointsOnALine mp = new MostPointsOnALine();
        Point[] points = new Point[4];
        points[0] = new Point(0,0);
        points[1] = new Point(1,1);
        points[2] = new Point(2,3);
        points[3] = new Point(3,3);
        System.out.println(mp.most(points));

    }
}
