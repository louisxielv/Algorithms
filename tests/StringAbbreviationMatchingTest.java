import edu.nyu.lx463.questions.string.StringAbbreviationMatching;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LyuXie on 5/11/17.
 */
public class StringAbbreviationMatchingTest {
    @Test
    public void match() throws Exception {
        StringAbbreviationMatching sbm = new StringAbbreviationMatching();
        boolean result = sbm.match("sophisticated", "s11d");
        assertEquals(result, true);
        assertEquals(sbm.match("asdasd", "a1a"), false);
        assertEquals(sbm.match("apple", "2p1"), false);
    }

}