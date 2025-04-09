/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.runnable1210;

/**
 *
 * @author riofe
 */
class PrintNameThread implements Runnable {
    Thread thread;
    PrintNameThread(String name) {
        thread = new Thread(this, name);
        thread.start();
    }
    @Override
    public void run() {
        String name = thread.getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(name);
        }
    }
}
public class Runnable1210 {
    public static void main(String args[]) {
        new PrintNameThread("A");
        new PrintNameThread("B");
        new PrintNameThread("C");
        new PrintNameThread("D");
    }
}