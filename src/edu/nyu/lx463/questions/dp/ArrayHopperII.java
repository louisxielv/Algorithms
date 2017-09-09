package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/18/17.
 */
public class ArrayHopperII {
    public int minJump(int[] array) {
        // f represents the min step from index i to the end
        int[] f = new int[array.length];
        // initialize the last one to 0
        f[array.length - 1] = 0;

        // induction rule : f[i] = 1 + min(f[j]), j is the index which can be reached by i by one step
        for (int i = array.length - 2; i >= 0; i--) {
            int value = Integer.MAX_VALUE;
            for (int j = 1; j <= array[i] && i + j < array.length; j++) {
                if (f[i + j] == -1) {
                    continue;
                }
                value = Math.min(value, f[i + j]);
            }
            if (value == Integer.MAX_VALUE) {
                f[i] = -1;
            }
            else {
                f[i] = value + 1;
            }
        }


        return f[0];
    }

    public static void main(String[] args) {
        ArrayHopperII ah = new ArrayHopperII();
        int result = ah.minJump(new int[]{4,2,1,2,0,0});
        System.out.print(result);

    }
}
