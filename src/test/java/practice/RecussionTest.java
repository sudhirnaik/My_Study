package practice;


import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class RecussionTest {




    @Test
    public void countOccurance() {
        int output = Recussion.countOccurance("abbbabccdab", "ab");
        assertEquals(3, output);
    }
}