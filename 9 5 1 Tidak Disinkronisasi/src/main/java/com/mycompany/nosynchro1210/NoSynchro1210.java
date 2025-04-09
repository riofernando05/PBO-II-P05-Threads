/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nosynchro1210;

/**
 *
 * @author riofe
 */
class TwoStrings {
    static void print(String str1, String str2) {
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

    PrintStringsThread(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        TwoStrings.print(str1, str2);
    }
}

public class NoSynchro1210 {
    public static void main(String[] args) {
        new PrintStringsThread("Hello ", "there.");
        new PrintStringsThread("How are ", "you?");
        new PrintStringsThread("Thank you ", "very much!");
    }
}
