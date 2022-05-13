package com.newton.code.arrays;

public class FirstAndLastIndexOfNum {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7};
        int target = 4;

        if (isTargetExists(arr, target)) {

        }
        System.out.println(getLeftIndex(arr, target));
        System.out.println(getRightIndex(arr, target));

    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{getLeftIndex(nums, target), getRightIndex(nums, target)};
    }

    private static boolean isTargetExists(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] == target) {
                return true;
            }
        }
        return false;
    }

    public static int getLeftIndex(int[] arr, int targetNum) {
        int findIndex = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= targetNum) {
                left = mid + 1;
                findIndex = left;
            } else if (arr[mid] >= targetNum) {
                right = mid - 1;
            }
        }
        return findIndex;
    }

    public static int getRightIndex(int[] arr, int targetNum) {
        int left = 0;
        int findIndex = -1;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= targetNum) {
                left = mid + 1;
            } else if (arr[mid] > targetNum) {
                right = mid - 1;
                findIndex = right;
            }
        }
        return findIndex;
    }


}
