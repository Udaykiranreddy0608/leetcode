package com.newton.code.arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 7, 8, 10, 11, 15};

        int target = 20;
        int index = search(nums, target);
        if (index == -1) {
            System.out.println("Number not found");
        } else {
            System.out.println("Number found at index : " + index);
        }
    }

    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                // if mid value in sorted array is greater than target then we can ignore right part
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }
        return -1;
    }
}