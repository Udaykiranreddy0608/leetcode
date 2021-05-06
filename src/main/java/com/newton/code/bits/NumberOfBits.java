package com.newton.code.bits;

public class NumberOfBits {
  public static void main(String[] args) {
    int n = 35;
    System.out.println(hammingWeight(n));
  }

  public static int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        bits++;
      }
      mask <<= 1;
    }

    return bits;
  }

  public static int hammingWeight2(int n) {
    int bits = 0;
    if (n != 0) {
      bits++;
      n &= (n - 1);
    }
    return bits;
  }
}
