package com.dong.ali;

import java.util.*;
import java.lang.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> dep = new ArrayList<>();
//        System.out.println(n);
//        System.out.println(m);
        for(int i = 0;i<n;i++){
            dep.add(new ArrayList<Integer>());
        }
        for(int i = 0 ;i<m;i++){
                int p = sc.nextInt();
                int q = sc.nextInt();
//            System.out.println(p);
//            System.out.println(q);
            if(dep.get(p).contains(q)){
                continue;
            }else
            dep.get(p).add(q);
        }
        int count = 0;
        count = sc.nextInt();
        System.out.println(count);
        for(int i = 0;i<count;i++){
            int  ans = 10000;
            int p  = sc.nextInt();
            int q = sc.nextInt();
            dfs(dep,p-1,q-1,0,ans);
        }

    }
    private static void dfs(List<List<Integer>> dep,int num1,int num2,int time,int ans){
        //System.out.println(num1);
        //System.out.println(num2);

        if(dep.get(num1).contains(num2)){
            ans = Math.min(ans,time+1);
            System.out.println(ans);
            return;
        }
        for( int i : dep.get(num1)) {
            if(i>=dep.size()){
                return;
            }
            System.out.println(i);
            dfs(dep,i,num2,time+1,ans);
        }
        return;
    }
}