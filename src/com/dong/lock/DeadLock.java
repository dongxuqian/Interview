package com.dong.lock;

public class DeadLock {
    Object A = new Object();
    Object B = new Object();
    private void DeadLock1(){
        new Thread(()->{
            synchronized (A){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("DeadLock1");
                }
            }
        }).start();

    }
    private  void DeadLock2(){
        new Thread(()->{
            synchronized (B){
                synchronized (A){
                    System.out.println("DeadLock2");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.DeadLock1();
        deadLock.DeadLock2();
    }
}
