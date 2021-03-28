package com.dong.wangyi;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        int sum = 0;

        for(int i = 0;i<num;i++){
            nums[i] = sc.nextInt();
            sum+=nums[i];
        }
        //System.out.println(sum);
        if(sum<6){
            System.out.println(-1);
        }
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int a:nums){
            for(int i = sum;i>=a;i--){
                dp[i] = dp[i]|dp[i-a];
            }
        }
        int i = sum;
//        while(i>=6){
//            sum = sum-sum%6;
//            if()
//        }
        boolean flag = false;
        for(;i>=6;i--){
            if(i%6==0&&dp[i]){
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println(-1);
        }

    }
}
