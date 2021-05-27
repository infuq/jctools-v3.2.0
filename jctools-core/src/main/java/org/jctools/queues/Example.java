package org.jctools.queues;

public class Example {


    /*
-XX:MetaspaceSize=20m
-XX:MaxMetaspaceSize=20m
-XX:InitialHeapSize=120m
-XX:MaxHeapSize=120m
-XX:-UseCompressedClassPointers
*/


    public static void main(String[] args) throws Exception {

        // 书读百遍其意自现
        MpscUnboundedArrayQueue<Integer> queue = new MpscUnboundedArrayQueue<>(4);

        new Thread(() -> {
            while (true) {
                try {
                    for (int i = 1; i < 100; i++) {
                        Thread.sleep(3000);
                        queue.offer(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者-1").start();


        new Thread(() -> {
            while (true) {
                try {
                    for (int i = 200; i < 300; i++) {
                        Thread.sleep(2000);
                        queue.offer(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者-2").start();

        new Thread(() -> {
            while (true) {
                try {
                    for (int i = 300; i < 400; i++) {
                        Thread.sleep(1000);
                        queue.offer(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者-3").start();


        System.in.read();

/*

        new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer x = queue.poll();
                System.out.println("取出=" + x);
            }

        }, "消费者-1").start();
*/



    }

}
