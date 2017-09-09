package edu.nyu.lx463.questions.BFS2;

import java.util.*;

/**
 * Created by LyuXie on 6/25/17.
 */
public class KthCloestTo000 {
    static class Cell implements Comparable<Cell>{
        private final int aIndex;
        private final int bIndex;
        private final int cIndex;
        private final int distanceSquare;

        public Cell(int aIndex, int bIndex, int cIndex, int distanceSquare) {
            this.aIndex = aIndex;
            this.bIndex = bIndex;
            this.cIndex = cIndex;
            this.distanceSquare = distanceSquare;
        }

        public int getaIndex() {
            return aIndex;
        }

        public int getbIndex() {
            return bIndex;
        }

        public int getcIndex() {
            return cIndex;
        }

        public int getDistanceSquare() {
            return distanceSquare;
        }

        @Override
        public int compareTo(Cell cell) {
            if (cell.getDistanceSquare() == this.getDistanceSquare()) {
                return 0;
            }

            return this.getDistanceSquare() < cell.getDistanceSquare() ? -1 : 1;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }

            if (o == this) {
                return true;
            }

            Cell other = (Cell) o;
            return this.getaIndex() == other.getaIndex() && this.getbIndex() == other.getbIndex() &&
                    this.getcIndex() == other.getcIndex();
        }

        @Override
        public int hashCode() {
            return getaIndex() + 13 * getbIndex() + 13 * 13 * getcIndex();
        }
    }
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        Set<Cell> set = new HashSet<>();

        pq.offer(new Cell(0, 0, 0, a[0] * a[0] + b[0] * b[0] + c[0] * c[0]));
        set.add(pq.peek());

        int count = k;

        while (!pq.isEmpty() && count > 0) {
            Cell cell = pq.poll();
            count--;
            if (count == 0) {
                return Arrays.asList(a[cell.getaIndex()], b[cell.getbIndex()], c[cell.getcIndex()]);
            }

            if (cell.getaIndex() + 1 < a.length) {
                Cell cell1 = new Cell(cell.getaIndex() + 1, cell.getbIndex(), cell.getcIndex(),
                        a[cell.getaIndex() + 1] * a[cell.getaIndex() + 1] + b[cell.getbIndex()] * b[cell.getbIndex()] +
                                c[cell.getcIndex()] * c[cell.getcIndex()]);

                if (!set.contains(cell1)) {
                    pq.offer(cell1);
                    set.add(cell1);
                }
            }

            if (cell.getbIndex() + 1 < b.length) {
                Cell cell2 = new Cell(cell.getaIndex(), cell.getbIndex() + 1, cell.getcIndex(),
                        a[cell.getaIndex()] * a[cell.getaIndex()] + b[cell.getbIndex() + 1] * b[cell.getbIndex() + 1] +
                                c[cell.getcIndex()] * c[cell.getcIndex()]);

                if (!set.contains(cell2)) {
                    pq.offer(cell2);
                    set.add(cell2);
                }
            }

            if (cell.getcIndex() + 1 < c.length) {
                Cell cell3 = new Cell(cell.getaIndex(), cell.getbIndex(), cell.getcIndex() + 1,
                        a[cell.getaIndex()] * a[cell.getaIndex()] + b[cell.getbIndex()] * b[cell.getbIndex()] +
                                c[cell.getcIndex() + 1] * c[cell.getcIndex() + 1]);

                if (!set.contains(cell3)) {
                    pq.offer(cell3);
                    set.add(cell3);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        KthCloestTo000 kth = new KthCloestTo000();
        List<Integer> result = kth.closest(new int[]{1, 2, 3}, new int[]{2, 4}, new int[]{6}, 6);

    }
}
