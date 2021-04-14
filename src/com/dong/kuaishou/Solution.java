package com.dong.kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    ArrayList<ArrayList<Integer>> ans;

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>>  list = solution.subsets(new int[]{1,2,3});
        for( List a:list){
            System.out.println(a);
        }
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ans = new ArrayList<>();
        Arrays.sort(S);
        dfs(0,S,new ArrayList<Integer>());
        return ans;
    }
    private void dfs(int index,int[] nums,ArrayList<Integer> temp){
        ans.add(new ArrayList<Integer>(temp));
        for(int i = index;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}
