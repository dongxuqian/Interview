package com.dong.StringTest;

public class test {
    public static void main(String[] args) {
        String s1 = "aasdasd";
        String s2 = new StringBuilder("a").append("asdasd").toString();
        String s4 = s1.intern();
        String s3 = new String("a");
        String s5 = s3.intern();
        String s6 = new StringBuilder().append("java").toString();
        String s7 = s6.intern();
        System.out.println(s2.intern()==s1);
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1==s4);
        System.out.println(s1==s5);
        System.out.println(s6==s7);
    }
}
