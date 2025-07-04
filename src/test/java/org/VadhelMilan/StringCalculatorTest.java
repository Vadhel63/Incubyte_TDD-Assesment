package org.VadhelMilan;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest{
    StringCalculator stringCalculator=new StringCalculator();
    @Test
    public void Empty_String_Should_Return_Zero()
    {
        assertEquals(0,stringCalculator.Add(""));
    }
    @Test
    public void  Single_Number_String_Should_Return_That_Number()
    {
        assertEquals(7,stringCalculator.Add("7"));
        assertEquals(77,stringCalculator.Add("77"));


    }

}