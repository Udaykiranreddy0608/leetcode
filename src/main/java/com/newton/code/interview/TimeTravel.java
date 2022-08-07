package com.newton.code.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeTravel {

    private static final HashMap<String, TreeMap<Long, String>> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        put("Akshat", "India");
        Thread.sleep(1L);
        put("Akshat", "India");
        Thread.sleep(1L);
        put("Akshat", "India");
        Thread.sleep(1L);
        put("Akshat", "Delhi");
        Thread.sleep(1L);
        put("Verma", "Gurgaon");
        Thread.sleep(1L);
        put("Verma", "Gurgaon");
        Thread.sleep(10L);
        put("Akshat", "Hyderabad");

        map.forEach((k, v) -> {
            v.forEach((a, b) -> {
                System.out.println("Name : " + k + "\t Time : " + a + "\t Place : " + b);
            });
        });

        get("Akshat", getTime() - 50);
        get("Akshat", getTime() - 80);
        get("Akshat", getTime() - 100);
        get("Akshat", getTime() - 150);
        get("Akshat", getTime() - 170);

    }

    private static String get(String name, long timeInMilli) {
        TreeMap<Long, String> map1 = map.get(name);
        Map.Entry<Long, String> res = map1.floorEntry(timeInMilli);
        if (res == null) {
            System.out.println(
                    "Name : " + name + "\tGiven time : " + timeInMilli + "\t Obtained time : " + "\t City :" + null);
            return null;
        }
        System.out.println(
                "Name : " + name + "\tGiven time : " + timeInMilli + "\t Obtained time : " + res.getKey() + "\t City :" +
                        res.getValue());
        return res.getValue();
    }

    public static void put(String name, String city) {
        TreeMap<Long, String> map1 = map.getOrDefault(name, new TreeMap<>());
        map1.put(getTime(), city);
        map.put(name, map1);
    }

    public static Long getTime() {
        return System.currentTimeMillis();
    }
}
