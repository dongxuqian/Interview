package com.dong.TopK;

import java.util.Arrays;
import java.util.Comparator;

public class TopK {
    public int partition(int left,int right, int[] nums){
        int i = left;
        int j = right;
        int temp = nums[left];
        while(i<j){
            while(i<j&&nums[j]>=temp){
                j--;
            }
            while(i<j&&nums[i]<=temp){
                i++;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        return i;
    }
    private void swap(int[] nums ,int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  = temp;
    }
    private void sort(int[] nums,int left, int right,int k){
            int i = partition(left, right, nums);
            if(i==nums.length-k){
                return;
            }else if(i< nums.length-k){
                sort(nums, i+1, right, k);
            }else{
                sort(nums, left, i-1, k);
            }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,1,24,12,5,12,3};
        TopK topK = new TopK();
        int k = 4;
//        topK.sort(nums,0, nums.length -1,k-1);
//        for(int i = 0;i<k;i++){
//            System.out.println(nums[i]);
//        }
        topK.sort(nums,0, nums.length-1, k);
        for(int i = 0;i<k;i++){
            System.out.println(nums[nums.length-i-1]);
        }


    }


}
