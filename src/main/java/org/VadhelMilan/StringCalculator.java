package org.VadhelMilan;


import java.util.ArrayList;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator
{
    public int SumOfNumbers(String[] nums)
    {
        ArrayList<String> neg=new ArrayList<>();
        int sum=0;
        for(String num:nums)
        {
            int val=parseInt(num);
            if(val<0)
            {
                neg.add(num);
            }

            sum+=val;
        }
        if(!neg.isEmpty())
        {
            throw new IllegalArgumentException("negative not allowed: " + String.join(",", neg));
        }
        return sum;
    }
    public int Add(String Numbers)
    {
        if(Numbers.isEmpty())
        {
            return 0;
        }

        String delimiter="[,\n]";
        if(Numbers.startsWith("//"))
        {
            int IdxOfNl=Numbers.indexOf("\n");
            String CustomDelimiter=Numbers.substring(2,IdxOfNl);
            delimiter = Pattern.quote(CustomDelimiter);
            Numbers=Numbers.substring(IdxOfNl+1);

        }
        String [] nums=Numbers.split(delimiter);

        return SumOfNumbers(nums);
    }
}
