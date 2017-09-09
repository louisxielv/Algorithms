package edu.nyu.lx463.questions.BFS2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by LyuXie on 6/25/17.
 */
public class KthSmallestWithOnly357AsFactors {
    static class Cell implements Comparable<Cell>{
        private final int numOfThree;
        private final int numOfFive;
        private final int numOfSeven;
        private final long result;

        Cell(int numOfThree, int numOfFive, int numOfSeven) {
            this.numOfThree = numOfThree;
            this.numOfFive = numOfFive;
            this.numOfSeven = numOfSeven;
            long result = 1;
            while (numOfThree > 0 || numOfFive > 0 || numOfSeven > 0) {
                if (numOfThree > 0) {
                    result *= 3;
                    numOfThree--;
                }
                if (numOfFive > 0) {
                    result *= 5;
                    numOfFive--;
                }
                if (numOfSeven > 0) {
                    result *= 7;
                    numOfSeven--;
                }
            }

            this.result = result;
        }

        public int getNumOfThree() {
            return numOfThree;
        }

        public int getNumOfFive() {
            return numOfFive;
        }

        public int getNumOfSeven() {
            return numOfSeven;
        }

        public long getResult() {
            return result;
        }

        @Override
        public int compareTo(Cell cell) {
            if (cell.getResult() == this.getResult()) {
                return 0;
            }

            return this.getResult() < cell.getResult() ? -1 : 1;
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
            return this.getNumOfThree() == other.getNumOfThree() && this.getNumOfFive() == other.getNumOfFive() &&
                    this.getNumOfSeven() == other.getNumOfSeven();
        }

        @Override
        public int hashCode() {
            return numOfThree + 13 * numOfFive + 13 * 13 * numOfSeven;
        }
    }

    public long kth(int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(1, 1, 1));
        Set<Cell> set = new HashSet<>();
        set.add(pq.peek());
        int count = k;

        while (count > 0) {
            Cell cell = pq.poll();
            count--;
            if (count == 0) {
                return cell.getResult();
            }

            Cell cell1 = new Cell(cell.getNumOfThree()+ 1, cell.getNumOfFive(), cell.getNumOfSeven());
            Cell cell2 = new Cell(cell.getNumOfThree(), cell.getNumOfFive()+ 1, cell.getNumOfSeven());
            Cell cell3 = new Cell(cell.getNumOfThree(), cell.getNumOfFive(), cell.getNumOfSeven() + 1);

            if (!set.contains(cell1)) {
                pq.offer(cell1);
                set.add(cell1);
            }

            if (!set.contains(cell2)) {
                pq.offer(cell2);
                set.add(cell2);
            }

            if (!set.contains(cell3)) {
                pq.offer(cell3);
                set.add(cell3);
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        KthSmallestWithOnly357AsFactors kth = new KthSmallestWithOnly357AsFactors();
        long result = kth.kth(7);
        System.out.println(result);
    }

}
