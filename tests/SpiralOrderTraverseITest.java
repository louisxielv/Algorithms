import edu.nyu.lx463.questions.recursion.SpiralOrderTraverseI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LyuXie on 5/12/17.
 */
public class SpiralOrderTraverseITest {
    @Test
    public void spiral() throws Exception {
        SpiralOrderTraverseI sot= new SpiralOrderTraverseI();
        int[][] matrix = {{1,2, 3, 4},
                         { 5,6, 7, 8},
                         { 9,10,11,12},
                         {13,14,15,16}};

        List<Integer> result = sot.spiral(matrix);
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(8);
        test.add(12);
        test.add(16);
        test.add(15);
        test.add(14);
        test.add(13);
        test.add(9);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(11);
        test.add(10);


        assertEquals(result, test);

    }

}