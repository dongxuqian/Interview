package com.dong.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConAndPro_queue {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    private void consumer(){
        new Thread(()->{
            while(true){
                Integer result = null;
                try {
                        result = queue.take();
                        System.out.println("消费成功，当前数量"+queue.size());



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }
    private void producer(){
        new Thread(()->{
            while(true){
                boolean res = false;
                try {

                        queue.put(1);
                        System.out.println("生产成功，当前数量"+queue.size());



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    public static void main(String[] args) {
        ConAndPro_queue conAndPro_queue = new ConAndPro_queue();
        conAndPro_queue.consumer();
        conAndPro_queue.producer();;
    }
}
