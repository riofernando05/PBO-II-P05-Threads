/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.countdowngui1210;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author riofe
 */
public class CountDownGUI1210 extends JFrame {
    JLabel label;
    
    CountDownGUI1210(String title) {
        super(title);
        label = new JLabel("Start count!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new Panel(), BorderLayout.WEST);
        getContentPane().add(label);
        setSize(300,300);
        setVisible(true);
    }
    void startCount() {
    try {
        for (int i = 10; i > 0; i--) {
            Thread.sleep(1000);
            label.setText("Count down complete.");
            Thread.sleep(1000);
        }
    } catch (InterruptedException ie) {
                
                }
        label.setText(Thread.currentThread().toString());
    }
        public static void main(String args[]) {
            CountDownGUI1210 cdg = new CountDownGUI1210("Count down GUI");
            cdg.startCount();
    }
    
}

