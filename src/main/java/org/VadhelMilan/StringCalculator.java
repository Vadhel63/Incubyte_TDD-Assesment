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
        if(Numbers.contains(","))
        {
            String [] nums=Numbers.split(",");
            return parseInt(nums[0])+parseInt((nums[1]));
        }
        return parseInt(Numbers);
    }
}
