package com.newton.code.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Given a set of intervals identify if we can  merge the possible intervals and minimize them
 *
 * Eg: Input - (2,4) (3,6) (8,9)  Output - (2,6) (8,9)
 *
 */
public class MergeIntervals {
  public static void main(String[] args) {
    int[][] intervals = {{2, 4}, {3, 6}, {1, 2}, {8, 9}};
    int[][] res = merge(intervals);

    for (int[] re : res) {
      System.out.println(re[0] + "\t" + re[1]);
    }

  }

  private static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    LinkedList<int[]> res = new LinkedList<>();
    for (int[] interval : intervals) {

      if (res.isEmpty() || res.getLast()[1] < interval[0]) {
        res.add(interval);
      } else {
        res.getLast()[1] = Math.max(interval[1], res.getLast()[1]);
      }
    }
    return res.toArray(new int[res.size()][]);
  }
}
