package com.udemy.JunitCourse.helper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SpringHelperTest {

    StringHelper helper;

    @Before
    public void before() {
        helper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions(){
        String actual = helper.truncateAInFirst2Positions("AACD");
        String expected = "CD";
        assertEquals(expected, actual);
    }

    @Test
    public void testTruncateAInFirst2Positions2_AInFirstPosition() {
        String actual = helper.truncateAInFirst2Positions(("ACD"));
        String expected = "CD";
        assertEquals(expected, actual);
    }

    @Test
    public void testAreFirstAndLast2CharactersTheSame_BasicNegativeScenario() {
        boolean actual = helper.areFirstAndLast2CharactersTheSame("ABCD");
        boolean expectedValue = false;
        assertEquals(expectedValue, actual);
//        you can test this scenario with assertEquals or using assertFalse:
        assertFalse(actual);
//        this is exactly the same as the assertion above:
        assertFalse(helper.areFirstAndLast2CharactersTheSame("ABCD"));

    }

    @Test
    public void testAreFirstAndLast2CharactersTheSame_BasicPositiveScenario() {
        boolean actual = helper.areFirstAndLast2CharactersTheSame("ABAB");
        boolean expected = true;
        assertEquals(expected, actual);
//        or:
        assertTrue(helper.areFirstAndLast2CharactersTheSame("ABAB"));
//        or
        assertTrue(actual);
    }

//    TODO
//    add tests for scenarios "AB", "A"

}
