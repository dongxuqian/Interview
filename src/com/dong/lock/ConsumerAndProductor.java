package com.dong.lock;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerAndProductor {
    private final int max = 10;
    Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        ConsumerAndProductor consumerAndProductor = new ConsumerAndProductor();
        consumerAndProductor.consumer();
        consumerAndProductor.consumer();
        consumerAndProductor.producer();
        consumerAndProductor.producer();
        System.out.println("11111");
    }
    private void producer(){
        new Thread(()->{
            while(true){
                synchronized (queue){
                    while(queue.size()==max){
                        //queue.notify();
                        System.out.println("队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notifyAll();
                    System.out.println("生产+1，当前数量为"+queue.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void consumer() {
        new Thread(()->{
            while(true){
                synchronized (queue){
                    while(queue.size()==0){
                       // queue.notify();
                        System.out.println("队列空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notifyAll();
                    System.out.println("消费-1，当前数量为"+queue.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
