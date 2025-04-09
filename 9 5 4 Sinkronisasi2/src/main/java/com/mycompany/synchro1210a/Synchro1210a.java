/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.synchro1210a;

/**
 *
 * @author riofe
 */
class TwoStrings {
    synchronized void print(String str1, String str2) {
        System.out.print(str1);
        try {
            Thread.sleep(500); 
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt(); 
        }
        System.out.println(str2);
    }
}

class PrintStringsThread implements Runnable {
    private Thread thread;
    private String str1, str2;
    private TwoStrings ts;

    PrintStringsThread(String str1, String str2, TwoStrings ts) {
        this.str1 = str1;
        this.str2 = str2;
        this.ts = ts;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (ts) {
            ts.print(str1, str2);
        }
    }
}

public class Synchro1210a {
    public static void main(String[] args) {
        TwoStrings ts = new TwoStrings();
        new PrintStringsThread("Hello ", "there.", ts);
        new PrintStringsThread("How are ", "you?", ts);
        new PrintStringsThread("Thank you ", "very much!", ts);
    }
}
