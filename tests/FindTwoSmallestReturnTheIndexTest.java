import edu.nyu.lx463.company.bloomberg.phone.FindTwoSmallestReturnTheIndex;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LyuXie on 5/9/17.
 */
public class FindTwoSmallestReturnTheIndexTest {
    @Test
    public void findTwoSmallest() throws Exception {
        FindTwoSmallestReturnTheIndex ft = new FindTwoSmallestReturnTheIndex();
        int[] result1 = ft.findTwoSmallest(new int[]{1,2,3,4});
        assertArrayEquals(result1, new int[]{0, 1});

        int[] result2 = ft.findTwoSmallest(new int[]{5,3,6,11,1});
        assertArrayEquals(result2, new int[]{4, 1});


        int[] result3 = ft.findTwoSmallest(new int[]{8, 5, 7, 9});
        assertArrayEquals(result3, new int[]{1, 2});


        int[] result4 = ft.findTwoSmallest(new int[]{10, 8, 9, 7});
        assertArrayEquals(result4, new int[]{3, 1});

    }

}