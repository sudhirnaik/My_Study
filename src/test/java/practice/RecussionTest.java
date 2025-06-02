package practice;


import org.junit.Test;
import practice.Recurssion.Recurssion;

import static org.junit.Assert.assertEquals;



public class RecussionTest {




    @Test
    public void countOccurance() {
        int output = Recurssion.countOccurance("abbbabccdab", "ab");
        assertEquals(3, output);
    }
}