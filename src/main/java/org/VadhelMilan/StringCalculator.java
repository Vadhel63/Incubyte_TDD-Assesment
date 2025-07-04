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
        return parseInt(Numbers);
    }
}
