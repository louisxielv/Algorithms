package edu.nyu.lx463.questions.BFS2;

import java.util.*;

/**
 * Created by LyuXie on 6/25/17.
 */
public class LargestProductLength {
    public int largestProduct(String[] dict) {
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return 0;
                }

                return s1.length() > s2.length() ? -1 : 1;
            }
        });

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        Set<Cell> set = new HashSet<>();

        pq.offer(new Cell(dict[0], dict[1], 0, 1));
        set.add(pq.peek());

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            if (!hasCommon(cell)) {
                return cell.getProduct();
            }

            if (cell.getIndex1() < dict.length - 1 && cell.getIndex1() + 1 != cell.getIndex2()) {
                Cell cell1 = new Cell(dict[cell.getIndex1() + 1], dict[cell.getIndex2()], cell.getIndex1() + 1, cell.getIndex2());
                if (!set.contains(cell1)) {
                    pq.offer(cell1);
                    set.add(cell1);
                }
            }

            if (cell.getIndex2() < dict.length - 1 && cell.getIndex2() + 1 != cell.getIndex1()) {
                Cell cell2 = new Cell(dict[cell.getIndex1()], dict[cell.getIndex2() + 1], cell.getIndex1(), cell.getIndex2() + 1);
                if (!set.contains(cell2)) {
                    pq.offer(cell2);
                    set.add(cell2);
                }
            }



        }

        return 0;

    }

    private boolean hasCommon(Cell cell) {
        String s1 = cell.getS1();
        String s2 = cell.getS2();

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                return true;
            }
        }

        return false;

    }

    static class Cell implements Comparable<Cell>{
        private final String s1;
        private final String s2;
        private final int product;
        private final int index1;

        public int getIndex1() {
            return index1;
        }

        public int getIndex2() {
            return index2;
        }

        private final int index2;



        public String getS1() {
            return s1;
        }

        public String getS2() {
            return s2;
        }

        public int getProduct() {
            return product;
        }

        Cell(String s1, String s2, int index1, int index2){
            this.s1 = s1;
            this.s2 = s2;
            this.index1 = index1;
            this.index2 = index2;
            product = s1.length() * s2.length();
        }

        @Override
        public int compareTo(Cell c) {
            if (c.product == this.product) {
                return 0;
            }

            return this.product > c.product ? -1 : 1;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }

            if (this == o) {
                return true;
            }

            Cell other = (Cell) o;

            if (this.getProduct() != other.getProduct()) {
                return false;
            }

            if (this.getS1() != null ? !this.getS1().equals(other.getS1()) : other.getS1() != null) {
                return false;
            }

            if (this.getS2() != null ? !this.getS2().equals(other.getS2()) : other.getS2() != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int hashcode = 0;
            hashcode += this.s1 == null ? 0 : this.s1.hashCode();
            hashcode += this.s2 == null ? 0 : this.s2.hashCode();
            return hashcode;
        }

    }


    public static void main(String[] args) {
        LargestProductLength lpl = new LargestProductLength();
        String[] dict = new String[]{"abcde", "abcd", "ade", "xy"};
        int result = lpl.largestProduct(dict);
        System.out.println(result);
    }
}
