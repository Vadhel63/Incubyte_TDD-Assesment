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
        if(Numbers.startsWith("//"))
        {
            int DelimiterEnd=Numbers.indexOf("\n");
            String DelimiterSection=Numbers.substring(2,DelimiterEnd);
            int CountChar=CountChar(Numbers,'[');
            if(CountChar>1) {
                if (Numbers.contains("[") && Numbers.contains("]")) {
                    ArrayList<String> delimiters = new ArrayList<>();
                    Matcher matcher = Pattern.compile("\\[(.)\\]").matcher(DelimiterSection);
                    while (matcher.find()) {
                        delimiters.add(Pattern.quote(matcher.group(1)));
                    }
                    delimiter = String.join("|", delimiters);
                }
                Numbers = Numbers.substring(DelimiterEnd + 1);

            }
            else
            {
                if(Numbers.startsWith("//["))
            {
                int endIdx=Numbers.indexOf("]\n");
                String AnyNumberOfDelimiter=Numbers.substring(3,endIdx);
                delimiter=Pattern.quote((AnyNumberOfDelimiter));
                Numbers=Numbers.substring(endIdx+2);
            }
            else {
                int IdxOfNl = Numbers.indexOf("\n");
                String CustomDelimiter = Numbers.substring(2, IdxOfNl);
                delimiter = Pattern.quote(CustomDelimiter);
                Numbers = Numbers.substring(IdxOfNl + 1);
            }
            }

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
