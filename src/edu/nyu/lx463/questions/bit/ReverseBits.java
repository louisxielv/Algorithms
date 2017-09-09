package edu.nyu.lx463.questions.bit;

/**
 * Created by LyuXie on 5/2/17.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; ++i) {
            int right = (n >>> i) & 1;
            int left = (n >>> (31 - i))  & 1;

            if (left != right) {
                n = n ^ (1 << i);
                n = n ^ (1 << (31 - i));
            }
        }

        return n;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        rb.reverseBits(1);
    }
}
