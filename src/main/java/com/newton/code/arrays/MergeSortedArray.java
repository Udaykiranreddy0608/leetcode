package com.newton.code.arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        int[] nums1 = {7, 8, 9, 0, 0, 0}, nums2 = {1, 2, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int j=n-1;
        int i=m-1;

            while(i>=0 && j >=0){
                if(nums1[i] < nums2[j]){
                    nums1[--len]=nums2[j];
                    j--;
                }else{
                    nums1[--len]=nums1[i];
                    nums1[i]=0;
                    i--;
                }
            }
            while(j>=0){
                nums1[j]=nums2[j];
                j--;
            }

        for(int k=0;k<nums1.length;k++){
            System.out.println(nums1[k]);
        }
    }
}


