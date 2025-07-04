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
    @Test
    public void Two_Number_String_Should_Return_SumOf_That_Two_Numbers()
    {
        assertEquals(8,stringCalculator.Add("3,5"));
        assertEquals(12,stringCalculator.Add("7,5"));

    }

    @Test
    public void Unknown_Amount_Of_Number_String_Should_Return_SumOf_Those_Numbers()
    {
        assertEquals(12,stringCalculator.Add("1,3,6,2"));
        assertEquals(29,stringCalculator.Add("5,7,8,9"));

    }
    @Test
    public void  NewLine_As_Delimiter_Must_Work()
    {
        assertEquals(6,stringCalculator.Add("4\n2"));
        assertEquals(7,stringCalculator.Add("2\n4,1"));
    }

}