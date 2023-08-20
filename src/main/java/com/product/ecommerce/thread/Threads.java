package com.product.ecommerce.thread;

public class Threads extends Thread {
    public void run(){
        System.out.println("thread is running");
    }

    public static void main(String[] args) {
        Threads threads=new Threads();
        threads.start();
        threads.run();
        System.out.println("its running");
    }

}
