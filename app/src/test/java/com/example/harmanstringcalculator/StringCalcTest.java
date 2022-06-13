package com.example.harmanstringcalculator;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalcTest {
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("com.example.harmanstringcalculator.StringCalcTest");
    }
    //Test case for empty string
    @Test
    public void testForEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }
    //Test case for 1 string
    @Test
    public void testFor1Number() {
        assertEquals(1, StringCalculator.add("1"));
    }
    //Test case for 2 string
    @Test
    public void testFor2Numbers(){
        assertEquals(3, StringCalculator.add("1,2"));
    }
    //Test case for 3 string
    @Test
    public void testFor3Numbers(){
        assertEquals(6, StringCalculator.add("1,2,3"));
    }


    //Test case for negative numbers
    @Test
    public void testForNegNumber(){
        try {
            StringCalculator.add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }

        try {
            StringCalculator.add("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");

        }
    }

    //Test case for new line
    @Test
    public void testForNewLineEscapeSequence(){
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testAboveThousand(){
        assertEquals(2, StringCalculator.add("1000,2"));
    }

    @Test
    public void testForDelimiter(){
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

}
