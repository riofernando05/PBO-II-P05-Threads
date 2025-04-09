/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.latihan;

/**
 *
 * @author riofe
 */
import javax.swing.*;
import java.awt.*;

public class Latihan extends JFrame {
    private String message = "Zzzzzzzzzz...";
    private int x = 0; 

    public Latihan() {
        setTitle("Moving Banner");
        setSize(600, 250);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new BannerPanel());

        Timer timer = new Timer(50, e -> repaint());  // Memanggil repaint setiap 100 ms
        timer.start();
    }

    class BannerPanel extends JPanel {
        public BannerPanel() {
            setBackground(Color.white); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setFont(new Font("Calibri", Font.PLAIN, 30));
            g.setColor(Color.blue);  
            g.drawString(message, x, 50);
            
            x += 5;
            
            if (x > getWidth()) {
                x = -getFontMetrics(getFont()).stringWidth(message);
            }
        }
    }

    public static void main(String[] args) {
        Latihan latihan = new Latihan();
        latihan.setVisible(true);
    }
}
