package com.newton.code.interview;

public class MergeSortWithKDivide {
    public static void main(String[] args) {

        Integer[] nums = {2, 6, 1, 8, 3, 0, 5, 9, 4};
        int k = 3;

        mergeSortWithKDivide(nums, nums.length, k);

    }

    private static void mergeSortWithKDivide(Integer[] nums, int length, int k) {

        Integer[] refNums = new Integer[length];

        for (int i = 0; i < nums.length; i++) {
            refNums[i] = nums[i];
        }

        sortRecurssive(refNums, 0, length, nums, k);

        for (int i = 0; i < refNums.length; i++) {
            System.out.printf("\t" + refNums[i]);
        }

    }

    private static void sortRecurssive(Integer[] refNums, int start, int end, Integer[] nums, int k) {

        if (end - start < 2)
            return;

        int mid1 = start + ((end - start) / k);
        int mid2 = start + 2 * ((end - start) / k) + 1;

        sortRecurssive(refNums, start, mid1, nums, k);
        sortRecurssive(refNums, mid1, mid2, nums, k);
        sortRecurssive(refNums, mid2, end, nums, k);

        mergeArray(refNums, start, mid1, mid2, end, nums);

    }

    private static void mergeArray(Integer[] refNums, int start, int mid1, int mid2, int end, Integer[] nums) {

        int i = start, j = mid1, k = mid2, l = start;

        while ((i < mid1) && (j < mid2) && (k < end)) {
            if (nums[i].compareTo(nums[j]) < 0) {
                if (nums[i].compareTo(nums[k]) < 0)
                    refNums[l++] = nums[i++];

                else
                    refNums[l++] = nums[k++];
            } else {
                if (nums[j].compareTo(nums[k]) < 0)
                    refNums[l++] = nums[j++];
                else
                    refNums[l++] = nums[k++];
            }
        }

        while ((i < mid1) && (j < mid2)) {
            if (nums[i].compareTo(refNums[j]) < 0)
                refNums[l++] = nums[i++];
            else
                refNums[l++] = nums[j++];
        }


        while ((j < mid2) && (k < end)) {
            if (nums[j].compareTo(nums[k]) < 0)
                refNums[l++] = nums[j++];

            else
                refNums[l++] = nums[k++];
        }

        while ((i < mid1) && (k < end)) {
            if (nums[i].compareTo(nums[k]) < 0)
                refNums[l++] = nums[i++];
            else
                refNums[l++] = nums[k++];
        }

        while (i < mid1)
            refNums[l++] = nums[i++];

        while (j < mid2)
            refNums[l++] = nums[j++];

        while (k < end)
            refNums[l++] = nums[k++];

    }
}
