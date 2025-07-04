package org.VadhelMilan;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    @Test
    public void Different_Delimiter_Should_also_Work()
    {
        assertEquals(3,stringCalculator.Add("//;\n1;2"));
        assertEquals(12,stringCalculator.Add("//.\n7.5"));
        assertEquals(15,stringCalculator.Add("//:\n8:7"));


    }
    @Test
    public void Single_Negative_Number_Throws_Exception()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()->{stringCalculator.Add("-1,2\n3");});
        assertEquals("negative not allowed: -1",exception.getMessage());

    }
    @Test
    public void Multiple_Negative_Numbers_Throws_Exception()
    {
Exception ex1=assertThrows(IllegalArgumentException.class,()->{stringCalculator.Add("-2,4,-5");});
      assertEquals("negative not allowed: -2,-5",ex1.getMessage());
        Exception ex2=assertThrows(IllegalArgumentException.class,()->{stringCalculator.Add("-1,-4,5,-7");});
        assertEquals("negative not allowed: -1,-4,-7",ex2.getMessage());
    }

}