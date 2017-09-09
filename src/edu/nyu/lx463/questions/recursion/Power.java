package edu.nyu.lx463.questions.recursion;

/**
 * Created by LyuXie on 7/16/17.
 */
public class Power {
    // 0 as denominator
    // 1 / 2 Integer of Float?
    // 0 ^ 0
    public double power(int a, int b) {
        if (a == 0 && b <= 0) {
            throw new IllegalArgumentException("illegal input");
        }

        if (b < 0) {
            return 1 / (double)helper(a, -b);
        }else {
            return (double)helper(a, b);
        }

    }

    private long helper(int a, int b) {
        if (b == 0) {
            return 1L;
        }

        long halfResult = helper(a, b / 2);

        if (b % 2 == 0) {
            return halfResult * halfResult;
        }else {
            return halfResult * halfResult * a;
        }
    }

    public static void main(String[] args) {
        Power po = new Power();
        System.out.print(po.power(0,-4));
    }

}
