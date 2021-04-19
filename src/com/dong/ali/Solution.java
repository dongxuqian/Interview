package com.dong.ali;

import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        for(int i = 0;i<num1;i++){
            int num2 = sc.nextInt();
            int[] num = new int[num2];
            for(int j = 0;j<num2;j++){
                num[j] = sc.nextInt();
            }
            int ans = 1;
            for(int k =1;k<num2;k++){
                if(k>1&&num[k]==num[k-2]){
                    continue;
                }else {
                    if (num[k] == num[k - 1]) {
                        num[k] += 1;
                        ans++;
                    } else if (num[k] > num[k - 1]) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
