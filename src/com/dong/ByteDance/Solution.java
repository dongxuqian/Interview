package com.dong.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        //System.out.println("aaa");
        dfs(0, num, new ArrayList<Integer>(), used);
        return ans;
    }

    private void dfs(int len, int[] num, ArrayList temp, boolean[] used) {
        if (len == num.length) {
            // System.out.println(temp.toString());
            ans.add(new ArrayList(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                temp.add(num[i]);
                dfs(len + 1, num, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,2};
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(num).toString());
    }
}

