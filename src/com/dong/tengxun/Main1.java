package com.dong.tengxun;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[num];
        int index= 0;
        for(int i = 0;i<num;i++) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            nums[index++] = in.nextInt();
        }
        System.out.println(nums.length);
        for(int i = 0;i<nums.length;i++){
            int  n = nums[i];
            int[] dp = new int[n+1];
            dp[n] = 0;
            for(int k = n;k>0;k--){
                dp[k-1] = dp[k]+1;
                if((k-1)*2<=n){
                    dp[k-1] = Math.min(dp[k-1],dp[(k-1)*2]+1);
                }
                if((k-1)*3<=n){
                    dp[k-1] = Math.min(dp[k-1],dp[(k-1)*3]+1);
                }
            }
            System.out.println(dp[0]);
        }
    }
}