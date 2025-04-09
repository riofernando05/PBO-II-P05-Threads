/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interthread1210;

/**
 *
 * @author riofe
 */
class SharedData {
    private int data;

    synchronized void set(int value) {
        System.out.println("Generate " + value);
        data = value;
    }
    
    synchronized int get() {
        System.out.println("Get " + data);
        return data;
    }
}

class Producer implements Runnable {
    private SharedData sd;

    Producer(SharedData sd) {
        this.sd = sd;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.set((int) (Math.random() * 100));
        }
    }
}

class Consumer implements Runnable {
    private SharedData sd;

    Consumer(SharedData sd) {
        this.sd = sd;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sd.get();
        }
    }
}

public class InterThread1210 {
    public static void main(String[] args) throws Exception {
        SharedData sd = new SharedData();
        new Producer(sd);
        new Consumer(sd);
    }
}
