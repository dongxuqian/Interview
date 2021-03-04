package com.dong.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducer {
    public static void main(String[] args) {
        ConsumerAndProducer consumerAndProducer = new ConsumerAndProducer();
        consumerAndProducer.consumer();
        consumerAndProducer.producer();
    }
    Queue<Integer> queue = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();
    private final int max = 10;
    private void consumer(){
        new Thread(()->{
            lock.lock();
            try{
                while(true){
                    while(queue.size()==0){
                        System.out.println("队列空");
                        try {
                            empty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    full.signal();
                    System.out.println("消费-1，当前数量"+queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }
        }).start();
    }
    private void producer(){
        new Thread(()->{
            lock.lock();
            try{
                while(true){
                    while(queue.size()==max){
                        try {
                            full.await();
                            System.out.println("队列满");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    empty.signal();
                    System.out.println("生产+1，当前数量"+queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }).start();

    }

}
