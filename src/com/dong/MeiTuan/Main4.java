package com.dong.MeiTuan;

import java.util.Scanner;

public class Main4 {
    static int  cost = Integer.MAX_VALUE;
    static  int k;
    static  int n;
    static  int[][] nums;
    static int[][] directions;
   static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        k = sc.nextInt();
        directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
         nums = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j]==1){
                    dfs(i,j,0);
                    cost = Math.min(cost,ans);
                    ans = Integer.MAX_VALUE;
                }
            }
        }
        if(cost==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(cost);
        }
    }
    private static void dfs(int i,int j,int temp){
        int cur = nums[i][j];
        if(cur>k){
            return ;
        }
        if(cur==k){
            ans = Math.min(ans,temp);
            return ;
        }
        for(int m = 0;m<4;m++){
            int new_i = i+directions[m][0];
            int new_j = j+directions[m][1];
            if(new_i>=0&&new_i<n&&new_j>=0&&new_j<n){
                if(nums[new_i][new_j]==cur+1){
                    int new_temp = temp+Math.abs(i-new_i)+Math.abs(j-new_j);
                    dfs(new_i,new_j,new_temp);
                }
            }
        }
    }
}
