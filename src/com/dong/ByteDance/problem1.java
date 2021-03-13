package com.dong.ByteDance;

public class problem1 {
    public static void main(String[] args) {
        int[] count = new int[]{1, 5, 2, 3, 7};
        int[] dp = new int[5];
        dp[0] = count[0];
        int ans = 0;
        for (int i = 1; i < 5; i++) {
            dp[i] = Math.max(dp[i - 2] + count[i], dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
