/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ttt;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndCredits extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final int PANEL_WIDTH = 400;
    private static final int PANEL_HEIGHT = 400;
    private static final int LINE_HEIGHT = 40;
    private static final int SCROLL_SPEED = 3; // in pixels per frame
    private static final int STOP_LINE = 6; // the line number to stop at

    private String[] credits = {
            "",
            "PROJECT BY GROUP 1",
            "",
            "TITLE 1",
            "SANDEEP PARDHI",
            "",
            "Done 99.99999% of the project",
            "HARDIK KOLGE",
            "",
            "0.000001% of everything",
            "RITESH THORAT",
            "",
            "TITLE 4",
            "GAYATRI MEHRA",
            "",
            "TITLE 5",
            "SAHIL MORE",
            "",
            "TITLE 6",
            "BHAVESH NIGADE",
            "",
            "TITLE 7",
            "ZAHID NEVREKAR",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "THANK YOU"
    };

    private int y = PANEL_HEIGHT + LINE_HEIGHT; // start position
    private Timer timer;

    public EndCredits() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);
        setFont(new Font("SansSerif", Font.BOLD, 20));
        timer = new Timer(16, this); // 60 fps
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        int lineNum = 0;
        for (String credit : credits) {
            g2d.drawString(credit, PANEL_WIDTH / 2 - g2d.getFontMetrics().stringWidth(credit) / 2,
                    y + lineNum * LINE_HEIGHT);
            lineNum++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        y -= SCROLL_SPEED;
        if (y + credits.length * LINE_HEIGHT < STOP_LINE * LINE_HEIGHT) {
            timer.stop();
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new EndCredits());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        try {
            Thread.sleep(20000);
            frame.dispose();
            new pageOne().setVisible(true);
            ;// sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
