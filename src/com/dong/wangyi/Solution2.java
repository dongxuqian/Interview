package com.dong.wangyi;

import java.util.Scanner;

public class Solution2 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[]  nums = new int[num];
        for(int i = 0;i<num;i++){
                nums[i] = sc.nextInt();
        }
        if(num<5){
            System.out.println(ans);
        }
        int right = 0;
        int left = 0;
        int flag = 0;
        boolean twice = false;
        while(right<num-1){
            if(flag==0){
                if(nums[left]<nums[left+1]){
                    flag  = 1;
                    right++;
                    continue;
                }else{
                    flag = 0;
                    right++;
                    continue;
                }

            }else if(nums[right]<nums[right+1]){
                if(flag == 1){
                    if(!twice){
                        twice = true;
                        right++;
                    }else{
                        ans = Math.max(ans,right-left+1);
                        left = right;
                        twice = false;
                    }
                }else{
                    if(twice){
                       right++;
                       twice = false;
                       flag = 1;
                    }else{
                        if(right==1){
                            right++;
                            flag = 1;
                        }else{
                            ans = Math.max(ans,right-left+1);
                            left  = right;
                            flag = 0;
                        }
                    }
                }
            }else if(nums[right]>nums[right+1]){
                if(flag==0){
                    if(!twice){
                        twice = true;
                        right++;
                        ans = Math.max(ans,right-left+1);
                    }else{
                        ans = Math.max(ans,right-left+1);
                        left = right;
                        twice = false;
                    }
                }else{
                    if(twice){
                        right++;
                        twice = false;
                        flag = 0;
                        ans = Math.max(ans,right-left+1);
                    }else{
                        if(right==1){
                            right++;
                            flag = 1;

                        }else{
                            ans = Math.max(ans,right-left+1);
                            left  =right;
                            flag = 0;
                        }
                    }
                }
            }
        }

        if(ans==0){
            System.out.println(0);
        }else{
            System.out.println(ans);
        }

    }
}
