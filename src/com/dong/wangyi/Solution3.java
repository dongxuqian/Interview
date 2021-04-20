package com.dong.wangyi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        int num = sc.nextInt();
        //if("null".equals(strs[0])){
            //System.out.println(new int[0].toString());
            System.out.println("["+Integer.valueOf(strs[0])+","+num+ "]");
        //}
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        TreeNode head = root;
        int i = 1;
        Queue<String> queue = new LinkedList<>();

        queue.add(strs[0]);

//        while(!queue.isEmpty()){
//            String str = queue.poll();
//            if("null".equals(str)){
//
//            }else{
//
//            }
//        }
//        int num = sc.nextInt();

        System.out.println();
    }

}
class TreeNode{
    int value;
    int left;
    int right;
    TreeNode(int val){
        this.value = val;
    }
}
