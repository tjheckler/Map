package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TimeZoneDemo
{
    public static void main(String[] args)
    {
        TimeZoneDemo timeZoneDemo = new TimeZoneDemo();
        timeZoneDemo.demo();
        System.out.println("Difference in Time zones is "+timeZoneDemo.getTimeDiff("PST","EST"));

    }
    Map <String, Integer> timeZone = new HashMap<>();
    public void demo()
    {

        timeZone.put("EST", -5);
        timeZone.put("CST", -6);
        timeZone.put("MST", -7);
        timeZone.put("PST", -8);
        timeZone.put("GMT", 0);
    }
   public int getTimeDiff(String zone1, String zone2)
    {
        int diffTime =  timeZone.get(zone1) - timeZone.get(zone2);
        return diffTime;

    }
}