package com.dong.tengxun;

import java.util.*;
public class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int size = sc.nextInt();
            int q= sc.nextInt();
            int[] prices = new int[size];
            int sum = 0;
            for(int k= 0;k<size;k++){
                prices[k] = sc.nextInt();
                sum+=prices[k];
            }

            //Arrays.sort(prices);

            boolean[] dp = new boolean[sum+1];
            dp[0] = true;
            for(int price:prices){
                for(int  k = sum;k>=0;k--){
                    if(price<=k){
                        dp[k] = dp[k]|dp[k-price];
                    }
                }
            }
            for(int k = sum;k>=0;k--){
                if(dp[k]&&k%q==0){
                    System.out.println(sum-k);
                    break;
                }
            }

        }

    }
}