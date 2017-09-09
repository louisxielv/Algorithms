import edu.nyu.lx463.questions.sorting.QuickSort;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LyuXie on 5/9/17.
 */
public class QuickSortTest {
    @Test
    public void quickSort() throws Exception {
        QuickSort quickSort = new QuickSort();
        int[] result = quickSort.quickSort(new int[]{5,3,4,2,1});
        assertArrayEquals(result, new int[]{1,2,3,4,5});
    }

}