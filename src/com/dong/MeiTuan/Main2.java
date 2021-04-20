package com.dong.MeiTuan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int jing = 0;
        int wei = 0;
        for(int i = 0;i<n;i++){
            int tx = sc.nextInt();
            int angle = sc.nextInt();
            if(tx==0){
                jing++;
            }else{
                wei++;
            }
        }
        int res = (2*jing)*(wei+1);
        if(jing==0){
            System.out.println(wei+1);
        }else{
            System.out.println(res);
        }
    }
}
