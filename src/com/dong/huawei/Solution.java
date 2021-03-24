package com.dong.huawei;

public class Solution {
     static int ans = 0;
     static  int sum = 0;
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,6,7,9};
        for(int num :nums){
            sum+=num;
        }
        dfs(0,nums,0,0);
        System.out.println(ans);
    }
    private static void dfs(int index,int[] nums,int sum1,int sum2){
        if(index>nums.length){
                return;
        }
        if(sum1+sum2>sum){
            return ;
        }
        if(sum1>sum/2||sum2>sum/2){
            return;
        }
        if(index==nums.length){
            if(sum1==sum2){
                ans = Math.max(sum1,ans);
            }
            return;
        }
        dfs(index+1,nums,sum1+nums[index],sum2);
        dfs(index+1,nums,sum1,sum2+nums[index]);
        dfs(index+1,nums,sum1,sum2);
    }

}
