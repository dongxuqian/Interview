package com.dong.wangyi;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = Integer.valueOf(sc.nextLine());
        int num2 = Integer.valueOf(sc.nextLine());
        String strs = sc.nextLine();
        String[] str = strs.split(" ");
        int[] nums = new int[str.length];
        int index = 0;
        for(String s:str){
            nums[index++] = Integer.valueOf(s);
        }
        System.out.println(str.length);
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int a:nums){
            for(int i = sum;i>=a;i--){
                dp[i] = dp[i]|dp[i-a];
            }
        }
        boolean flag = false;
        for(int i = num1;i<=sum;i++){
            if(dp[i]){
                System.out.println(i-num2);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println(-1);
        }

    }
}
