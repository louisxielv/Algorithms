import edu.nyu.lx463.questions.DFS.Nqueens;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LyuXie on 5/11/17.
 */
public class NqueensTest {
    @Test
    public void nqueens() throws Exception {
        Nqueens nq = new Nqueens();
        List<List<Integer>> result = nq.nqueens(4);
        List<List<Integer>> resultTest = new ArrayList<>();
        ArrayList<Integer> one  = new ArrayList<>();
        one.add(1);
        one.add(3);
        one.add(0);
        one.add(2);
        ArrayList<Integer> two  = new ArrayList<>();
        two.add(2);
        two.add(0);
        two.add(3);
        two.add(1);
        resultTest.add(one);
        resultTest.add(two);
        assertEquals(result, resultTest);
    }

}