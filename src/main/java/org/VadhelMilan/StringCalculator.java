package org.VadhelMilan;


import static java.lang.Integer.parseInt;

public class StringCalculator
{
    public int Add(String Numbers)
    {
        if(Numbers.isEmpty())
        {
            return 0;
        }
        String [] nums=Numbers.split(",");

        int sum=0;
        for(String num:nums)
        {
            sum+=parseInt(num);
        }
        return sum;
    }
}
