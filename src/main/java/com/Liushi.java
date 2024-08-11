package com;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Liushi {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Click Example");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");





        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
