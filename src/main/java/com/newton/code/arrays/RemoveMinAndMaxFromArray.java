package com.newton.code.arrays;

public class RemoveMinAndMaxFromArray {
  public static void main(String[] args) {
    int[] nums = {48, -49, -67, 18, -59, -56, 47, -26, -24, -73, -96, 27, -2, -45};
    minimumDeletions(nums);
  }

  public static int minimumDeletions(int[] nums) {

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    int maxIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      }
      if (nums[i] < min) {
        min = nums[i];
        minIndex = i;
      }
    }
//
//    System.out.println("min : " + min);
//    System.out.println("max : " + max);
//    System.out.println("minIndex : " + (minIndex));
//    System.out.println("maxIndex : " + (maxIndex));
    //     [0,8,19,1,-4,-2,-3,5]
//         indexMin - 5
//         indexMax - 3
//           start to min of index -   3
//           max of index to end -  4
//            +   = 7
//             start to max of index =  5
//              min of index to end =   6

    int mIndex = Math.min(minIndex, maxIndex);
    int maIndex = Math.max(minIndex, maxIndex);


    int Ops1 = (mIndex + 1) + (nums.length - maIndex);
    int Ops2 = maIndex + 1;
    int Ops3 = nums.length - mIndex;

//    System.out.println("mIndex : " + mIndex);
//    System.out.println("maIndex : " + maIndex);
//
//    System.out.println("Ops1 : " + Ops1);
//    System.out.println("Ops2 : " + Ops2);
//    System.out.println("Ops3 : " + Ops3);

    return Math.min(Ops1, Math.min(Ops2, Ops3));
  }
}
