package com.dong.tengxun;

import java.util.*;


   class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;

    }
  }


   class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 你需要返回m个指针，第i个指针指向一条链，表示第i个问题的答案
     * @param root TreeNode类 指向链表树的根
     * @param b int整型一维数组 表示每个问题是什么
     * @return ListNode类一维数组
     */
    ListNode[] ans;
    int index;
    ListNode cur ;
    List<Integer>[] aa;
    public ListNode[] solve (TreeNode root, int[] b) {
        // write code here
         ans = new ListNode[b.length];
         aa = new ArrayList[b.length];
        index = 0;
        for(int k:b){
            cur = new ListNode(root.val);
            ListNode temp = cur;
            List<Integer> list =  new ArrayList<>();
            list.add(root.val);
             helper(root,1,k,list);
            for(int t :aa[0]){
                System.out.println(t);
            }
        }
        return ans;

    }
    private void helper(TreeNode root,int length,int k,List<Integer> list){
        if(k==length){
            aa[index++] = new ArrayList<>(list);
            return;
        }
        if(k<length){
            return;
        }
        if(root.left!=null){
            list.add(root.left.val);
            helper(root.left,length*2,k,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            list.add(root.right.val);
            helper(root.right,2*length+1,k,list);
            list.remove(list.size()-1);
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        ListNode[] res = solution.solve(root,new int[]{5} );
//        for(ListNode p:res){
//            System.out.println(p.val);
//        }
        //System.out.println(res[0].next.val);

    }
}