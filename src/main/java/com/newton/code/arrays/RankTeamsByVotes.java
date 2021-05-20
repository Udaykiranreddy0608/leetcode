package com.newton.code.arrays;

public class RankTeamsByVotes {
    public static void main(String[] args) {
        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        rankTeams(votes);
    }

    private static String rankTeams(String[] votes) {

        if (votes.length == 1 || votes[0].length() == 1) {
            return votes[0];
        }
        int[] cal = new int[26];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            for (int i1 = 0; i1 < votes.length; i1++) {
                char c = votes[i1].charAt(i);
                cal[c - 'A']++;
            }
            int maxRes = Integer.MIN_VALUE;
            int maxValPos = 0;
            for (int i1 = 0; i1 < cal.length; i1++) {
                if (cal[i1] > maxRes) {
                    maxRes = cal[i1];
                    maxValPos = i1;
                }
            }
            char ch = (char) (maxValPos + 'A');
            stringBuilder.append(ch);
            cal = new int[26];
            System.out.println(ch);
        }

        return stringBuilder.toString();
    }
}
