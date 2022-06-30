package com.newton.code.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RankTeamsByVotes {
  public static void main(String[] args) {
    String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
    rankTeams2(votes);
  }


  private static String rankTeams2(String[] votes) {
    int numOfPlayers = votes[0].length();

    Map<Character, Integer[]> palyerRankCountMap = new HashMap<>();

    for (String vote : votes) {
      char[] chars = vote.toCharArray();
      for (int i = 0; i < numOfPlayers; i++) {
        if (palyerRankCountMap.containsKey(chars[i])) {
          palyerRankCountMap.get(chars[i])[i]++;
        } else {
          Integer[] arrInt = new Integer[numOfPlayers];
          for (int j = 0; j < numOfPlayers; j++) {
            arrInt[j] = 0;
          }
          arrInt[i]++;
          palyerRankCountMap.put(chars[i], arrInt);
        }
      }

    }

    char[] ans = votes[0].toCharArray();
    Character[] tmpArr = new Character[numOfPlayers];
    for (int i = 0; i < numOfPlayers; i++) {
      tmpArr[i] = ans[i];
    }

    Arrays.sort(tmpArr, new Comparator<Character>() {
      public int compare(Character a, Character b) {
        Integer[] pa = palyerRankCountMap.get(a);
        Integer[] pb = palyerRankCountMap.get(b);

        for (int i = 0; i < numOfPlayers; i++) {
          if (pa[i] > pb[i]) {
            return -1;
          } else if (pa[i] < pb[i]) {
            return 1;
          }
        }

        return a > b ? 1 : a < b ? -1 : 0;
      }
    });


    for (int i = 0; i < numOfPlayers; i++) {
      ans[i] = tmpArr[i];
    }
    return new String(ans);
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
