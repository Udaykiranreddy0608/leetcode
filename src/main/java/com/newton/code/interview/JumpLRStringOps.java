package com.newton.code.interview;

import java.util.ArrayList;
import java.util.List;


/*
 * R - right
 * L - left
 * J - jump (+2) of previous move
 * along with above instructions if you find any obstacles exit and if you have instructions beyond 10 exit.
 * if the final position is 10 then return true else false.
 */
public class JumpLRStringOps {
    public static void main(String[] args) {

        int[] obstacles_1 = {4, 6};
        int[] obstacles_2 = {2, 9, 4};

        String instructions_1 = "RRRJJRRR";
        String instructions_2 = "RRRLJ";
        String instructions_3 = "RRRJJRRRL";
        String instructions_4 = "RRRLRJJRRR";
        String instructions_5 = "RRRRRRRRRR";
        String instructions_6 = "RRJJJJ";
        String instructions_7 = "RLRRRJJRRLLJJJLRRRJJRRR";
        String instructions_8 = "RRRJJRLJR";
        String instructions_9 = "R";
        String instructions_10 = "RJJRRRJ";

        System.out.println(level(obstacles_1, instructions_1));
        System.out.println(level(obstacles_1, instructions_2));
        System.out.println(level(obstacles_1, instructions_3));
        System.out.println(level(obstacles_1, instructions_4));
        System.out.println(level(obstacles_1, instructions_5));
        System.out.println(level(obstacles_1, instructions_6));
        System.out.println(level(obstacles_1, instructions_7));
        System.out.println(level(obstacles_1, instructions_8));
        System.out.println(level(obstacles_1, instructions_9));
        System.out.println(level(obstacles_2, instructions_10));
/*
true
false
true
true
false
false
true
false
false
true
 */
    }

    public static boolean level(int[] obstacles_1, String instructions_1) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int x = 0; x < obstacles_1.length - 1; x++) {
            list.add(obstacles_1[x]);
        }

        char prevState = instructions_1.charAt(0);

        for (int i = 0; i < instructions_1.length(); i++) {
            char s = instructions_1.charAt(i);
            //System.out.println("Pos : " + i + "\t Char " + s);
            if (list.contains(cnt)) {
                return false;
            } else if (cnt == 10) {
                return true;
            }
            if (s == 'R') {
                cnt++;
                //System.out.println("Cnt at R " + cnt);
                prevState = s;

            } else if (s == 'L') {
                cnt--;
                //System.out.println("Cnt at L " + cnt);
                prevState = s;
            } else if (s == 'J') {
                if (prevState == 'R') {
                    cnt = cnt + 2;
                } else if (prevState == 'L') {
                    cnt = cnt - 2;
                }
                //System.out.println("Cnt at J " + cnt);
            }
        }
        //System.out.println("Final CNT : " + cnt);
        return cnt == 10;
    }
}
