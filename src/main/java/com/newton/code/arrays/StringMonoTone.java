package com.newton.code.arrays;

public class StringMonoTone {

  public static void main(String[] args) {
    String s = "010110";
    findMonoTone2(s);

    // 0000000000001
  }

  private static int findMonoTone2(String S) {

    int N = S.length();
    int[] P = new int[N + 1];
    for (int i = 0; i < N; ++i) {
      P[i + 1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);
    }

    int ans = Integer.MAX_VALUE;
    for (int j = 0; j <= N; ++j) {
      ans = Math.min(ans, P[j] + N - j - (P[N] - P[j]));
    }

    return ans;
  }

  private static int findMonoTone(String s) {
    int countOfZero = 0;
    int countOfOne = 0;
    boolean startCounting = false;
    int j = s.length() - 1;
    for (; j >= 0; j--) {
      if (s.charAt(j) == '0') {
        break;
      }
    }


    for (int i = 0; i <= j; i++) {

      if (s.charAt(i) == '1') {
        startCounting = true;
      }

      if (startCounting) {
        if (s.charAt(i) == '1') {
          countOfOne++;
        } else if (s.charAt(i) == '0') {
          countOfZero++;
        }
      }
    }
    System.out.println("countOfZero : " + countOfZero);
    System.out.println("countOfOne : " + countOfOne);

    if (countOfOne < countOfZero) {
      return countOfOne;
    }

    return countOfZero;
  }
}
