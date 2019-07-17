package com.udemy.JunitCourse.helper;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ArraysCompareTest {


    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testArraySort_NullArrayOption1() {
        int[] numbers = null;
        try {
            Arrays.sort(numbers);
        } catch (NullPointerException e) {

        }
    }

    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArrayOption2() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

//    fails
//    @Test(timeout=1000)
//    public void testSort_Performance() {
//        int array[] = {12, 23, 4};
//        for(int i=1; 1<=1000000; i++) {
//            array[0] = i;
//            Arrays.sort(array);
//        }
//    }

}
