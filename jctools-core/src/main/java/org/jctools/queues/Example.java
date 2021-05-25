package org.jctools.queues;

public class Example {


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
        }).start();


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
        }).start();

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
        }).start();


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

        }).start();
*/



    }

}
