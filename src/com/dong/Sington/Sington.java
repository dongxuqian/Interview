package com.dong.Sington;

public class Sington {
    private volatile Object object;
    private Sington(){

    }
    public Object getInstance(){
        if(object==null){
            synchronized (this){
                if(object==null){
                    object = new Object();
                }
            }
        }
        return object;
    }

    public static void main(String[] args) {
        Sington sington = new Sington();
        System.out.println(sington.getInstance()==sington.getInstance());
    }
}
