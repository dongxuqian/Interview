package com.dong.zhuangxiang拆箱;

public class test {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        int h = 1;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(a.equals(h));
        //System.out.println(g==c); 不可比较
        // -128 到 127 有缓存
        //涉及到运算符了 会自动 intValue（）； 自动拆箱
        //包装类 的“==”运算在不遇到算术运算的情况下不会自动拆箱，以及它们equals()方法不处理数据转型的关系

    }
}
