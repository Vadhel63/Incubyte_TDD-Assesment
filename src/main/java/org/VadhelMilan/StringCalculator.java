package org.VadhelMilan;


import java.util.ArrayList;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator
{
    private  int count=0;
    public int SumOfNumbers(String[] nums)
    {

        int sum=0;
        for(String num:nums)
        {
            sum+=parseInt(num);
        }

        return sum;
    }
    public  void ContainNegative(String [] nums)
    {
        ArrayList<String> neg=new ArrayList<>();
        for(String num:nums)
        {
            if(parseInt(num)<0)
            {
                neg.add(num);
            }
        }
        if(!neg.isEmpty())
        {
            throw new IllegalArgumentException("negative not allowed: " + String.join(",", neg));
        }
    }
    public int Add(String Numbers)
    {
        count++;
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
        ContainNegative(nums);
        return SumOfNumbers(nums);
    }
    public int GetCalledCount()
    {
        return count;
    }
}
