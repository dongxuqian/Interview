package com.dong.MeiTuan;


import java.util.*;

public class Main {
    static int k = 20210101;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        //Arrays.sort(ch);
        //str = ch.toString();
        int len = str.length();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0;i<str.length();i++){
            set.add(ch[i]);
            dfs(i+1,ch,set);
            set.remove(ch[i]);
        }
        System.out.println(ans+1);
    }
    private static void dfs(int index, char[] str, Set<Character> set){

        if(same(str.toString())){
            ans++;
        }

       if(!same(str.toString())||index>=str.length){
           return;
       }
        for(int i = index;i<str.length;i++){
                set.add(str[i]);
                dfs(i+1,str,set);
                set.remove(str[i]);
        }

    }
    private static boolean same(String str){
        int[] a = new int[256];
        int len = str.length();
        for(int i = 0;i<len;i++){
            int x = str.charAt(i)-'a';
            a[x]++;
            if(a[x]>1){
                return false;
            }
        }
        return true;
    }
}
