package com.newton.code.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UsersResourceAccess {

    public static void main(String[] argv) {

        String[][] logs1 = new String[][]{{"58523", "user_1", "resource_1"}, {"62314", "user_2", "resource_2"}, {"54001", "user_1", "resource_3"}, {"200", "user_6", "resource_5"}, {"215", "user_6", "resource_4"}, {"54060", "user_2", "resource_3"}, {"53760", "user_3", "resource_3"}, {"58522", "user_22", "resource_1"}, {"53651", "user_5", "resource_3"}, {"2", "user_6", "resource_1"}, {"100", "user_6", "resource_6"}, {"400", "user_7", "resource_2"}, {"100", "user_8", "resource_6"}, {"54359", "user_1", "resource_3"},};

        String[][] logs2 = new String[][]{{"300", "user_1", "resource_3"}, {"599", "user_1", "resource_3"}, {"900", "user_1", "resource_3"}, {"1199", "user_1", "resource_3"}, {"1200", "user_1", "resource_3"}, {"1201", "user_1", "resource_3"}, {"1202", "user_1", "resource_3"}};

        String[][] logs3 = new String[][]{{"300", "user_10", "resource_5"}};

        most_requested_resource(logs1);

    }

    private static void most_requested_resource(String[][] logs) {
        HashMap<String, List<Integer>> hashMap = new HashMap();
        int len = logs.length;
        for (int i = 0; i < len; i++) {
            String[] s = logs[i];
            List<Integer> timeS = hashMap.getOrDefault(s[2], new ArrayList<>());
            timeS.add(Integer.parseInt(s[0]));
            hashMap.put(s[2], timeS);
        }


        hashMap.forEach((k, v) -> {
//            Collections.sort(v, (res1, res2) -> {
//                return Long.compare(res1, res2);
//            });

            Collections.sort(v);
            System.out.println("Resource : " + k + "\t Max Number of times " + slidingWindow(v));
        });
    }

    private static int slidingWindow(List<Integer> timeStamps) { // sorted list
        int startIndex = 0;
        int endIndex = 0;
        long ans = 0;
        for (endIndex = 0; endIndex < timeStamps.size(); endIndex++) {
            long diff = timeStamps.get(endIndex) - timeStamps.get(startIndex);
            ans = Math.max(ans, endIndex - startIndex + 1);
            while (startIndex < timeStamps.size() && diff > 300) {
                diff = timeStamps.get(endIndex) - timeStamps.get(startIndex);
                startIndex += 1;
            }
        }
        return (int) ans;
    }

    public static HashMap<String, MinMax> getMinAndMaxLogs(String[][] logs) {
        HashMap<String, MinMax> map = new HashMap<String, MinMax>();
        int len = logs.length;
        for (int i = 0; i < len; i++) {

            String[] s = logs[i];
            //  System.out.println("s val "+ s.toString() );

            if (map.containsKey(s[1])) {

                MinMax curr = map.get(s[1]);


                if (Integer.parseInt(s[0]) > curr.getMax()) {
                    curr.setMax(Integer.parseInt(s[0]));
                } else if (Integer.parseInt(s[0]) < curr.getMin()) {
                    curr.setMin(Integer.parseInt(s[0]));
                }
                map.put(s[1], curr);


            } else {
                MinMax minMax = new MinMax();
                minMax.setMax(Integer.parseInt(s[0]));
                minMax.setMin(Integer.parseInt(s[0]));
                map.put(s[1], minMax);
            }

        }


        return map;

    }


}


class MinMax {

    private Integer min;

    private Integer max;

    public MinMax() {

    }

    public MinMax(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }


    public Integer setMin(Integer min) {
        return this.min = min;
    }

    public Integer setMax(Integer max) {
        return this.max = max;
    }

}



