package org.VadhelMilan;


import java.util.ArrayList;
import java.util.regex.Matcher;
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
            int val=parseInt(num);
            if(val<=1000)
                sum+=val;
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
    public int CountChar(String Numbers,char target)
    {
        int CountChar=0;
        for(int i=0;i<Numbers.length();i++)
        {
            if(Numbers.charAt(i)==target)
            {
                CountChar++;
            }
        }
        return CountChar;
    }
    public int Add(String Numbers)
    {
        count++;
        if(Numbers.isEmpty())
        {
            return 0;
        }

        String delimiter="[,\n]";
        if (Numbers.startsWith("//")) {
            int delimiterEnd = Numbers.indexOf("\n");
            String delimiterSection = Numbers.substring(2, delimiterEnd);
            Numbers = Numbers.substring(delimiterEnd + 1);

            ArrayList<String> delimiters = new ArrayList<>();

            // Case 1: multiple delimiters With Any No .of Characters
            if (delimiterSection.contains("[") && delimiterSection.contains("]")) {
                Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
                while (matcher.find()) {
                    delimiters.add(Pattern.quote(matcher.group(1)));
                }
            }
            // Case 2: single-character delimiter
            else {
                delimiters.add(Pattern.quote(delimiterSection));
            }

            delimiter = String.join("|", delimiters);
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
